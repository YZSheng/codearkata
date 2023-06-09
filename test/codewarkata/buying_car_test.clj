(ns codewarkata.buying-car-test
  (:require [clojure.test :refer [deftest testing is]]))

(defn nb-months [old-start-price new-start-price monthly-saving original-monthly-percent-loss]
  (loop [old-price old-start-price
         new-price new-start-price
         savings 0
         n 0]
    (let [diff (- (+ old-price savings) new-price)]
      (if (pos? diff)
        [n (Math/round (double diff))]
        (let [new-montly-loss (+ original-monthly-percent-loss (* 0.5 (int (/ (inc n) 2))))
              update-price (fn [p] (* (/ (- 100 new-montly-loss) 100) p))]
          (recur (update-price old-price)
                 (update-price new-price)
                 (+ savings monthly-saving)
                 (inc n)))))))

(deftest a-test1
  (testing "Test 1"
    (is (= (nb-months 2000 8000 1000 1.5) [6, 766]))))
(deftest a-test2
  (testing "Test 2"
    (is (= (nb-months 12000 8000 1000 1.5) [0, 4000]))))