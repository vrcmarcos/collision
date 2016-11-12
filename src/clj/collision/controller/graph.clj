(ns collision.controller.graph)

(defn collisions-belong-to-same-network [collision1 collision2]
  (not= nil
      (some (set collision1) collision2)))
