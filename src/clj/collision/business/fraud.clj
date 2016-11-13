(ns collision.business.fraud
  [:require [collision.utils.vector :as vecutils]])

(defn remove-network
  "removes a single network from networks vector"
  [network networks]
  (def index (.indexOf networks network))
  (cond
    (= -1 index) networks
    :else (vecutils/remove networks index)))

(defn add-collision
  "add collision to network"
  [networks collision]
    (def node1 (first collision))
    (def node2 (last collision))
    (def network1 [node1])
    (def network2 [node2])
    (doseq [network networks]
      (if (= network1 [node1])
        (if (some (set network) network1)
          (def network1 network)))
      (if (= network2 [node2])
        (if (some (set network) network2)
          (def network2 network))))
    (vecutils/append
      (vecutils/merge network1 network2)
      (remove-network network2 (remove-network network1 networks))))
