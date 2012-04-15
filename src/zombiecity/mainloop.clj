(ns zombiecity.mainloop
(:use zombiecity.prototype zombiecity.userinput))

;; create worldgrid and buildings
(defn initialize
  "Create worldgrid and buildings at a default size, for testing."
  []
  (generate-world 3)
)


;; PLAYER LOOP
(defn -main
  "Main function; needed for Leiningen."
  []
  (do
    (println "Starting the game...\n\n")
    (initialize)
    (view-currentlocation)
    (println "What do you do next?")
    (process-user-choice (read-line))
))