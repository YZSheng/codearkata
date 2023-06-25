(ns codewarkata.sum-of-intervals-test
  (:require [clojure.test :refer [deftest are is]]))

(defn sum-intervals [intervals]
  (let [sorted-intervals (sort-by first intervals)
        merged-intervals (reduce (fn [acc, val]
                                   (if (empty? acc)
                                     (conj acc val)
                                     (let [last-interval (last acc)]
                                       (if (>= (second last-interval) (first val))
                                         (conj (vec (butlast acc)) [(first last-interval) (max (second last-interval) (second val))])
                                         (conj acc val)))))
                                 []
                                 sorted-intervals)
        lengths (map (fn [[start end]] (- end start)) merged-intervals)]
    (apply + lengths)))

(deftest sample-tests-1
  (is (= 3 (sum-intervals [[1 4] [1 4]]))))

(deftest sample-tests
  (are [expected calculated] (= expected calculated)
    4   (sum-intervals [[1 5]])
    4   (sum-intervals [[1 5] [1 5]])
    8   (sum-intervals [[1 5] [6 10]])
    4   (sum-intervals [[1 5] [2 3]])
    4   (sum-intervals [[1 4] [3 5]])
    7   (sum-intervals [[1 4] [3 5] [7 10]])
    7   (sum-intervals [[1 4] [7 10] [3 5]])))

(deftest large-intervals
  (are [expected calculated] (= expected calculated)
    2000000000   (sum-intervals [[-1000000000 1000000000]])
    100000030    (sum-intervals [[0 20] [-100000000 10] [30 40]])))