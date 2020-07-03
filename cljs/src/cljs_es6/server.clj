(ns cljs-es6.server
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.route :refer [resources files]]
            [compojure.core :refer [defroutes GET]]))

(defn app [_]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello"})

(defroutes all-routes
  (GET "/" [] app)
  (resources "/")
  (files "/"))

(defn -main [& _]
  (run-server all-routes {:port 8080})
  (println "Server started on port 8080"))