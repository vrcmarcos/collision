(ns collision.test.controller.graph
  (:require [clojure.test :refer :all]
            [collision.controller.graph :refer :all]))

(deftest test-collisions-belong-to-same-network
  (testing "should return true when collisions [1 2] [2 3] are given"
    (is (= true (collisions-belong-to-same-network [1 2] [2 3]))))
  (testing "should return true when collisions [1 2] [4 1] are given"
    (is (= true (collisions-belong-to-same-network [1 2] [4 1]))))
  (testing "should return false when collisions [1 2] [3 4] are given")
    (is (= false (collisions-belong-to-same-network [1 2] [3 4]))))
