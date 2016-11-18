(ns collision.test.controller.input
  (:require [clojure.test :refer :all]
            [collision.controller.input :refer :all]))

(deftest test-create-networks-from-file
  (testing "should return [8 24] at fourth position when test-data.txt file is given"
    (is (= [8 24] (get (create-networks-from-file "test-data.txt") 3)))))
