; create a room

;;pick a type of room for the building -- choose from (conj allowed-rooms and required-rooms)

;;for each type of furniture in the room-type's allowed/required list...

;;pick a specific furniture item of that type.

;;if the furniture item is a container, fill it


;; BUGS: when an apartment-building is generated, connect-gridpoints doesn't run properly, so
  ;; the building grid is unconnected
  ;; the apartment (unit) grid isn't connected, either

;; generate-grid should be rewritten to NOT be ref-aware. It just takes a map and connects the key-points together.

;;current -- :building :bgrid :roomgrid
{[2 2] 
 {:buildings 
  {:1 
   {:apartment-building 
    {[2 1] 
     {:north {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}, 
      :south {:bedroom {:bed-modern {:usable false, :blood-smeared false, :description A stylish, modern bed.  All chrome and anodized anthracite-grey metal, this thing probably impressed the ladies before they became flesh-crazed zombies.}, nil nil}}, 
      :east {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description ""blah""}, nil nil}}, 
      :west {:living-room {nil nil}}}, 
     [3 2] {:north {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :south {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}, 
            :east {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :west {:office {nil nil}}}, 
     #<Ref@72898540: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, 
                      [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, 
                      [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, 
                      [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, 
     
     #<Ref@7a22ce00: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, 
                      [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, 
                      [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, 
                      [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil,
     
     [1 0] {:north {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :south {:office {nil nil}}, 
            :east {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :west {:storage-room {nil nil}}}, 
     
     [2 2] {:north {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :south {:office {nil nil}}, 
            :east {:dining-room {nil nil}}, 
            :west {:dining-room {nil nil}}}, 
     
     [3 3] {:north {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :south {:storage-room {nil nil}},                                                                                                  
            :west {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}}, 
     
     [0 0] {:north {:office {nil nil}}, 
            :south {:bedroom {:bed-modern {:usable false, :blood-smeared false, :description A stylish, modern bed.  All chrome and anodized anthracite-grey metal, this thing probably impressed the ladies before they became flesh-crazed zombies.}, nil nil}}, 
            :east {:bedroom {:bed-modern {:usable false, :blood-smeared false, :description A stylish, modern bed.  All chrome and anodized anthracite-grey metal, this thing probably impressed the ladies before they became flesh-crazed zombies.}, nil nil}}, 
            :west {:living-room {nil nil}}}, 
     
     [1 1] {:north {:storage-room {nil nil}}, 
            :south {:storage-room {nil nil}}, 
            :east {:living-room {nil nil}}, 
            :west {:office {nil nil}}}, 
     
     [2 3] {:north {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :south {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :east {:office {nil nil}}, 
            :west {:bedroom {:bed-modern {:usable false, :blood-smeared false, :description A stylish, modern bed.  All chrome and anodized anthracite-grey metal, this thing probably impressed the ladies before they became flesh-crazed zombies.}, nil nil}}}, 
     
     [0 1] {:north {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}, 
            :south {:storage-room {nil nil}}, 
            :east {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :west {:dining-room {nil nil}}}, 
     
     [1 2] {:north {:storage-room {nil nil}}, 
            :south {:dining-room {nil nil}}, 
            :east {:dining-room {nil nil}}, 
            :west {:storage-room {nil nil}}}, 
     
     [0 2] {:north {:storage-room {nil nil}}, 
            :south {:living-room {nil nil}}, 
            :east {:dining-room {nil nil}}, 
            :west {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}}, 
     
     [1 3] {:north {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            :south {:office {nil nil}}, 
            :east {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description "blah"}, nil nil}}, 
            :west {:bedroom {:bed-modern {:usable false, :blood-smeared false, :description A stylish, modern bed.  All chrome and anodized anthracite-grey metal, this thing probably impressed the ladies before they became flesh-crazed zombies.}, nil nil}}}, 
     
     #<Ref@365bf624: {[1 1] {:north nil, 
                             :south [1 0], 
                             :east nil, 
                             :west [0 1]}, 
                      [1 0] {:north [1 1], 
                             :south nil, 
                             :east nil, 
                             :west [0 0]}, 
                      [0 1] {:north nil, 
                             :south [0 0], 
                             :east [1 1], 
                             :west nil}, 
                      [0 0] {:north [0 1], 
                             :south nil, 
                             :east [1 0], 
                             :west nil}}> nil, 
     
     [0 3] {:north {:office {nil nil}}, 
            :south {:office {nil nil}}, 
            :east {:storage-room {nil nil}},
            :west {:bedroom {:bed-modern {:usable false, :blood-smeared false, :description A stylish, modern bed.  All chrome and anodized anthracite-grey metal, this thing probably impressed the ladies before they became flesh-crazed zombies.}, nil nil}}}, 
     
     #<Ref@108f2ca6: {[1 1] {:north nil, 
                             :south [1 0], 
                             :east nil, 
                             :west [0 1]}, 
                      [1 0] {:north [1 1], 
                             :south nil, 
                             :east nil, 
                             :west [0 0]}, 
                      [0 1] {:north nil, 
                             :south [0 0], 
                             :east [1 1], 
                             :west nil}, 
                      [0 0] {:north [0 1], 
                             :south nil,
                             :east [1 0],
                             :west nil}}> nil, 
     
     #<Ref@7d0c3a08: {[1 1] {:north nil, 
                             :south [1 0], 
                             :east nil, 
                             :west [0 1]}, 
                      [1 0] {:north [1 1], 
                             :south nil, 
                             :east nil, 
                             :west [0 0]}, 
                      [0 1] {:north nil, 
                             :south [0 0], 
                             :east [1 1], 
                             :west nil}, 
                      [0 0] {:north [0 1], 
                             :south nil, 
                             :east [1 0], 
                             :west nil}}> nil, 
     
     #<Ref@27bc4ec8: {[1 1] {:north nil, 
                             :south [1 0], 
                             :east nil, 
                             :west [0 1]}, 
                      
                      [1 0] {:north [1 1], 
                             :south nil, 
                             :east nil, 
                             :west [0 0]}, 
                      
                      [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@10cb42cf: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@6e37d490: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@b955970: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@746a63d3: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@13647278: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@3bd840d9: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@27972e3a: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@2db6235b: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, #<Ref@4f7cd15d: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, [3 0] {:north {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}, :south {:storage-room {nil nil}}, :east {:bedroom {:bed-broken {:usable false, :blood-smeared true, :description A once-beautiful bed, now totally destroyed.  The sheets have been ripped off the bed and the mattress is bloody and torn.  Something horrible happened here.}, nil nil}}, :west {:dining-room {nil nil}}}, [3 1] {:north {:storage-room {nil nil}}, :south {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}, :east {:living-room {nil nil}}, :west {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description "blah"}, nil nil}}}, #<Ref@228b677f: {[1 1] {:north nil, :south [1 0], :east nil, :west [0 1]}, [1 0] {:north [1 1], :south nil, :east nil, :west [0 0]}, [0 1] {:north nil, :south [0 0], :east [1 1], :west nil}, [0 0] {:north [0 1], :south nil, :east [1 0], :west nil}}> nil, [2 0] {:north {:storage-room {nil nil}}, :south {:dining-room {nil nil}}, :east {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description "blah"}, nil nil}}, :west {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}}}}, :2 {:diner {}}, :3 {:gun-shop {}}}, :north nil, :south [2 1], :east nil, :west [1 2]}, 
 
 
 
 
 [2 1] {:buildings {:1 {:gun-shop {}}, :2 {:hairdresser {}}, :3 {:diner {}}}, :north [2 2], :south [2 0], :east nil, :west [1 1]}, 
 [2 0] {:buildings {:1 {:apartment-building {}}, :2 {:gun-shop {}}, :3 {:gun-shop {}}}, :north [2 1], :south nil, :east nil, :west [1 0]}, 
 [1 2] {:buildings {:1 {:gun-shop {}}, :2 {:gun-shop {}}, :3 {:diner {}}}, :north nil, :south [1 1], :east [2 2], :west [0 2]}, 
 [1 1] {:buildings {:1 {:diner {}}, :2 {:gun-shop {}}, :3 {:gun-shop {}}}, :north [1 2], :south [1 0], :east [2 1], :west [0 1]}, 
 [1 0] {:buildings {:1 {:gun-shop {}}, :2 {:diner {}}, :3 {:apartment-building {}}}, :north [1 1], :south nil, :east [2 0], :west [0 0]}, 
 [0 2] {:buildings {:1 {:gun-shop {}}, :2 {:hairdresser {}}, :3 {:hairdresser {}}}, :north nil, :south [0 1], :east [1 2], :west nil}, 
 [0 1] {:buildings {:1 {:diner {}}, :2 {:apartment-building {}}, :3 {:gun-shop {}}}, :north [0 2], :south [0 0], :east [1 1], :west nil}, 
 [0 0] {:buildings {:1 {:diner {}}, :2 {:gun-shop {}}, :3 {:gun-shop {}}}, :north [0 1], :south nil, :east [1 0], :west nil}}




 ;; previous...
{[2 2] {:buildings 
        {:1 
         {:apartment-building 
          {[2 2] 
           {[1 1] {:storage-room {nil nil}}, 
            [1 0] {:storage-room {nil nil}}, 
            [0 1] {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}, 
            [0 0] {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}}, 
         
           [2 1] 
           {[1 1] {:office {nil nil}}, 
            [1 0] {:storage-room {nil nil}}, 
            [0 1] {:bedroom {:bed-broken {:usable false, :blood-smeared true, :description A once-beautiful bed, now totally destroyed.  The sheets have been ripped off the bed and the mattress is bloody and torn.  Something horrible happened here.}, nil nil}}, 
            [0 0] {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}}, 
           
           [2 0] 
           {[1 1] {:living-room {nil nil}}, 
            [1 0] {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter built sturdy and kept clean.}, nil nil}}, 
            [0 1] {:dining-room {nil nil}}, 
            [0 0] {:dining-room {nil nil}}}, 
           
           [1 2] 
           {[1 1] {:dining-room {nil nil}}, 
                  [1 0] {:office {nil nil}}, 
                  [0 1] {:storage-room {nil nil}}, 
                  [0 0] {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description "blah"}, nil nil}}}, 
           
           [1 1] 
           {[1 1] {:bathroom {:all-purpose-counter {:usable false, :blood-smeared false, :description "blah"}, nil nil}},
            [1 0] {:dining-room {nil nil}}, 
            [0 1] {:living-room {nil nil}}, 
            [0 0] {:office {nil nil}}}, 
           
           [1 0] 
           {[1 1] {:office {nil nil}}, 
            [1 0] {:storage-room {nil nil}}, 
            [0 1] {:bedroom {:bed-old {:usable false, :blood-smeared false, :description This bed has seen a lot. You're not sure what, and you're not sure you *want* to know, but it's a tired old bed and you're inclined to leave it in peace.}, nil nil}}, 
            [0 0] {:office {nil nil}}}, 
           
           [0 2] 
           {[1 1] {:office {nil nil}}, 
            [1 0] {:dining-room {nil nil}}, 
            [0 1] {:dining-room {nil nil}}, 
            [0 0] {:kitchen {:all-purpose-counter {:usable false, :blood-smeared false, :description An all-purpose counter; built sturdy and kept clean.}, nil nil}}}, [0 1] {[1 1] {:bedroom {:bed-modern {:usable false, :blood-smeared false, :description A stylish, modern bed.  All chrome and anodized anthracite-grey metal, this thing probably impressed the ladies before they became flesh-crazed zombies.}, nil nil}}, [1 0] {:storage-room {nil nil}}, [0 1] {:dining-room {nil nil}}, [0 0] {:office {nil nil}}}, [0 0] {[1 1] {:office {nil nil}}, [1 0] {:living-room {nil nil}}, [0 1] {:office {nil nil}}, [0 0] {:bedroom {:bed-broken {:usable false, :blood-smeared true, :description A once-beautiful bed, now totally destroyed.  The sheets have been ripped off the bed and the mattress is bloody and torn.  Something horrible happened here.}, nil nil}}}}}, :2 {:diner {}}, :3 {:hairdresser {}}}, :north nil, :south [2 1], :east nil, :west [1 2]}, [2 1] {:buildings {:1 {:diner {}}, :2 {:hairdresser {}}, :3 {:apartment-building {}}}, :north [2 2], :south [2 0], :east nil, :west [1 1]}, [2 0] {:buildings {:1 {:apartment-building {}}, :2 {:apartment-building {}}, :3 {:hairdresser {}}}, :north [2 1], :south nil, :east nil, :west [1 0]}, [1 2] {:buildings {:1 {:gun-shop {}}, :2 {:gun-shop {}}, :3 {:hairdresser {}}}, :north nil, :south [1 1], :east [2 2], :west [0 2]}, [1 1] {:buildings {:1 {:apartment-building {}}, :2 {:hairdresser {}}, :3 {:hairdresser {}}}, :north [1 2], :south [1 0], :east [2 1], :west [0 1]}, [1 0] {:buildings {:1 {:hairdresser {}}, :2 {:diner {}}, :3 {:gun-shop {}}}, :north [1 1], :south nil, :east [2 0], :west [0 0]}, [0 2] {:buildings {:1 {:diner {}}, :2 {:hairdresser {}}, :3 {:hairdresser {}}}, :north nil, :south [0 1], :east [1 2], :west nil}, [0 1] {:buildings {:1 {:gun-shop {}}, :2 {:apartment-building {}}, :3 {:hairdresser {}}}, :north [0 2], :south [0 0], :east [1 1], :west nil}, [0 0] {:buildings {:1 {:gun-shop {}}, :2 {:gun-shop {}}, :3 {:gun-shop {}}}, :north [0 1], :south nil, :east [1 0], :west nil}}                                                                                                                                                                                                                                                                                                                                                                                                               

                                                                                                                                                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                                                                                                                                                 