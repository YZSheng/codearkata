(ns codewarkata.simple-pig-latin-test
  (:require [clojure.string :as string]
            [clojure.test :refer [deftest is]]))

(defn shift-left [lst]
  (string/join (concat (rest lst) (list (first lst)))))

(defn pig-word [word]
  (if (re-matches #"^[a-zA-Z]*$" word)
    (str (shift-left word) "ay")
    word))

(defn pig-it [input]
  (->> (string/split input #" ")
       (map pig-word)
       (string/join " ")))

(deftest pig-latin-example-test
  (is (= (pig-it "Pig latin is cool") "igPay atinlay siay oolcay")))

(deftest pig-latin-example-test-2
  (is (= (pig-it "This is my string") "hisTay siay ymay tringsay")))

(deftest pig-latin-example-test-3
  (is (= (pig-it "Hello world !") "elloHay orldway !")))



(comment
  (shift-left "abcdk")

  (string/split "abc, efg ! h" #" ")

  (pig-word "Pig"))