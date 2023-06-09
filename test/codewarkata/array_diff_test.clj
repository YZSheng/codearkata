(ns codewarkata.array-diff-test
  (:require [clojure.test :refer [deftest is]]))

(defn array-diff [a b]
  (remove (set b) a))

(deftest example-tests
  (is (= (array-diff [1 2] [1]) [2]))
  (is (= (array-diff [1 2 2] [1]) [2 2]))
  (is (= (array-diff [1 2 2] [2]) [1]))
  (is (= (array-diff [1 2 2] []) [1 2 2]))
  (is (= (array-diff [1 2 3] [1 2]) [3]))
  (is (= (array-diff [] [1 2]) [])))
