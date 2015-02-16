(ns scratch.core)

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
   ;; (get-primes n [] 1))
   ;;(loop [stop n found [] testval 1 count 0]
  (loop [stop stop found [] testval 1]
    (if (= (count found) stop)
      found
      (recur stop
             (if (prime? testval)
               (conj found testval)
               found)
             (inc testval)))))
