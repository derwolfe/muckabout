(ns scratch.core
  (:require [clojure.math.numeric-tower :as math])
  (:require [clojure.pprint :as pprint]))

(defn letter-ct
  "get the letter count"
  [word ltr]
  {:pre [(string? word) (char? ltr)]}
  (count (filter (fn [x] (= x ltr)) (seq word))))

(defn prime? [n]
  (let [div? (fn [div] (zero? (rem n div)))]
    (cond
      (<= n 3) (>= n 2)
      (or (div? 2) (div? 3)) false
      :else (loop [i 5]
              (cond
                (> (* i i) n) true
                (or (div? i) (div? (+ i 2))) false
                :else (recur (+ i 6)))))))

(defn get-primes
  [stop]
  (loop [stop stop found [] testval 1]
    (if (= (count found) stop)
      found
      (recur stop
             (if (prime? testval)
               (conj found testval)
               found)
             (inc testval)))))

(defn nth-prime
  [stop]
  (loop [stop stop
         count 0
         testval 1
         last-prime 0]
    (if (= count stop)
      last-prime
      (recur stop
             (if (prime? testval)
               (inc count)
               count)
             (inc testval)
             testval))))


(defn make-big
  [stop]
  (math/sqrt (reduce + 0
                     (filter odd?
                             (get-primes stop)))))

(defn print-table [aseq column-width]
  (binding [*out* (pprint/get-pretty-writer *out*)]
    (doseq [row aseq]
      (doseq [col row]
        (pprint/cl-format true "~4D~7,vT" col column-width))
      (prn))))

;;(print-table (map #(vector % (* % %) (* % % %)) (range 1 11)) 8)))))
