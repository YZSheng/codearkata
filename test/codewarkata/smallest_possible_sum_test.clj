(ns codewarkata.smallest-possible-sum-test
  (:require [clojure.test :refer [deftest is]]))

(defn solution [nums]
  (loop [nums nums]
    (if (every? #(= (first nums) %) nums)
      (apply + nums)
      (let [m (apply min nums)]
        (recur (map (fn [num]
                      (let [diff (mod num m)]
                        (if (zero? diff) m diff))) nums))))))

(deftest sample-test-cases
  (is (= 3 (solution [1,21,55])))
  (is (= 5 (solution [3,13,23,7,83])))
  (is (= 12 (solution [4,16,24])))
  (is (= 12 (solution [30,12])))
  (is (= 132 (solution [60,12,96,48,60,24,72,36,72,72,48])))
  (is (= 923 (solution [71,71,71,71,71,71,71,71,71,71,71,71,71])))
  (is (= 22 (solution [11,22])))
  (is (= 9 (solution [9])))
  (is (= 1 (solution [1])))
  (is (= 18 (solution [9,9]))))

(comment

  (apply min [30 12])
  (mod 30 12))