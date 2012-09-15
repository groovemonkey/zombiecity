(ns zombiecity.mainloop
  (:use zombiecity.userinput
        zombiecity.core
        ))


;; create worldgrid and buildings
(defn initialize
  "Create worldgrid and buildings at a default size, for testing."
  []
  (generate-world 3))


;; PLAYER LOOP
(defn -main
  "Main function; needed for Leiningen."
  []
  (do
    (println "Starting the game...\n\n")
    (initialize)
    (while true
      (do
      (view-currentlocation)
      (process-user-choice worldgrid))
)))