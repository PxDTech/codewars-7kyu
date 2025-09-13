(ns pasquale.descending-order
  (:gen-class))

;; Your task is to make a function that can take any non-negative integer as an argument
;; and return it with its digits in descending order. Essentially, rearrange the digits
;; to create the highest possible number.

(defn desc-order [n]
  (->> (str n)                     ; number -> "digits"
       (sort #(compare %2 %1))     ; sort chars descending
       (apply str)                 ; join back to string
       (Long/parseLong)))          ; parse to a number

(defn desc-order1 [n]
  (->> (str n)
       sort reverse
       (apply str)
       Integer/parseInt))
