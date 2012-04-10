(ns zombiecity.prototype)

(def buildingtypes
  {
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; sample multi-unit-building
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   :apartment-building {
                        :min-max-grid-size [2 3 4 5 6] ;; UNUSED list
                        :max-stories [1 2 3 4 5 6 7] ;; UNUSED - max stories it can have
                        :min-max-rooms [3, 10] ;; UNUSED - each
                                               ;;apartment has a
                                               ;; max
                        :required-rooms {;; at least one required, but
                                         ;; max is the number-value.
                                         :bedroom 3
                                         :kitchen 1
                                         :bathroom 2
                                         }
                        :allowed-rooms {;;not required, max is the
                                  ;;number value
                                        :office 2
                                        :living-room 2
                                        :dining-room 1
                                        :storage-room 2
                                        }
                        }
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; sample single-unit-building
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   :hairdresser {
                 :max-stories 1
                 :min-max-rooms 1
                 :required-rooms {:hairdresser-room 1}
                 :allowed-rooms {}
                 }




   }
  )