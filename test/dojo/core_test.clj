(ns dojo.core-test
  (:require [clojure.test :refer :all]
            [dojo.core :refer :all]))


(deftest a-hand
  (testing "hand parser"
    (is (= 
      [
        [:two, :clubs] 
        [:two, :diamonds] 
        [:ten, :diamonds] 
        [:seven, :hearts] 
        [:six, :hearts]] 
      (hand "2c 2d td 7h 6h")))
    (is (= 
      [
        [:six, :clubs]
        [:nine, :diamonds] 
        [:king, :diamonds] 
        [:queen :hearts] 
        [:king, :diamonds]] 
      (hand "6c 9d kd qh kd"))))
  (testing "card parser"
    (is (= [:two, :spades] (card "2s")))))

#_(deftest a-showdown
  (testing "highest card"
    (is (= :first (compare-hands (hand "2c 3c 6h 7h ad") (hand "2c 3c 6h 7h td"))))
    (is (= :second (compare-hands "2c 3c 6h 7h td" "2c 3c 6h 7h ad")))))