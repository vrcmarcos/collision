(ns user
  (:require [mount.core :as mount]
            collision.core))

(defn start []
  (mount/start-without #'collision.core/repl-server))

(defn stop []
  (mount/stop-except #'collision.core/repl-server))

(defn restart []
  (stop)
  (start))


