(ns codewarkata.factorial-trailing-zeros-test
  (:require [clojure.test :refer [deftest is]]))

(defn zeros [n]
  (loop [i 5
         count 0]
    (if (>= (/ n i) 1)
      (recur (* i 5) (+ count (int (/ n i))))
      count)))

(deftest Testing...
  (is (= (zeros 0) 0) "Zero has 0 trailing zeros")
  (is (= (zeros 6) 1))
  (is (= (zeros 30) 7)))
