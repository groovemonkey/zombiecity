(ns zombiecity.userinput
(:use zombiecity.core))

;;;;; SUPPORT FUNCTIONS
(defn is-object-here?
  "Boolean; takes a string argument, turns it into a keyword, and checks if there's anything by that name in the current location."
  [grid object-string]
  (contains? (get-in @grid (player :currentlocation)) (keyword object-string))
  )


(defn add-to-inventory
  "add an item to the inventory (if it's a collection, just prune the whole thing out of the worldgrid map). Takes a string arg."
  [grid object]
  ;; add to inventory
  (dosync
   (alter player assoc ((player :inventory) 0) (get-in @worldgrid (conj (player :currentlocation) (keyword object)))))

  ;; remove from world
  (remove-from-grid @grid (player :currentlocation) (keyword object)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; functions for all actions
(defn take-item
  "Pick something up"
  [grid target &args]
  ;; if there's a take-able "target" in the room
  (cond (is-object-here? grid target)
        ;; take it from the world
        (add-to-inventory grid target)
        :else (println "There's no" target "to take.")))


(defn move
  "move the player's currentlocation to a new point. Run necessary actions like building generation, etc. Takes a LIST -- building, direction; whatever is visible from the currentlocation -- as an argument and adds it to the currentlocation vector."
  [grid playerchoice]
   ;; check if the option can be seen from the player's currentlocation
  (let [gridlocation (get-in @grid (player :currentlocation))
        place (keyword playerchoice)]
   (do
     (println "DEBUG: playerchoice was" playerchoice
              "\n\ngridlocation:" gridlocation
              "\nplace is" place
              "\n(keys gridlocation) is" (keys gridlocation))
     ;; place has to be in a list, because clojure returns a list for (keys gridlocation) but won't let me call 'first' on it; saying it's a keyword...arghhh.
     (if (= (list place) (keys gridlocation))
       ;; change the player's currentlocation to make the move
       (dosync
         (alter player assoc-in [:currentlocation] (conj (player :currentlocation) place)))
       ;; else
       (println "You chose a nonexistent option -- " place))
     
     ;; if the place we just moved to is empty, generate stuff for it
     (cond (empty? gridlocation)
                (populate-space grid)))))


(defn exit-location
  "remove the last item on the player's currentlocation vector. I.e. move them 'back' a step."
  []
  (dosync
  (alter player assoc-in [:currentlocation] (pop (player :currentlocation)))))


(defn view-currentlocation
  "looks around at the objects visible at the current playerlocation, and displays the options 'one up the chain' from there."
  [grid]
  (let [currentview (get-in @grid (player :currentlocation))]
    
    (println "DEBUG: currentview is" currentview)
    
    (doseq [thing currentview]
      ;;TODO: fix this crap. when you walk into a hairdresser's,
      ;;everything crashes. Apartment buildings are even more fucked
      ;;up. Get this working so we can move through the world, just to
      ;;start with.
      (println "DEBUG: thing in the currentview is" thing)
      
      (cond (or (empty? thing) (nil? thing)) (println "There's nothing here!")
            (vector? (rest thing)) (println "You see the following:\n" (rest thing))
            :else (do
                    (println "\n\nYou see a" (first thing) ", from which you have the following options:\n")
                    (doseq [one-further (get-in @grid (conj (player :currentlocation) (first thing)))]
                      (println (first one-further)))
                      )))))


(defn fight
  [target &args]
  ;; check in the currentlocation if there's a fightable entity
  ;; present with the type "target"

  ;; if not, return "Calm down, there's no "target"s to fight here."
  )



;; main marshalling function
(defn process-user-choice
  "Takes a string (from read-line) and dispatches to different actions based on that. TODO: make multifn?"
  [grid]
  (println "\n\nWhat do you do next?")
  (let [playerchoice (read-line)
        splitchoice (map #(.toLowerCase %) (.split playerchoice " "))
        choice (first splitchoice)
        args (rest splitchoice)] ;; ("args" "in" "a" "list")
  (cond
   (= choice "look") (view-currentlocation grid)
   (= choice "move") (move grid (keyword (first args)))
   (= choice "leave") (exit-location)
   (= choice "take") (take-item grid args)
   (= choice "fight") (fight args)
   (= choice "worldgrid") (println "worldgrid is:\n\n" @grid)
   )))