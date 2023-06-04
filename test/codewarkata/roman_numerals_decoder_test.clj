(ns codewarkata.roman-numerals-decoder-test
  (:require [clojure.test :refer [deftest are]]))

(def decoder {\I 1
              \V 5
              \X 10
              \L 50
              \C 100
              \D 500
              \M 1000})

(defn translate-roman-numerals [numerals]
  (loop [letter (first numerals)
         others (rest numerals)
         value 0]
    (if (seq others)
      (let [first-value (decoder letter)
            [next-head & next-rest] others
            next-value (decoder next-head)]
        (recur next-head next-rest
               (+ value (* (if (>= first-value next-value) 1 -1) first-value))))
      (+ value (decoder letter)))))

(deftest sample-roman-numerals
  (are [given-value calculated-value] (= given-value calculated-value)
    1     (translate-roman-numerals "I")
    4     (translate-roman-numerals "IV")
    2008  (translate-roman-numerals "MMVIII")
    1666  (translate-roman-numerals "MDCLXVI")))