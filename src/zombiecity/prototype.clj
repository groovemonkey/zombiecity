;; prototype -- functions and stuff for Zombie City.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(ns zombiecity.prototype)
(use player)

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
  [location attachment]
  (def worldgrid (assoc-in worldgrid location attachment))
  )


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
    (attach-to-worldgrid (vector (coord 0)) {:buildings {:east {(choose-random-building-type) {}}
                                            :west {(choose-random-building-type) {}}
                                            :north {(choose-random-building-type) {}}
                                            :south {(choose-random-building-type) {}}}})
    ))


(defn generate-world
  "Generate the city grid and buildings."
  [size]
  (def worldgrid (generate-grid size))
  (generate-buildings worldgrid)
  
)




;; PLAYER MOVEMENT

(defn move
  "move the player's currentlocation to a new point. Run necessary actions like building generation, etc. Takes a KEY -- building, direction; whatever is visible from the currentlocation -- as an argument and adds it to the currentlocation vector."
  [place]
  ;; TODO: is there a less hamfisted way to do this? (redefining
  ;; player with the new :place added to the :currentlocation map)
  (def player (assoc-in player [:currentlocation] (conj (player :currentlocation) (keyword place))))
  )

(defn exit-location
  "remove the last item on the player's currentlocation vector."
  []
  

  )

(defn view-currentlocation
  "looks around at the objects visible at the current playerlocation."

  )


(defn enter-building
  "Generate the contents of a building, based on type. If it's a multi-unit or multi-room building, generate a grid for it; otherwise it's a single-room building and we call the furniture-generation function."
  [building]
  (cond
   (= (not (or :hairdresser :gun-shop)) (building :type))
   
   ;; generate a grid, using the first and second value from the
   ;; building-type's :min-max-grid-size attribute.
   (attach-building-grid (location building)
                         (generate-grid (random (nth (building :type :min-max-grid-size) 0) (nth (building :type :min-max-grid-size) 1))))

   ;;otherwise, it's a single-room building. Populate it with
   ;;furniture and attach to the worldgrid.
   (attach-room (location building) (generate-room building))
   )
  
  )


(defn generate-multiunit-building-grid
  "Create a multi-unit building grid. This applies to apartment and office buildings, which each have many sub-units. Takes an address argument so it knows where to attach the new hashmap."
  [world-grid-address]

  )


(defn generate-unit-grid
  "Generate the grid for a single multi-room unit: houses, apartments, offices, etc."
  [world-grid-address]
  
  )



;; ON ROOM ACCESS
(defn generate-room
  "Generate furniture for a room."
  []

  )

;; navigation function -- being able to move along a street


;; player model
;;;;;current location, inventory, skills, health, energy, weight-capacity


;; narration model
;;;;;;proper description of surroundings (buildings, furniture, items)
;;;;;;proper description of streets (which direction they go)




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
