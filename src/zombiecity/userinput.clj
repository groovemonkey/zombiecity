(ns userinput
(:use zombiecity.data.player))

(declare worldgrid)
(declare remove-from-worldgrid)

;;;;; SUPPORT FUNCTIONS
(defn is-object-here?
  "Boolean; takes a string argument, turns it into a keyword, and checks if there's anything by that name in the current location."
  [object-string]
  (contains? (get-in worldgrid (player :currentlocation)) (keyword object-string))
  )


(defn add-to-inventory
  "add an item to the inventory (if it's a collection, just prune the whole thing out of the worldgrid map). Takes a string arg."
  [object]
  ;; add to inventory
  (assoc (player :inventory) 0 (get-in worldgrid (conj (player :currentlocation) (keyword object))))

  ;; remove from world
  (remove-from-worldgrid (player :currentlocation) (keyword object)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; functions for all actions
(defn take-item
  "Pick something up"
  [target &args]
  ;; if there's a take-able "target" in the room
  (cond (is-object-here? [target])
        ;; take it from the world
        (add-to-inventory target)
        :else (println "There's no" target "to take.")))


(defn move
  "move the player's currentlocation to a new point. Run necessary actions like building generation, etc. Takes a KEY -- building, direction; whatever is visible from the currentlocation -- as an argument and adds it to the currentlocation vector."
  [place]
  ;; TODO: is there a less hamfisted way to do this? (redefining
  ;; player with the new :place added to the :currentlocation map)
  (def player (assoc-in player [:currentlocation] (conj (player :currentlocation) (keyword place))))

  ;; if the place we just moved to is empty, generate some
  ;; stuff for it TODO: I smell an inventory exploit here (take
  ;; everything from a closet, and it regenerates as soon as you go
  ;; back into it). Fix that. ? Add a 'been-here' attribute to containers?
  (cond (empty? (get-in worldgrid (player :currentlocation)))
                (populate-space)))


(defn exit-location
  "remove the last item on the player's currentlocation vector. I.e. move them 'back' a step."
  []
  (def player (assoc-in player [:currentlocation] (pop (player :currentlocation)))))


(defn view-currentlocation
  "looks around at the objects visible at the current playerlocation."
  []
  (let [currentview (get-in worldgrid (player :currentlocation))]
    (doseq
        [thing currentview]
      (println "You see a" thing))))


(defn fight
  [target &args]
  ;; check in the currentlocation if there's a fightable entity
  ;; present with the type "target"

  ;; if not, return "Calm down, there's no "target"s to fight here."
  )



;; main marshalling function
(defn process-user-choice
  "Takes a string argument (from read-line) and dispatches to different actions based on that. TODO: make multifn?"
  [playerchoice]
  (let [splitchoice (map #(.toLowerCase %) (.split playerchoice " "))
        choice (first splitchoice)
        args (rest splitchoice)] ;; ("args" "in" "a" "list")
  (cond
   (= choice "look") (view-currentlocation)
   (= choice "move") (move args)
   (= choice "leave") (exit-location)
   (= choice "take") (take-item args)
   (= choice "fight") (fight args)
   )))