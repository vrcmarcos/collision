(ns collision.persistence.memory)

(def networks-table (atom {:networks nil}))

(defn get-networks []
  (get @networks-table :networks))

(defn put-networks! [networks]
  (swap! networks-table assoc :networks networks))