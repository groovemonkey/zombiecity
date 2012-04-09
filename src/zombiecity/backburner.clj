
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

(defn attach-building-grid
  "Attach a new building grid to a location on a map."
  [location newgrid]
  (attach-to-worldgrid location newgrid)
  )

