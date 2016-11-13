(ns collision.test.utils.vector
  (:require [clojure.test :refer :all]
            [collision.utils.vector :refer :all]))

(deftest test-remove
  (testing "should return [20 30] when removing first index from vector [10 20 30]"
    (is (= [20 30] (remove [10 20 30] 0))))
  (testing "should return [10 30] when removing an element in the middle from vector [10 20 30]"
    (is (= [10 30] (remove [10 20 30] 1))))
  (testing "should return [10 20] when removing last index from vector [10 20 30]"
    (is (= [10 20] (remove [10 20 30] 2))))
  (testing "should return [[20 30]] when removing first elem from vector [[10 20] [20 30]]"
    (is (= [[20 30]] (remove [[10 20] [20 30]] 0)))))

(deftest test-merge
  (testing "should return [10 20 30 40] when merging vecs [10 20] and [30 40]"
    (is (= [10 20 30 40] (merge [10 20] [30 40])))))

(deftest test-append
  (testing "should return [10 20 30] when appending elem 30 to vec [10 20]"
    (is (= [10 20 30] (append 30 [10 20])))))
