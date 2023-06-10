(ns codewarkata.reverse-or-rotate-test
  (:require [clojure.string :as string]
            [clojure.test :refer [deftest is testing]]))

(defn rotate [lst]
  (concat (rest lst) (list (first lst))))

(defn process-chunk [chunk]
  (let [cube-sum (->> chunk
                      (map #(Integer/parseInt (str %)))
                      (map #(* % % %))
                      (reduce +))]
    (string/join (if (zero? (mod cube-sum 2))
      (reverse chunk)
      (rotate chunk)))))

(defn revrot [strng sz]
  (if (or (<= sz 0) (empty? strng) (> sz (count strng)))
    ""
    (let [chunked (partition sz strng)]
      (->> chunked
           (map process-chunk)
           (string/join)))))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest process-chunk-test
  (testing "process chunk"
    (is (= "4466" (process-chunk '(\6 \6 \4 \4))))
    (is (= "234561" (process-chunk '(\1 \2 \3 \4 \5 \6))))))

(deftest a-test1
  (testing "revrot"
    (test-assert (revrot "1234" 0) "")
    (test-assert (revrot  "" 0) "")
    (test-assert (revrot "1234", 5), "")
    (test-assert (revrot "733049910872815764", 5), "330479108928157")))

