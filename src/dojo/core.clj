(ns dojo.core (:use [clojure.string]))

(def card->face {
	\2 :two
	\3 :three
	\4 :four
	\5 :five
	\6 :six
	\7 :seven
	\8 :eight
	\9 :nine	
	\t :ten
	\j :jack
	\q :queen
	\k :king
	\a :ace })

(def card->suit {
	\s :spades
	\h :hearts
	\c :clubs
	\d :diamonds })

(defn card [string]
	(let [face (first string)
		    suit (second string)]
	[(card->face face), (card->suit suit)]))

(defn hand [string]
  (map card (split string #" ")))

(defn compare-hands [player1 player2]
	:first)