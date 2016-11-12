(ns collision.controller.input
  (:require [clojure.java.io :as io]))

(def get-lines (with-open [rdr (io/reader (io/resource "data.txt"))]
             (line-seq rdr)))
