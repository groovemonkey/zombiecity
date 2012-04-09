;; player model
;;TODO: skills, energy, weight-capacity

(ns zombiecity.player)

(def player
  {:currentlocation [:a1]
   :health 100
   :infection 0
   :inventory []
   :clothing {:head []
              :torso []
              :legs []
              :feet []
              :hands [];; max 2 items (1 in each hand)
              }
   }
  )
