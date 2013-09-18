(ns dojo.core (:use [clojure.string]))

(def card->face {
	\2 :two
	\6 :six
	\7 :seven
	\9 :nine
	\t :ten
	\k :king
	\q :queen
	})
(def card->suit {
	\s :spades
	\h :hearts
	\c :clubs
	\d :diamonds})

(defn card [string]
	[(card->face (first string)), (card->suit (second string))])

(defn hand [string]
  (map card (split string #" ")))

(defn compare-hands [player1 player2]
	:first)