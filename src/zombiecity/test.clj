;; this is insane
(defn generate-room
  "generate furniture for a room. takes a building-type keyword as an argument; generates a room and returns it in ':room-type [contents]' format."
  [building-type]
  ;; randomly choose from required/allowed rooms for this building-type
  (let [chosenroom (keyword (rand-nth (flatten (into (vector) (conj (keys (get-in buildingtypes [building-type :allowed-rooms])) (keys (get-in buildingtypes [building-type :required-rooms])))))))]

    ;; build/return a hash map of :chosenroom [contents]
    (hash-map chosenroom (into (vector) (flatten
              
    ;; for each of this room's required and allowed furniture types
    (for [furniture-type (flatten (conj  (get-in roomtypes [chosenroom :allowed-furniture])))]
      
      ;; choose an actual item from that type
         (let [chosen-item (rand-nth (keys (get-in furnituretypes [furniture-type])))]
        (list chosen-item)
        )))))))

;;rewrite:

(defn generate-room2
  "generate furniture for a room. takes a building-type keyword as an argument; generates a room and returns it in ':room-type [contents]' format."
  [building-type]
  ;; randomly choose from required/allowed rooms for this building-type
  (let [chosenroom (keyword (rand-nth (flatten (into (vector) (conj (keys (get-in buildingtypes [building-type :allowed-rooms])) (keys (get-in buildingtypes [building-type :required-rooms])))))))]

    ;; build/return a hash map of :chosenroom [contents]
    (hash-map chosenroom (into (vector) (flatten
        
    ;; for each required furniture type:
    (doseq [furniture-type (get-in roomtypes [chosenroom :required-furniture])]
      ;randomly choose a specific item of that type
      (let [chosen-item (rand-nth (keys (get-in furnituretypes [furniture-type])))]
        (list chosen-item))))))))
    