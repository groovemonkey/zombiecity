(ns user-input)
(:use player prototype)

;; main marshalling function
(defn process-user-choice
  "Takes a string argument (from read-line) and dispatches to different actions based on that. TODO: make multifn?"
  [playerchoice]
  (let [splitchoice (map #(.toLowerCase %) (.split playerchoice " "))
        choice (first splitchoice)
        args (rest splitchoice)] ;; ("args" "in" "a" "list")
  (cond
   (= choice "look") (view-currentlocation)
   (= choice "move") "dostuff"
   )))

;; functions for all actions
(defn take
  "Pick something up"
  [target &args]
  ;; if there's a take-able "target" in the room, remove it from the
  ;; room and add it to the inventory.
  )


(defn fight
  [target &args]
  ;; check in the currentlocation if there's a fightable entity
  ;; present with the type "target"

  ;; if not, return "Calm down, there's no "target"s to fight here."
  )
