;; THIS WILL BE GENERATED RANDOMLY AT RUNTIME

(def worldgrid {
                :a1 {
                     :streets [s1]
                     :buildings {;;calculated based on which direction
                                 ;;streets are going at this point
                                 :east {
                                        :apartment-building {;;multi-unit location
                                                             :info {:name "Dynamically Generated Based On Street Name"
                                                                    :security-level 7}
                                                             :floors {
                                                                      :floor1 {
                                                                         :a1 {;;hallways and rooms are just like streets and buildings
                                                                  :hallways [h1]
                                                                  :rooms {
                                                                          :east {
                                                                                 :bedroom [
                                                                                           bed-modern, {dresser-modern [glock9mm, raincoat, 9mm-ammo]}, nightstand-modern, lamp-modern, mirror-old
                                                                                           ]
                                                                                 }
                                                                          }
                                                                  }
                                                             :a2 {}
                                                             :a3 {}
                                                             :b1 {
                                                                  :hallways [h1]
                                                                  :rooms {
                                                                          :west {
                                                                                 :kitchen [
                                                                                           stove, oven, {:refrigerator [food-spoiled, coolwhip]}, counter-modern, {:cupboard [knife-steak, fork, 9mm-ammo]}
                                                                                           ]
                                                                                 }
                                                                          }
                                                                  }
                                                             :b2 {}
                                                             :b3 {}
                                                             :c1 {}
                                                             :c2 {}
                                                             :c3 {}
                                                                         }

                                                                      :floor2 {}}

                                                             
                                 :west {
                                        :hairdresser [;; single-room location
                                                      :hairdresser-stations, {;;containers are a name, mapped to a vector of items
                                                                              :hairdresser-equipment-cabinet [:scissors, :hairspray, :straight-razor]
                                                                              },
                                                      :chairs
                                                      ]
                                        }
                                 }
                     }
               :a2 {}
               :a3 {}
               :a4 {}
               :b1 {}
               :b2 {}
               :b3 {}
               :b4 {}
               :c1 {}
               :c2 {}
               :c3 {}
               :c4 {}
               :d1 {}
               :d2 {}
               :d3 {}
               :d4 {}
               })