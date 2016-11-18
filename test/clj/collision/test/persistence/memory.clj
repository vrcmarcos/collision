(ns collision.test.persistence.memory
  (:require [clojure.test :refer :all]
            [collision.persistence.memory :refer :all]))

(deftest test-add
  (testing "should have no network on memory"
    (is (= nil (get-networks))))
  (testing "should add vector to memory"
    (put-networks! [[1 2] [3 4]])
    (is (= [[1 2] [3 4]] (get-networks)))))