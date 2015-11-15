(ns rna-transcription
  "Convert a dna strand to rna."
  (:use [clojure.string :only [join]]))

(def ^:private mappings {\G \C, \C \G, \T \A, \A \U})

(defn- get-rna-nucleotide [nucleotide]
  (assert (contains? mappings nucleotide))
  (mappings nucleotide))

(defn to-rna [dna]
  (join (map get-rna-nucleotide dna)))
