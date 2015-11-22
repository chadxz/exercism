(ns bob 
  "a lackadaisical teenager"
  (:use [clojure.string :only [blank?, upper-case]]))

(defn yelling? [input]
  (and (= input (upper-case input)) 
       (not= nil (re-find #"[A-Z]" input))))

(defn response-for [input] 
  (cond
    (blank? input) "Fine. Be that way!" 
    (yelling? input) "Whoa, chill out!"
    (= \? (last input)) "Sure."
    :default "Whatever."))
