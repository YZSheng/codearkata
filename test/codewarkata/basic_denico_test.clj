(ns codewarkata.basic-denico-test
  (:require [clojure.string :as string]
            [clojure.test :refer [deftest is]]))

;; ???
(defn denico [k m]
  (let [order   (map (partial string/index-of (apply str (sort k))) k)
        numOrd  (count order)
        parts   (partition numOrd numOrd (repeat \space) m)
        result  (mapcat #(map (partial nth %) order) parts)]
    (string/trim (apply str result))))

(deftest basic-tests
  (is (= "secretinformation" (denico "crazy" "cseerntiofarmit on  ")))
  (is (= "secretinformation" (denico "crazy" "cseerntiofarmit on")))
  (is (= "abcd" (denico "abc" "abcd")))
  (is (= "1234567890" (denico "ba" "2143658709")))
  (is (= "message" (denico "a" "message")))
  (is (= "key" (denico "key" "eky"))))
