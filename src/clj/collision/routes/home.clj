(ns collision.routes.home
  (:require [collision.layout :as layout]
            [collision.persistence.memory :as memory]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn networks-page []
  (layout/render
    "networks.html" {:networks (memory/get-networks)}))

(defroutes home-routes
  (GET "/" [] (networks-page)))

