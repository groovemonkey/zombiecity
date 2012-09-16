; create a room

;;pick a type of room for the building -- choose from (conj allowed-rooms and required-rooms)

;;for each type of furniture in the room-type's allowed/required list...

;;pick a specific furniture item of that type.

;;if the furniture item is a container, fill it





;; change so that items have another nested map under them (their attributes)

(defn generate-room
  "generate furniture for a room. takes a building-type keyword as an argument; generates a room and returns it in ':room-type [contents]' format."
  [building-type]
  ;; randomly choose from required/allowed rooms for this building-type
  (let [chosenroom (keyword (rand-nth (flatten (into (vector) (conj (keys (get-in buildingtypes [building-type :allowed-rooms])) (keys (get-in buildingtypes [building-type :required-rooms])))))))]

    ;; build/return a hash map of :chosenroom [contents]
    (hash-map chosenroom (into (hash-map)
              
    ;; for each of this room's required and allowed furniture types
    (for [furniture-type (flatten (conj (get-in roomtypes [chosenroom :required-furniture]) (get-in roomtypes [chosenroom :allowed-furniture])))]
        
      ;; choose an actual item from that type
         (let [chosen-item (rand-nth (keys (get-in furnituretypes [furniture-type])))]
           (vector chosen-item (get-in furnituretypes [furniture-type chosen-item]))
        ))))))

{:hairdresser-room {:hair-stations {:usable false, :blood-smeared false, :description "A row of hairdresser's stations, the same as they've been for fifty years. Weird pump-height chair, giant wall mirror"},
                    :hairdresser {:description "A few simple chairs and a leather couch, arranged around a magazine-covered coffee table. Fashion magazines. You shudder.", :usable #<furniture$fn__143 zombiecity.data.furniture$fn__143@35a3e41f>, :blood-smeared false},
                    :hairdresser-counter {:usable false, :blood-smeared true, :description "A small point-of-sale counter where customers could pay for their haircuts, if there were power, and there were customers, and things like haircuts still mattered. It's unlikely that anyone will be using it soon."}, :usable false, nil nil}}
