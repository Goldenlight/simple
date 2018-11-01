(ns simple.routes
  (:require
    [compojure.core :refer [defroutes GET POST]]
;;    [compojure-simple.route :refer [not-found]]
    [simple.views :as v]
;;    [simple.routes :as r]
    [clojure.java.io :as io]
;;    [ring.middleware :as m]
  ))

 (defroutes app
   (GET "/" req (v/main req)) 
;;   (GET "/get-form.html" req (v/get-form req))
   (GET "/post-form.html" req (v/post-form req))
;;   (GET "/get-submit" req (v/display-result req))
;; ;;  (POST "/post-submit" req (doseq [ [k v] req ] (println k v)))
   (POST "/post-submit" req (v/ring.util.request---body-string req))
;; ;;  (POST "/post-submit" req (v/display-result req))
;; ;;  (not-found (v/not-found)))
   )

