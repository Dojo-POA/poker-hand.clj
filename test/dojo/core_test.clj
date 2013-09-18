(ns dojo.core-test
  (:require [clojure.test :refer :all]
            [dojo.core :refer :all]))

(deftest a-hand
  (testing "hand parser"
    (is (= (list "2c" "2d" "td" "7h") (hand "2c 2d td 7h")))
    (is (= (list "6c" "9d" "kd" "qh") (hand "6c 9d kd qh")))))

#_(deftest a-showdown
  (testing "highest card"
    (is (= :first (compare-hands (hand "2c 3c 6h 7h ad") (hand "2c 3c 6h 7h td"))))
    (is (= :second (compare-hands "2c 3c 6h 7h td" "2c 3c 6h 7h ad")))))