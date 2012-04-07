;; prototype -- functions and stuff for Zombie City.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


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

(defn generate-grid-paths
  "Takes a grid hashmap and modifies it to include streets/hallways.  Number of paths is based on size of the grid. For now, this simply marks each point with :street ["street1"]. Right now, EVERYTHING HAS A STREET. TODO: implement original, complex street idea (direction changes, dead-ends, etc)."
;;  [grid]
;;  (dosync
;;   (doseq [coordinate grid]
;;     (assoc-in @grid [(first coordinate) :streets] "street1")))
  )

(defn generate-grid-nodes
  "Takes a grid with defined paths and adds nodes to grid-points that have a path attached.  These nodes are either buildings (if a world-map is passed in), units (if a unit-building-map such as an apartment building map is passed in), or rooms (if a single unit's map is passed in)."
  [grid]
  
  )

(defn generate-buildings
  "Takes a world-grid, adds streets, and generates buildings along the streets.  Number of buildings is determined by number of streets at the given point.  Type of buildings is determined by the probability listed in the 'building type probability' hashmap. TODO: currently just adds four buildings to each coordinate."
  [world-grid]
  (generate-grid-paths world-grid)
  (generate-grid-nodes world-grid)
  ;; for each coordinate
  ;; 

  )



;; ON BUILDING ACCESS
(defn enter-building
  "Generate the contents of a building, based on type. If it's a multi-unit or multi-room building, generate a grid for it; otherwise it's a single-room building and we call the furniture-generation function."
  [building]
  (cond
   (= (not (or :hairdresser :gun-shop)) (building :type))
   
   ;; generate a grid, using the first and second value from the
   ;; building-type's :min-max-grid-size attribute.
   (println "generate-building-grid (random (nth (building :type :min-max-grid-size) 0) (nth (building :type :min-max-grid-size) 1))")

   ;;otherwise, it's a single-room building. Populate it with furniture.
   (println "generate-room")
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
