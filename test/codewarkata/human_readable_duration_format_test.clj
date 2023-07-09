(ns codewarkata.human-readable-duration-format-test
  (:require [clojure.string :as string]
            [clojure.test :refer [deftest is]]))

(defn format-output [components]
  (if (= 1 (count components))
    (apply str components)
    (let [units (butlast components)
          l (last components)]
      (str (string/join ", " units) " and " l))))

(defn calculate-parts [secs unit multiplier next-fn]
  (let [curr (str (quot secs multiplier) " " unit (when (not= 1 (quot secs multiplier)) "s"))
        remainder (rem secs multiplier)]
    (if (zero? remainder)
      [curr]
      (vec (cons curr (next-fn remainder))))))

(defn calculate-duration [secs]
  (cond
    (= 0 secs)
    ["now"]

    (< secs 60)
    [(str secs " second" (when (not= 1 secs) "s"))]

    (< secs 3600)
    (calculate-parts secs "minute" 60 calculate-duration)

    (< secs 86400)
    (calculate-parts secs "hour" 3600 calculate-duration)

    (< secs (* 86400 365))
    (calculate-parts secs "day" 86400 calculate-duration)

    :else
    (calculate-parts secs "year" (* 86400 365) calculate-duration)))

(defn formatDuration [secs]
  (format-output (calculate-duration secs)))

(deftest test-human-readable-duration
  (is (= (formatDuration 0) "now"))
  (is (= (formatDuration 1) "1 second"))
  (is (= (formatDuration 62) "1 minute and 2 seconds"))
  (is (= (formatDuration 120) "2 minutes"))
  (is (= (formatDuration 3600) "1 hour"))
  (is (= (formatDuration 3662) "1 hour, 1 minute and 2 seconds"))
  (is (= (formatDuration 132030240) "4 years, 68 days, 3 hours and 4 minutes")))
