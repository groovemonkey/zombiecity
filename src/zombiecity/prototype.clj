;; prototype -- functions and stuff for Zombie City.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(ns zombiecity.prototype)
(:use [clojure.core.incubator :only [dissoc-in]])
(:use player buildings items rooms user-input world-generation)

;; World-grid/Street-generation functions
(defn generate-grid
  "Takes a grid-size and returns a grid hashmap. Can be used for world-grid and building-grid generation."
  [grid-size]
  (zipmap
   (for [xcoord (.subSequence "abcdefghijklmnopqrstuvwxyz" 0 grid-size)
        ycoord (range grid-size)]
            (keyword (str xcoord ycoord)))
          (repeat (hash-map)))
  )


(defn attach-to-worldgrid
  "Attach something to the worldgrid. Location is the player's currentlocation, a vector of keywords, like [:grid :buildings :buildingtype :grid :roomtype]; <:roomtype> being the room that is about to be attached. The second arg-- attachment -- is a vector of the room contents, in this example."
  [location object]
  (def worldgrid (assoc-in worldgrid location object))
  )

(defn remove-from-worldgrid
  "Remove an object (and its associated map) from the worldgrid -- used for picking up items, etc"
  [location object]
  (def worldgrid (dissoc-in worldgrid location object)))


(defn choose-random-building-type
  "Rolls between all building types, randomly chooses one. TODO: influence probability of choosing based on a percentage for each building-type."
  []
  (let [list-of-buildings (into (vector) (keys buildingtypes))]
       (list-of-buildings (rand-int (count (keys buildingtypes))))))


(defn generate-buildings
  "Takes a world-grid and generates buildings for each point.  Type of buildings is determined by the probability listed in the 'building type probability' hashmap. TODO: currently just adds four buildings to each coordinate."
  []
  ;; for each coordinate
  (doseq [coord worldgrid]
    ;; add a :buildings map with :east :west :south :north maps;
    ;; randomly choose a building type to place there.
    (attach-to-worldgrid (vector (coord 0)) {:buildings {
                        :east {(choose-random-building-type) {}}
                        :west {(choose-random-building-type) {}}
                        :north {(choose-random-building-type) {}}
                        :south {(choose-random-building-type) {}}}})))


(defn generate-world
  "Generate the city grid and buildings."
  [size]
  (def worldgrid (generate-grid size))
  (generate-buildings))



(defn return-current-buildingtype
  "Takes the vector (player :currentlocation)) -- returns the current building-type as a keyword. Used to see what kind of rooms should be generated."
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
  "Generate furniture for a room."
  [building-type]
  ;; randomly choose from required rooms for this building-type
  (let [chosenroom (keyword (rand-nth (into (vector) (conj (keys (get-in buildingtypes [building-type :allowed-rooms])) (keys (get-in buildingtypes [building-type :required-rooms]))))))]
    (println chosenroom)))
    
  

   



(defn populate-space
  "Generate the contents of the player's currentlocation, based on type. If it's a multi-unit or multi-room building, generate a grid, unit grid, and rooms for it; otherwise it's a single-room building and we call the room-generation function directly."
  []
  (let
      [single-unit-types [:hairdresser :gun-shop :kitchen :bedroom :bathroom :living-room]
       multi-unit-types [:office-building :apartment-building]
       current-building-type (return-current-buildingtype (player :currentlocation))]
    
    ;; if the building we're in is one of the single-unit types...
  (if (contains? single-unit-types current-building-type)
   (generate-room current-building-type)

   ;; otherwise: generate a grid, using the values 
   ;; from the building-type's :min-max-grid-size attribute.
   (do (attach-to-worldgrid (player :currentlocation)
        (generate-grid (rand-nth
        (get-in buildingtypes [current-building-type :min-max-grid-size]))))
     
     ;; at each newly generated 'unit', generate a 'rooms' grid
       (doseq [coord (get-in worldgrid (player :currentlocation))]
              (let [unit (keyword (coord 0))]
                   ;; WORKS -- rooms grid
                   (attach-to-worldgrid (conj (player :currentlocation) unit)
                                        (generate-grid 2))

  ;; for each room, generate room contents
  (doseq [roomsgrid (get-in worldgrid (conj (player :currentlocation) unit))]
    (let [room (keyword (roomsgrid 0))]
         ;; attach rooms
         ;(let [room (conj (conj (player :currentlocation) unit
      (attach-to-worldgrid (conj (conj (player :currentlocation) unit) room) (generate-room current-building-type))))))))))



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
