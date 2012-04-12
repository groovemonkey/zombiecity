(def furnituretypes
  {


   ;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; residential furniture
   ;;;;;;;;;;;;;;;;;;;;;;;;;
   
   :bed {
         :bed-modern {
                      :description "A stylish, modern bed.  All chrome and anodized anthracite-grey metal, this thing probably impressed the ladies before they became flesh-crazed zombies."
                      :usable false
                      :blood-smeared false
                      }

         :bed-old {
                   :description "This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace."
                   :usable false
                   :blood-smeared false
                   }
         
         :bed-broken {
                      :description "A once-beautiful bed, now totally destroyed.  The sheets have been ripped off the bed and the mattress is bloody and torn.  Something horrible happened here."
                      :usable false
                      :blood-smeared true
                      }
         }

   :counter {
             :all-purpose-counter {
                           :description "An all-purpose counter; built sturdy and kept clean."
                           :usable false
                           :blood-smeared false
                           }
             }


   ;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; office furniture
   ;;;;;;;;;;;;;;;;;;;;;;;;;




   ;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; special-location furniture
   ;;;;;;;;;;;;;;;;;;;;;;;;;
   :hairdresser-stations {
                          :hair-stations {
                                          :description "A row of hairdresser's stations, the same as they've been for fifty years. Weird pump-height chair, giant wall mirror"
                                          :usable false
                                          :blood-smeared false
                                          }
                          }

   :retail-waiting-area {
                         :hairdresser {
                                       :description "A few simple chairs and a leather couch, arranged around a magazine-covered coffee table. Fashion magazines. You shudder."
                                       ;; usable items have functions
                                       ;; that are run when they're used.
                                       :usable #(println "this is usable")
                                       :blood-smeared false
                                       }
                         }

   :retail-counter {
                    :hairdresser {
                                  :description "A small point-of-sale counter where customers could pay for their haircuts, if there were power, and there were customers, and things like haircuts still mattered. It's unlikely that anyone will be using it soon."
                                  :usable false
                                  :blood-smeared true
                                  }
                    }

   :hairdresser-equipment-cabinet {
                                   :description "A cabinet containing...well, whatever a hairdresser might need, you suppose."
                                   :required-items []
                                   :allowed-items [
                                                   :hairspray
                                                   :scissors
                                                   :straight-razor
                                                   :comb
                                                   :battery
                                                   ]
                                   :usable false
                                   :blood-smeared false
                                   }
   


   })
