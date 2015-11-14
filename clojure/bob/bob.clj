(ns bob 
  "a lackadaisical teenager"
  (:use [clojure.string :only [blank?, upper-case]]))

(def response-for
  (fn [input] 
    (cond
      (blank? input) "Fine. Be that way!" 
      (and 
        (= input (upper-case input)) 
        (re-find #"[A-Z]" input)) "Whoa, chill out!"
      (= \? (last input)) "Sure."
      :default "Whatever.")))
