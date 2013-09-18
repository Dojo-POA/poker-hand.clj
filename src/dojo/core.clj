(ns dojo.core (:use [clojure.string]))

(defn card [string]
	[({\2 :two} (first string)), :spades])

(defn hand [string]
  (map card (split string #" ")))

(defn compare-hands [player1 player2]
	:first)