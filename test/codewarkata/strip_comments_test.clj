(ns codewarkata.strip-comments-test
  (:require [clojure.string :as string]
            [clojure.test :refer [deftest are]]))

(defn strip-comments [text symbols]
  (->> (string/split-lines text)
       (map #(string/replace % (re-pattern (str "[" (string/join "|" symbols) "].*")) ""))
       (map string/trimr)
       (string/join \newline)))

(deftest strip-comments-tests
  (are [text symbols expected] (= (strip-comments text symbols) expected)
    "apples, pears # and bananas\ngrapes\nbananas !apples"
    '("#" "!")
    "apples, pears\ngrapes\nbananas"

    "a \n b \nc "
    '("#" "$")
    "a\n b\nc"

    "a #b\nc\nd $e f g"
    '("#" "$")
    "a\nc\nd"))


(+ 1 1)
(string/join \newline ["1" "2"])

(re-find #"\s[1|2].*" "1234556")


(def pattern (re-pattern (str "\\s*[" (string/join "|" ["1" "2"]) "].*")))
(remove #(re-find pattern %) ["# comment" "1 hello" "2 world"])