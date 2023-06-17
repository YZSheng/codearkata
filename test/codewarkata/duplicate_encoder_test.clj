(ns codewarkata.duplicate-encoder-test
  (:require [clojure.string :as string]
            [clojure.test :refer [deftest is testing]]))

(defn encode-dups [input]
  (let [input (string/lower-case input)
        freq (frequencies input)]
    (->> input
         (map (fn [char]
                (if (= 1 (freq char)) "(" ")")))
         (apply str))))

(defn dotest [text expected]
  (is (= (encode-dups text) expected)))

(deftest sample
  (testing "basic"
    (dotest "din" "(((")
    (dotest "recede" "()()()")
    (dotest "(( @" "))((")
    (dotest "ABC" "(((")
    (dotest "AaBbC" "))))("))
  (testing "ignore-case" (dotest "Success" ")())())")))


(comment

  (frequencies "abcaa"))
