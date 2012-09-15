;; changes: -cardinal directions point at other gridpoints
;;          -:buildings is just a map of building-types (randomly up to some configurable max-number of buildings)

(def worldgrid2 {
                 [0,0] {:north [0, 1]
                        :south nil
                        :east [1, 0]
                        :west nil
                        :buildings {:apartment-building {}
                                    :hairdresser {}
                                    }
                        }
                 })


;;;;;;;;;;;;;;
;;DONE
;; output =
;; {[2 2] {}, [2 1] {}, [2 0] {}, [1 2] {}, [1 1] {}, [1 0] {}, [0 2] {}, [0 1] {}, [0 0] {}}

(defn generate-grid2
  "Takes a grid-size and returns a grid hashmap. Can be used for world-grid and building-grid generation."
  [grid-size]
  (zipmap
   (for [xcoord (range grid-size)
        ycoord (range grid-size)]
            (vec [xcoord ycoord]))
          (repeat (hash-map))))

;;;;;;;;;;;;;;;;

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


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn generate-buildings2
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



(defn test-init
  []
  (doall
    (def wg2 (ref (generate-grid2 3)))
    (connect-gridpoints wg2)
    (generate-buildings2 wg2)
    ))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


{[2 2] {:buildings {:1 {:hairdresser {}}, :2 {:apartment-building {}}, :3 {:hairdresser {}}}},
 [2 1] {:buildings {:1 {:apartment-building {}}, :2 {:apartment-building {}}, :3 {:apartment-building {}}}},
 [2 0] {:buildings {:1 {:apartment-building {}}, :2 {:hairdresser {}}, :3 {:apartment-building {}}}}, 
 [1 2] {:buildings {:1 {:hairdresser {}}, :2 {:apartment-building {}}, :3 {:apartment-building {}}}}, 
 [1 1] {:buildings {:1 {:apartment-building {}}, :2 {:hairdresser {}}, :3 {:hairdresser {}}}}, 
 [1 0] {:buildings {:1 {:hairdresser {}}, :2 {:apartment-building {}}, :3 {:apartment-building {}}}}, 
 [0 2] {:buildings {:1 {:hairdresser {}}, :2 {:apartment-building {}}, :3 {:hairdresser {}}}}, 
 [0 1] {:buildings {:1 {:apartment-building {}}, :2 {:hairdresser {}}, :3 {:hairdresser {}}}}, 
 [0 0] {:buildings {:1 {:apartment-building {}}, :2 {:apartment-building {}}, :3 {:hairdresser {}}}}}


