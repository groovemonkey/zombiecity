; create a room

;;pick a type of room for the building -- choose from (conj allowed-rooms and required-rooms)

;;for each type of furniture in the room-type's allowed/required list...

;;pick a specific furniture item of that type.

;;if the furniture item is a container, fill it


;; BUGS: when an apartment-building is generated, connect-gridpoints doesn't run properly, so
  ;; the building grid is unconnected
  ;; the apartment (unit) grid isn't connected, either

;; generate-grid should be rewritten to NOT be ref-aware. It just takes a map and connects the key-points together.
;;starting grid -- (buildinggrid)
def idealgrid {:apartment-building {[0 0] {} [0 1] {}}}

;;connect gridpoints -- working
connectedgrid = {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}

;; add rooms (not working)
;; should take the buildinggrid above (after connect gridpoints) and simply add rooms at each location
;;     (@player :currentlocation) should be [.... :apartment-building] right now
for each coordinate in connectedgrid (above)
ADD (don't replace existing, just like connect-gridpoints) a random room-type


 {[2 2] {:buildings {:1 {:hairdresser {}}, :2 {:hairdresser {}}, :3 {:gun-shop {}}}, :north nil, :south [2 1], :east nil, :west [1 2]}, 
  [2 1] 
  {:buildings 
   {:1 {:gun-shop {}}, :2 {:hairdresser {}}, 
    :3 {:apartment-building 
        {[2 1] {[1 1] {:living-room {nil nil}}, 
                [1 0] {:storage-room {nil nil}}, 
                [0 1] {:office {nil nil}}, 
                [0 0] {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}}, 
         
         [3 2] {[1 1] {:bedroom {:bed-broken {:usable false, :blood-smeared true, :description A once-beautiful bed, now totally destroyed.  The sheets have been ripped off the bed and the mattress is bloody and torn.  Something horrible happened here.}, nil nil}}, 
                [1 0] {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
                [0 1] {:bedroom {:bed-broken {:usable false, :blood-smeared true, :description A once-beautiful bed, now totally destroyed.  The sheets have been ripped off the bed and the mattress is bloody and torn.  Something horrible happened here.}, nil nil}}, 
                [0 0] {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}}, 
         
         [4 3] {[1 1] {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}, 
                [1 0] {:storage-room {nil nil}}, 
                [0 1] {:bedroom {:bed-broken {:usable false, :blood-smeared true, :description A once-beautiful bed, now totally destroyed.  The sheets have been ripped off the bed and the mattress is bloody and torn.  Something horrible happened here.}, nil nil}}, 
                [0 0] {:office {nil nil}}}, 
         
         [5 4] {[1 1] {:storage-room {nil nil}}, 
                [1 0] {:office {nil nil}}, 
                [0 1] {:storage-room {nil nil}}, 
                [0 0] {:storage-room {nil nil}}}, }}}}}
         ;;; ...etc               
                                                                         
                                                                         
                                                                         
                                                                         
                                                                         