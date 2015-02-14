(ns bookclub.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
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
  (GET "/" [] "<h2>Hello World</h2>")
  (route/resources "/")
  (route/not-found "Not Found"))

; Might want to use `api-defaults` instead of `site-defaults`, depending on
; whether it's going to be a site or an api
; https://github.com/ring-clojure/ring-defaults
(def app
  (wrap-defaults routes site-defaults))
