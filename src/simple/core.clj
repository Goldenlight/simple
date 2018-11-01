(ns simple.core
  (:require
    [ring.adapter.jetty :refer [run-jetty]]
    [ring.middleware.params :as p]
    [simple.middleware :as m]
    [ring.middleware.multipart-params :as mp]
    [simple.routes :as r]
  (:gen-class)))

;;(def app (-> r/ring.util.request---body-string))
;;(def app (-> r/ring.handler.dump---handle-dump))


;;(def app (-> r/hnadler007
;;             mp/wrap-multipart-params))
;;(def app ))
(defonce server
;;  (run-jetty #'r/handler007 {:port 36909 :join? false}))
  (run-jetty #'r/app {:port 36909 :join? false}))

  (defn -main
  [& args]
  (println "core.clj: in -main running defonce'd server")
  (.start server))


(defn all-methods [x]
  (->> x reflect
       :members
       (filter :return-type)
       (map :name)
       sort
       (map #(str "." %) )
       distinct
       println))

;; (def app
;;   (-> r/routes
;;       m/logger
;;       m/req-res-displayer
;;       p/wrap-params))
