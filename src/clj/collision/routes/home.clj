(ns collision.routes.home
  (:require [collision.business.fraud :as fraud]
            [collision.persistence.memory :as memory]
            [compojure.core :refer [defroutes GET PUT]]
            [ring.util.response :refer [response]]))

(defn parse-int [s]
  (Integer. (re-find  #"\d+" s )))

(defn get-all []
  (response (memory/get-networks)))

(defn put [collision]
  (def networks (memory/get-networks))
  (def updatedNetworks (fraud/add-collision networks collision))
  (memory/put-networks! updatedNetworks)
  (response updatedNetworks))

(defn same-network [node1 node2]
  (response {:result (fraud/nodes-belong-to-same-network node1 node2 (memory/get-networks))}))

(defroutes home-routes
  (GET "/" [] (get-all))
  (PUT "/" [collision] (put (let [input collision] (read-string (str "[" input "]")))))
  (GET "/same_network" [node1 node2] (same-network (parse-int node1) (parse-int node2))))
