(ns codewarkata.sum-of-odd-numbers-test
  (:require [clojure.test :refer [deftest is]]))

(defn row-sum-odd-numbers [row]
  (* row row row))

(deftest sample-tests
  (is (= 1 (row-sum-odd-numbers 1)))
  (is (= 125 (row-sum-odd-numbers 5)))
  (is (= 343 (row-sum-odd-numbers 7))))
