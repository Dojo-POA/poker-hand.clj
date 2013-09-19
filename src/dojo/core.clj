(ns dojo.core (:use [clojure.string :only [split]]))

(def card->face (array-map 
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
	\a :ace ))

(def card->suit {
	\s :spades
	\h :hearts
	\c :clubs
	\d :diamonds })

(defn card [[face suit]]
	[(card->face face), (card->suit suit)])

(defn hand [string]
  (map card (split string #" ")))

(defn card-compare [[one _] [two _]]
	(let [face-precedence (vals card->face)
			  one-precedence (.indexOf face-precedence one)
			  two-precedence (.indexOf face-precedence two)]
		(compare one-precedence two-precedence)))

(defn compare-highcard [hand1 hand2]
	(let [sorted-hand1 (sort-by identity card-compare hand1)
		    sorted-hand2 (sort-by identity card-compare hand2)
		    zipped-hands (reverse (map vector sorted-hand1 sorted-hand2))
		    hand-pair-with-match (first (filter (fn [[card1  card2]] (not= 0 (card-compare card1 card2))) zipped-hands))]
		    (apply card-compare hand-pair-with-match)
		))