(ns collision.business.fraud
  [:require [collision.utils.vector :as vecutils]
            [clojure.tools.logging :as log]])

(defn contains-value? [element coll]
  (boolean (some #(= element %) coll)))

(defn remove-network
  "removes a single network from networks vector"
  [network networks]
  (def index (.indexOf networks network))
  (cond
    (= -1 index) networks
    :else (vecutils/remove networks index)))

(defn add-collision "add collision to network" [networks collision]
  (def node1 (first collision))
  (def node2 (last collision))
  (def network1 nil)
  (def network2 nil)
  (def networksCounter 0)
  (def networksQuantity (count networks))
  (log/debug "handling collision" collision)
  (while (and (or (= network1 nil) (= network2 nil)) (< networksCounter networksQuantity))
    (do
      (def network (get networks networksCounter))
      (if (and (= network1 nil) (contains-value? node1 network))
        (do
          (log/debug "found network1" network)
          (def network1 network)))
      (if (and (= network2 nil) (contains-value? node2 network))
        (do
          (log/debug "found network2" network)
          (def network2 network)))
      (def networksCounter (inc networksCounter))))
  (if (= network1 nil)
    (def network1 [node1]))
  (if (= network2 nil)
    (def network2 [node2]))
  (if (= network1 network2) networks
    (do
      (vecutils/append
        (vecutils/merge network1 network2)
        (remove-network network2 (remove-network network1 networks))))))

(defn nodes-belong-to-same-network [node1 node2 networks]
  (def found false)
  (def networksCounter 0)
  (def networksQuantity (count networks))
  (def nodesVec [node1 node2])
  (log/debug "searching" nodesVec)
  (while (and (not found) (< networksCounter networksQuantity))
    (do
      (def network (get networks networksCounter))
      (log/debug "checking" nodesVec network)
      (def found (every? (set network) nodesVec))
      (log/debug "found" found)
      (log/debug "xp" (every? (set network) nodesVec))
      (def networksCounter (inc networksCounter))))
  found)
