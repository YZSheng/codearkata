(ns codewarkata.predict-age-test
  (:require [clojure.test :refer [deftest is]]))

(defn predict-age [& ages]
  (->> ages
       (map #(* % %))
       (reduce +)
       (Math/sqrt)
       (#(/ % 2))
       (Math/floor)
       (int)))

(deftest predit-age-test1
  (is (= (predict-age 65 60 75 55 60 63 64 45) 86)))

(deftest predit-age-test2
  (is (= (predict-age 32 54 76 65 34 63 64 45) 79)))