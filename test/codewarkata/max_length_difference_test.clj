(ns codewarkata.max-length-difference-test
  (:require [clojure.test :refer [is deftest testing]]))

(def s1 ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"])
(def s2 ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"])

(defn mxdiflg [a1 a2]
  (if (or (empty? a1) (empty? a2))
    -1
    (->> (for [x a1
               y a2]
           (Math/abs (- (count x) (count y))))
         (apply max))))


(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "mxdiflg"
    (test-assert (mxdiflg s1 s2) 13))
  (testing "first arg is empty"
    (test-assert (mxdiflg [] s2) -1))
  (testing "second arg is empty"
    (test-assert (mxdiflg s1 []) -1)))