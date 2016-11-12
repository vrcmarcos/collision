(ns collision.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [collision.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[collision started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[collision has shut down successfully]=-"))
   :middleware wrap-dev})
