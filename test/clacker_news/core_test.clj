(ns clacker-news.core-test
  (:require [clojure.test :refer :all]
            [clacker-news.core :refer :all]))

(deftest test
  (is (vector? (top-100-story-ids)))
  (is (map? (updates)))
  (is (integer? (max-item-id)))
  (is (map? (get-item (max-item-id))))
  (is (map? (get-user "greghendershott"))))
