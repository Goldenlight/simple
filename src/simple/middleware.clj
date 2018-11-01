(ns simple.middleware)

(defonce log-atom (atom []))
(defn logger [handler]
  (fn [req]
    (let [res (handler req)]
      (swap! log-atom #(conj % {:request req :response res}))
      res)))

(defn req-res-displayer [handler]
  (fn [req]
    (let [res (handler req)]
      (println "\nRequest:")
      (clojure.pprint/pprint req)
      (println "\nResponse:")
      (clojure.pprint/pprint res)
      res)))
