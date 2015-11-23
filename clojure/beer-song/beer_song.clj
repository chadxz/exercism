(ns beer-song
  (:require [clojure.string :refer [capitalize]]))

(def ^:private s1-format 
  "%s of beer on the wall, %s of beer.\n")
(def ^:private s2-format 
  "Take %s down and pass it around, %s of beer on the wall.\n")
(def ^:private s2-empty
  "Go to the store and buy some more, 99 bottles of beer on the wall.\n")

(defn- englishify [bottles]
  (cond
    (= bottles 0) "no more bottles"
    (= bottles 1) "1 bottle"
    :default (str bottles " bottles")))

(defn verse [bottles]
  (cond
    (= bottles 0)
      (let [eng (englishify bottles) capped (capitalize eng)]
        (str (format s1-format capped eng) s2-empty))
    :default 
      (let [take-what (if (= bottles 1) "it" "one")]
        (str (format s1-format (englishify bottles) (englishify bottles))
              (format s2-format take-what (englishify (- bottles 1)))))))

(defn sing 
  ([start end]
    (str 
      (verse start)
      (when (not= start end) 
        (str "\n" (sing (- start 1) end)))))
  ([start]
    (sing start 0)))
