(ns pasquale.high-and-low
  (:gen-class))

;; In this little assignment you are given a string of space separated numbers,
;; and have to return the highest and lowest number.

(defn high-and-low
  [s]
  (let [nums (map #(Integer/parseInt %) (clojure.string/split s #" "))]
    (str (apply max nums) " " (apply min nums))))

;; This program works as follows:
;; Splits the input string on spaces.
;; Converts each piece into an integer.
;; Finds the maximum and minimum with apply max and apply min.
;; Returns them in a string "max min" format.

