(ns codewarkata.highest-lowest-test
  (:require [clojure.string :as string]
            [clojure.test :refer [deftest is]]))

(defn high-and-low [input]
  (->> (string/split input #" ")
       (map #(Integer/parseInt %))
       (#(string/join " " [(apply max %) (apply min %)]))))

(deftest basic-tests
  (is (= (high-and-low "8 3 -5 42 -1 0 0 -9 4 7 4 -4") "42 -9"))
  (is (= (high-and-low "8") "8 8"))
  (is (= (high-and-low "1 2 3") "3 1")))

(comment
  (string/split "1 2 3" #" ")

  (high-and-low "1 2 5 3")
  (high-and-low "1 2 3"))

