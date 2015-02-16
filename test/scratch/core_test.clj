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
