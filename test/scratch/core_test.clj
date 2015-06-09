(ns scratch.core-test
  (:require [clojure.test :refer :all]
            [scratch.core :refer :all]))

(deftest letter-ct-test
  (testing "letter counts correctly"
    (is 1 (letter-ct "w" \w))))

(deftest prime-works-odd
  (testing "returns true when prime"
    (is (prime? 3))))

(deftest prime-works-even
  (testing "retruns false when not prime"
    (is not (prime? 4))))

(deftest prints-table
  (testing "prints a nice table of output"
      (is
       "
   1      1       1
   2      4       8
   3      9      27"
       (with-out-str (print-table (map #(vector % (* % %) (* % % %)) (range 1 3)) 8)))))

(deftest prints-table
  (testing "prints a nice table of output"
    (is "hello" (with-out-str (print "hello")))))
