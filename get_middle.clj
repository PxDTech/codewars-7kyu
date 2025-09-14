(ns pasquale.get-middle
  (:gen-class))

;; You are going to be given a non-empty string.
;; Your job is to return the middle character(s) of the string.
;; If the string's length is odd, return the middle character.
;; If the string's length is even, return the middle 2 characters.

(defn get-middle [s]
  (let [len (count s)
        mid (quot len 2)]
    (->> (if (odd? len)
         [mid (inc mid)]
         [(dec mid) (inc mid)])
    (apply subs s))))
