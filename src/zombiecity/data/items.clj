(ns zombiecity.data.items)

(def itemlist
  {

   ;;;;;;;;;;;;;;;
   ;; Weapons
   ;;;;;;;;;;;;;;;

   :glock9mm {
              :class :weapon
              :type :ranged
              :damage 25
              :accuracy 8
              :defense 1
              :weight 2
              }

   :AR-15 {
           :class :weapon
           :type :ranged
           :damage 36
           :accuracy 16
           :defense 3
           :weight 5
              }

   :straight-razor {
                    :class :weapon
                    :type :melee
                    :damage 8
                    :defense 0
                    :weight 0.3
                    }

   :chair-leg {
               :class :weapon
               :type :melee
               :damage 3
               :defense 3
               :weight 2
               }

   :trashcan-lid {
                  :class :weapon
                  :type :melee
                  :damage 2
                  :defense 6
                  :weight 3
                  }
   :fork {
                  :class :weapon
                  :type :melee
                  :damage 3
                  :defense 0
                  :weight 0.1
          }

   :knife-steak {
                 :class :weapon
                 :type :melee
                 :damage 8
                 :defense 1
                 :weight 0.2
                 }


   
   ;;;;;;;;;;;;;;;
   ;; Ammunition
   ;;;;;;;;;;;;;;;

   :9mm-ammo {
              :class :ammo
              :weight 1
              :min-max-amount [5 200]
              }



   ;;;;;;;;;;;;;;;
   ;; Chemicals
   ;;;;;;;;;;;;;;;

   :hairspray {
               :class :chemical
               :weight 0.5
               }




   ;;;;;;;;;;;;;;;
   ;; Ingestibles
   ;;;;;;;;;;;;;;;

   :cat-food {
              :class :food
              :healing 3
              :energy 5
              :weight 0.1
              }

   :spoiled-food {
                  :class :food
                  :healing -7
                  :energy 2
                  :weight 0.1
                  }

   

   ;;;;;;;;;;;;;;;
   ;; Clothing
   ;;;;;;;;;;;;;;;

   :kevlar-vest {
                 :class :clothing
                 :melee-protection 3
                 :firearm-protection 10
                 :chemical-protection 2
                 :infection-protection 2
                 }

   :raincoat {
                 :class :clothing
                 :melee-protection 1
                 :firearm-protection 1
                 :chemical-protection 10
                 :infection-protection 10
                 }


   ;;;;;;;;;;;;;;;
   ;; Special Items
   ;;;;;;;;;;;;;;;


   })