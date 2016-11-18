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

(deftest test-nodes-belong-to-same-network
  (testing "should return true when node 1 and 2 and networks [[1 2] [3 4]] is given"
    (is (= true (nodes-belong-to-same-network 1 2 [[1 2] [3 4]]))))
  (testing "should return false when node 1 do not belong to the same network that node 2 belongs"
    (is (= false (nodes-belong-to-same-network 1 2 [[1 3] [4 6]]))))
  (testing "should return true when node 1 and 2 and networks [[1 2] [3 4]] is given"
    (is (= true (nodes-belong-to-same-network 3 4 [[1 2] [3 4]]))))
  (testing "should return false when node 1 and 2 and empty networks is given"
    (is (= false (nodes-belong-to-same-network 3 4 [])))))