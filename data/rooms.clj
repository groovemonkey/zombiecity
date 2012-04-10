(def roomtypes
  {
   ;; apartment-building rooms
   :bedroom {;; list only furniture TYPE?  Randomly pick specific item?
             :required-furniture [:bed, :dresser]
             :allowed-furniture [:bookcase, :computer-desk]
             }
   :bathroom {
             :required-furniture [:counter :sink :bathtub :toilet]
             :allowed-furniture [:mirror :closet :hamper :medicine-cabinet]
             }





   ;; one-room-building room
   ;; (this is listed as the only :rooms-required entry)
   :hairdresser-room {;;same as a building's allowed/required rooms.
                      :required-furniture [
                                           :hairdresser-stations, :retail-waiting-area, :retail-counter, :hairdresser-equipment-cabinet
                                            ]
                      :allowed-furniture [:magazine-rack]
                      }})