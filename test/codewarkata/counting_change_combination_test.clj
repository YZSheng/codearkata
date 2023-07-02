(ns codewarkata.counting-change-combination-test
  (:require [clojure.test :refer [deftest testing is]]))

(defn count-change [money [coin & others :as coins]]
  (cond
    (zero? money) 1
    (or (neg? money) (empty? coins)) 0
    :else (+ (count-change (- money coin) coins)
             (count-change money others))))

(deftest Testing...
  (testing "(count-change 1 [1,2,3]) ; => 1"
    (is (= (count-change 1 [1,2,3]) 1)))
  (testing "(count-change 4 [1,2]) ; => 3"
    (is (= (count-change 4 [1,2]) 3)))
  (testing "(count-change 10 [5,2,3]) ; => 4"
    (is (= (count-change 10 [5,2,3]) 4)))
  (testing "(count-change 11 [5,7]) ; => 0"
    (is (= (count-change 11 [5,7]) 0)))
  (testing "(count-change 2 [1,2,3]) ; => 2"
    (is (= (count-change 2 [1,2,3]) 2)))
  (testing "(count-change 1 []) ; => 0"
    (is (= (count-change 1 []) 0))))