(ns mywebapp.routes
  (:use compojure.core
        mywebapp.slides)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))


(defroutes app-routes
  (GET "/" [] (slides-page))
  (route/resources "/")
  (route/not-found "No page"))


(def app
  (handler/site app-routes))
