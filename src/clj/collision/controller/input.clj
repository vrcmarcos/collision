(ns collision.controller.input
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [collision.business.fraud :as fraud]))

(defn create-networks-from-file [fileName]
  (def networks [])
  (with-open [rdr (io/reader (io/resource fileName))]
  (doseq [line (line-seq rdr)]
    (def collision (let [input line] (read-string (str "[" input "]"))))
    (def networks (fraud/add-collision networks collision))))
  networks)
