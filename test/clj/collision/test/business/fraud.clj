(ns collision.test.business.fraud
  (:require [clojure.test :refer :all]
            [collision.business.fraud :refer :all]))

(deftest test-add-collision
  (testing "should return [[1 2]] as networks when empty network is given and add collision [1 2]"
    (is (= [[1 2]] (add-collision [] [1 2]))))
  (testing "should return [[1 2 3]] as networks when networks are [[1 2]] and add collision [2 3]"
    (is (= [[1 2 3]] (add-collision [[1 2]] [2 3]))))
  (testing "should return [[1 2 3 4] [5 6 7]] when adding collisions [1, 2] [2, 3] [1, 4] [5, 6] [6, 7] to empty network"
    (is (= [[1 2 3 4] [5 6 7]]
           (add-collision
             (add-collision
               (add-collision
                 (add-collision
                   (add-collision [] [1 2])
                   [2 3])
                 [1 4])
               [5 6])
             [6 7])))))