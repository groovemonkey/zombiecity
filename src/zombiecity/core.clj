;; prototype -- functions and stuff for Zombie City.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(ns zombiecity.core
  (:gen-class)
  (:use [clojure.core.incubator :only [dissoc-in]])
  (:use zombiecity.data.buildings zombiecity.data.furniture zombiecity.data.items zombiecity.data.rooms))

;;TODO: still needed after removing worldgrid global from functions? (i.e. when we're passing the worldgrid object in?)
(declare worldgrid)

(def player
  (ref
  {:currentlocation [:a1]
   :health 100
   :infection 0
   :inventory []
   :clothing {:head []
              :torso []
              :legs []
              :feet []
              :hands [];; max 2 items (1 in each hand)
              }
   }
  ))


;; World-grid/Street-generation functions
(defn generate-grid
  "Takes a grid-size and returns a grid hashmap. Can be used for world-grid and building-grid generation."
  [grid-size]
  (zipmap
   (for [xcoord (range grid-size)
        ycoord (range grid-size)]
            (vec [xcoord ycoord]))
          (repeat (hash-map))))


(defn attach-to-grid
  "Attach something to a grid (deref the map you pass in here). Location is the player's currentlocation, a vector of keywords, like [:grid :buildings :buildingtype :grid :roomtype]; <:roomtype> being the room that is about to be attached. The second arg-- attachment -- is a vector of the room contents, in this example."
  [grid location object]
  (dosync
   (alter grid assoc-in location object)))


(defn remove-from-grid
  "Remove an object (and its associated map) from a (dereffed) map grid -- used for picking up items, etc"
  [grid location object]
  (dosync
   (alter grid dissoc-in location object)))


;;TODO: remove when stable
(comment(defn attach-to-worldgrid
  "Attach something to the worldgrid. Location is the player's currentlocation, a vector of keywords, like [:grid :buildings :buildingtype :grid :roomtype]; <:roomtype> being the room that is about to be attached. The second arg-- attachment -- is a vector of the room contents, in this example."
  [location object]
  (dosync
   (alter worldgrid assoc-in location object))))

;;TODO remove when stable
(comment (defn remove-from-worldgrid
  "Remove an object (and its associated map) from the worldgrid -- used for picking up items, etc"
  [location object]
  (dosync
   (alter worldgrid dissoc-in location object))))



(defn connect-gridpoints
  "takes an empty, single-level grid ref (not dereffed) and connects the gridpoints using cardinal directions as keywords"
  [grid]
  (doseq [address @grid]
    ;; add cardinal directions
    (let [coord (address 0)
          x (coord 0)
          y (coord 1)
          
          ;; new coordinates
          north [x (+ y 1)]
          south [x (- y 1)]
          east  [(+ x 1) y]
          west  [(- x 1) y]
          
          ;; do these coordinates exist on the grid?
          north-exists (if (grid north) true false)
          south-exists (if (grid south) true false)
          east-exists (if (grid east) true false)
          west-exists (if (grid west) true false)] ;; end let

      (attach-to-grid grid [coord]
                      {;; display coordinates in different directions
                       :north (if north-exists north nil)
                       :south (if south-exists south nil)
                       :east (if east-exists east nil)
                       :west (if west-exists west nil)
                       }))))






(defn choose-random-building-type
  "Rolls between all building types, randomly chooses one. TODO: influence probability of choosing based on a percentage for each building-type."
  []
  (let [list-of-buildings (into (vector) (keys buildingtypes))]
       (list-of-buildings (rand-int (count (keys buildingtypes))))))


(defn generate-buildings
  "Takes a grid and generates buildings for each point.  Type of buildings is determined by the probability listed in the 'building type probability' hashmap. TODO: currently just adds four buildings to each coordinate."
  [grid]
  ;; for each coordinate
  (doseq [coord @grid]
    ;; add a :buildings map with :east :west :south :north maps;
    ;; randomly choose a building type to place there.
    (attach-to-grid grid 
                    (vector (coord 0)) {:buildings {
                        :1 {(choose-random-building-type) {}}
                        :2 {(choose-random-building-type) {}}
                        :3 {(choose-random-building-type) {}}
                        }})))


(defn generate-world
  "Generate the city grid and buildings."
  [size]
  (do
    (def worldgrid (ref (generate-grid size)))
    (connect-gridpoints worldgrid)
    (generate-buildings worldgrid)))



(defn return-current-buildingtype
  "Takes the vector (player :currentlocation)) -- recursively searches backwards through the currentlocation map until it finds a building type listed in the 'buildingtypes' variable. Returns the current building-type as a keyword."
  [playerposition]
  (cond
   (empty? playerposition)
   (println "Holy shit, you're not in a building! DEBUG TRACE: return-current-buildingtype")
   
   (contains? buildingtypes (last playerposition))
   (keyword (last playerposition))
        
  ;;else recursively search through the currentlocation vector until
  ;;we find a building type
   :else (recur (pop playerposition))))



(defn generate-room
  "generate furniture for a room. takes a building-type keyword as an argument; generates a room and returns it in ':room-type [contents]' format."
  [building-type]
  ;; randomly choose from required/allowed rooms for this building-type
  (let [chosenroom (keyword (rand-nth (flatten (into (vector) (conj (keys (get-in buildingtypes [building-type :allowed-rooms])) (keys (get-in buildingtypes [building-type :required-rooms])))))))]

    ;; build/return a hash map of :chosenroom [contents]
    (hash-map chosenroom (into (vector) (flatten
              
    ;; for each of this room's required and allowed furniture types
    (for [furniture-type (flatten (conj (get-in roomtypes [chosenroom :required-furniture]) (get-in roomtypes [chosenroom :allowed-furniture])))]
      
      ;; choose an actual item from that type
         (let [chosen-item (rand-nth (keys (get-in furnituretypes [furniture-type])))]
        (list chosen-item)
        )))))))
   

(defn populate-space
  "Generate the contents of the player's currentlocation, based on type. If it's a multi-unit or multi-room building, generate a grid, unit grid, and rooms for it; otherwise it's a single-room building and we just call the room-generation function."
  [grid]
  (let
      [single-unit-types [:hairdresser :gun-shop :kitchen :bedroom :bathroom :living-room]
       multi-unit-types [:office-building :apartment-building]
       current-building-type (return-current-buildingtype (player :currentlocation))]
    
    ;; if the building we're in is one of the single-unit types...
    (if (not (contains? multi-unit-types current-building-type))
      (attach-to-grid @grid (player :currentlocation) (generate-room current-building-type))

   ;; otherwise: generate a grid, using the values 
   ;; from the building-type's :min-max-grid-size attribute.
   (do (attach-to-grid @grid (player :currentlocation)
        (generate-grid (rand-nth
        (get-in buildingtypes [current-building-type :min-max-grid-size]))))
     
     ;; at each newly generated 'unit', generate a 'rooms' grid
       (doseq [coord (get-in @grid (player :currentlocation))]
              (let [unit (keyword (coord 0))]
                   ;; WORKS -- rooms grid
                   (attach-to-grid @grid (conj (player :currentlocation) unit)
                                        (generate-grid 2))

  ;; for each room, generate room contents
  (doseq [roomsgrid (get-in @worldgrid (conj (player :currentlocation) unit))]
    (let [room (keyword (roomsgrid 0))]
         ;; attach rooms
      (attach-to-grid @grid (conj (conj (player :currentlocation) unit) room) (generate-room current-building-type))))))))))



;;;;; SKILL DEVELOPMENT
;; exp. buys skill upgrades

;; display skills

;; upgrade a skill -- calculate skill points needed, subtract from
;; inventory, and +1 the skill.




;;;;; COMBAT

;; fire weapon -- subtract ammo from inventory

;; Calculate damage based on which body part was hit.  Take base
;; weapon damage as an arg.

;; calculate experience for kill, add to player exp.
