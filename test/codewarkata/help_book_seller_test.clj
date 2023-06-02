(ns codewarkata.help-book-seller-test
  (:require [clojure.string :as string]
            [clojure.test :refer :all]))

(def ur ["BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"])
(def vr ["A" "B" "C" "D"])
(def res [["A" 0] ["B" 1290] ["C" 515] ["D" 600]])

(defn convert-stocks-to-mapping [stocks]
  (->> stocks
       (map #(string/split % #" "))
       (map (fn [[category quantity]]
              [(str (first category)) (Integer/parseInt quantity)]))
       (group-by first)
       (map (fn [[key entries]]
              [key (reduce + (map last entries))]))
       (into {})))

(defn stock-list [stocks categories]
  (if (empty? stocks)
    []
    (let [stock-mapping (convert-stocks-to-mapping stocks)]
      (map (fn [key]
             [key (get stock-mapping key 0)]) categories))))

(deftest a-test1
  (testing "Test 1"
    (is (= (stock-list ur vr) res)))
  (testing "empty stocks"
    (is (= (stock-list [] vr) []))))

(comment
  (stock-list [] ["A" "B"])
  (convert-stocks-to-mapping ur))
