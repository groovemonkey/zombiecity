(ns zombiecity.main)
(:use prototype user-input)


;; create worldgrid and buildings
(generate-world)



;; PLAYER LOOP
(view-currentlocation)
(println "What do you do next?")
(process-user-choice (read-line))
