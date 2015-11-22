(ns word-count
  "Count the number of occurrences of each word in a phrase."
 (:refer-clojure :exclude [replace])
 (:require [clojure.string :refer [split replace lower-case blank?]]))

(defn- tally [state word]
  (let [w (lower-case (replace word #"[^A-Za-z0-9]" ""))]
    (if (blank? w)
        (identity state)
        (assoc state w (+ 1 (or (state w) 0))))))

(defn word-count [phrase]
  (reduce tally {} (split phrase #" ")))
