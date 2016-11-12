(ns collision.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[collision started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[collision has shut down successfully]=-"))
   :middleware identity})
