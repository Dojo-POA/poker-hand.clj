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

(deftest comparing
  (testing "comparing two cards"
    (is (= 1 (card-compare (card "as") (card "4s"))))
    (is (= 0 (card-compare (card "as") (card "as"))))
    (is (= -1 (card-compare (card "4s") (card "ts"))))))

(deftest a-showdown
  (testing "highest card"
    (is (= 1 (compare-highcard
      (hand "2c 3c 6h 7h ad")
      (hand "2c 3c 6h 7h td"))))
    (is (= -1 (compare-highcard
      (hand "2c 3c 6h 7h td")
      (hand "2c 3c 6h 7h ad"))))
    (is (= 1 (compare-highcard
      (hand "2c 3c 6h 7h ad")
      (hand "2c 3c 6h 6s ad"))))))