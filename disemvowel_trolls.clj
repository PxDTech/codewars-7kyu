(ns pasquale.disemvowel-trolls
  (:gen-class))

;; Trolls are attacking your comment section!
;; A common way to deal with this situation is to remove all of the vowels
;; from the trolls' comments, neutralizing the threat.
;; Your task is to write a function that takes a string and return a new string
;; with all vowels removed.
;; For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
;; Note: for this kata y isn't considered a vowel.

(defn disemvowel [s]
  (clojure.string/replace s #"(?i)[aeiou]" ""))

;; Explanation:
;; (ns pasquale.remove-vowels ...) defines your namespace.
;; (clojure.string/replace s #"(?i)[aeiou]" "")
;; #"(?i)[aeiou]" is a regex that matches vowels (a e i o u), case-insensitive (?i).
;; Every vowel found is replaced with an empty string (""), effectively removing it.

(defn disemvowel1 [s]
  (let [vowels #{\a \e \i \o \u \A \E \I \O \U}]
    (apply str (remove vowels s))))

;; How it works:
;; vowels is a set of all characters we want to remove.
;; (remove vowels s) goes through each character in the string and drops it if it’s in the set.
;; (apply str ...) stitches the remaining characters back into a string.

;; ⚡ The nice part: you can expand the set to add/remove other characters
;; (e.g., include \y if you ever decide it counts as a vowel).

(defn disemvowel2 [s]
  (let [vowels #{\a \e \i \o \u \A \E \I \O \U}]
    (loop [chars (seq s)
           result ""]
      (if (empty? chars)
        result
        (let [c (first chars)]
          (recur (rest chars)
                 (if (vowels c)
                   result
                   (str result c))))))))

;; Explanation
;; (seq s) turns the string into a sequence of characters.
;; loop and recur keep track of:
;; chars → remaining characters
;; result → what we’ve built so far
;; (if (vowels c) result (str result c)) only adds the character if it’s not a vowel.
;; When chars is empty, we return the result string.

