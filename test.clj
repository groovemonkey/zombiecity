; create a room

;;pick a type of room for the building -- choose from (conj allowed-rooms and required-rooms)

;;for each type of furniture in the room-type's allowed/required list...

;;pick a specific furniture item of that type.

;;if the furniture item is a container, fill it


;; new generate-buildings output:
{[2 2] {:buildings {
                    :1 {:hairdresser {}}, 
                    :2 {:apartment-building {}}, 
                    :3 {:apartment-building {}}
                    }, 
        :north nil, 
        :south [2 1], 
        :east nil, 
        :west [1 2]}, 
 
 [2 1] {:buildings {:1 {:apartment-building {}}, :2 {:apartment-building {}}, :3 {:apartment-building {}}}, :north [2 2], :south [2 0], :east nil, :west [1 1]}, [2 0] {:buildings {:1 {:hairdresser {}}, :2 {:hairdresser {}}, :3 {:apartment-building {}}}, :north [2 1], :south nil, :east nil, :west [1 0]}, [1 2] {:buildings {:1 {:hairdresser {}}, :2 {:hairdresser {}}, :3 {:hairdresser {}}}, :north nil, :south [1 1], :east [2 2], :west [0 2]}, [1 1] {:buildings {:1 {:apartment-building {}}, :2 {:apartment-building {}}, :3 {:apartment-building {}}}, :north [1 2], :south [1 0], :east [2 1], :west [0 1]}, [1 0] {:buildings {:1 {:hairdresser {}}, :2 {:hairdresser {}}, :3 {:hairdresser {}}}, :north [1 1], :south nil, :east [2 0], :west [0 0]}, [0 2] {:buildings {:1 {:apartment-building {}}, :2 {:apartment-building {}}, :3 {:hairdresser {}}}, :north nil, :south [0 1], :east [1 2], :west nil}, [0 1] {:buildings {:1 {:apartment-building {}}, :2 {:apartment-building {}}, :3 {:apartment-building {}}}, :north [0 2], :south [0 0], :east [1 1], :west nil}, [0 0] {:buildings {:1 {:hairdresser {}}, :2 {:hairdresser {}}, :3 {:apartment-building {}}}, :north [0 1], :south nil, :east [1 0], :west nil}}
