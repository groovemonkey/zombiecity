(defproject zombiecity "0.0.1-SNAPSHOT"
  :description "A Zombie Survival Text-Adventure Game taking place in a randomly generated city."
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure/core.incubator "0.1.0"]
                 [lein-swank "1.4.4"]]
  :main zombiecity.mainloop
  :resources-path "data/"
  :dev-dependencies [[lein-eclipse "1.0.0"]]
)
