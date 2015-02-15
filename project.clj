(defproject bookclub "0.1.0-SNAPSHOT"
  :description "Site for Hacker Book Club"
  :url "https://github.com/frankcash/bookclub"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.2"]
                 [compojure "1.3.1"]
                 [org.clojure/java.jdbc "0.3.2"]
                 [postgresql "9.1-901.jdbc4"]
                 [ring/ring-defaults "0.1.4"]]
  :plugins [[lein-ring "0.9.1"]]
  :ring {:handler bookclub.core/app}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}})
