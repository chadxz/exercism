(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn- same-letters? [word other]
  (= (sort word) (sort other)))

(defn- is-anagram? [word other]
  (let [word (lower-case word) other (lower-case other)]
    (and (not= word other) (same-letters? word other))))

(defn anagrams-for [word choices]
  "Return all items from `choices` that are anagrams of `word`."
  (filter (partial is-anagram? word) choices))
