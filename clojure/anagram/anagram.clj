(ns anagram
  (:require [clojure.string :refer [lower-case]])
  (:require [clojure.data :refer [diff]]))

(defn- exact-same-letters [word other]
  (let [comparison (diff (frequencies word) (frequencies other))]
    (and (= nil (nth comparison 0)) (= nil (nth comparison 1)))))

(defn- is-anagram [word other]
  (let [word (lower-case word) other (lower-case other)]
    (and (not= word other) (exact-same-letters word other))))

(defn anagrams-for [word choices]
  "Return all items from `choices` that are anagrams of `word`."
  (filter (partial is-anagram word) choices))
