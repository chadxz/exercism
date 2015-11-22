(ns word-count
  "Count the number of occurrences of each word in a phrase."
 (:require [clojure.string :refer [split lower-case]]))

(defn word-count [phrase]
  (->> (split phrase #"\W+")
       (map lower-case)
       (frequencies)))
