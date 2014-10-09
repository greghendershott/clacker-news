(ns clacker-news.core
  (:require [clj-http.client :as client]
            [clojure.test :refer :all]
            [clj-json.core :as json]))

(declare url->json)

(defn get-item [id]
  (url->json (str "https://hacker-news.firebaseio.com/v0/item/" id ".json")))

(defn get-user [id]
  (url->json (str "https://hacker-news.firebaseio.com/v0/user/" id ".json")))

(defn top-100-story-ids []
  (url->json "https://hacker-news.firebaseio.com/v0/topstories.json"))
  
(defn max-item-id []
  (url->json "https://hacker-news.firebaseio.com/v0/maxitem.json"))

(defn updates []
  (url->json "https://hacker-news.firebaseio.com/v0/updates.json"))

(defn- url->json [url]
  (try
    (json/parse-string (:body (client/get url)))
    (catch org.codehaus.jackson.JsonParseException _ nil)))
