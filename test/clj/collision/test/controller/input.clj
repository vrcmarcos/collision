(ns collision.test.controller.input
  (:require [clojure.test :refer :all]
            [collision.controller.input :refer :all]))

(deftest test-get-lines
  (testing "first line"
    (is (= "20 88" (first get-lines)))))
