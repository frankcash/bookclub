(ns web.core
  (:require [compojure.core :refer [defroutes GET]]
    [ring.adapter.jetty :as ring]))

; (defn -main
;   "I don't do a whole lot ... yet."
;   [& args]
;   (println "Hello, World!"))

; (defn handler [request]
;   {:status 200
;     :headers {"Content-Type" "text/html"}
;     :body "Hello World"})

(defroutes routes
  (GET "/" [] "<h2>Hello World</h2>"))

(defn -main []
  (ring/run-jetty #'routes {:port 3000 :join? false}))
