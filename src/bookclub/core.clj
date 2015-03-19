(ns bookclub.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :as ring]
            [cheshire.core :as json]))

; (defn -main
;   "I don't do a whole lot ... yet."
;   [& args]
;   (println "Hello, World!"))

; (defn handler [request]
;   {:status 200
;     :headers {"Content-Type" "text/html"}
;     :body "Hello World"})

(defn json-response [data & [status]]
  {:status (or status 200)
    :headers {"Content-Type" "application/hal+json; charset=utf-8"}
    :body (json/generate-string data)})

(defroutes routes
  (GET "/" request (json-response {:greetings (str "Greetings" "foo")}))
  (route/resources "/")
  (GET "/foo" request (json-response {:greetings (str "this is foo") }))
  (route/resources "/foo")
  (GET "/book/:id" [id] (json-response {:foo (str "dynamic route: " id)}))
  (route/resources "/book:id")
  (route/not-found "Not Found"))

; Might want to use `api-defaults` instead of `site-defaults`, depending on
; whether it's going to be a site or an api
; https://github.com/ring-clojure/ring-defaults
(def app
  (wrap-defaults routes site-defaults))
