(ns simple.views
  (:require [ring.handler.dump :as rhd]
            [ring.util.request :as rur]))

(defn main [req]
   "<div>
      <h1>Hello Web Page with Routing!</h1>
      <p>What would you like to do?</p>
      <p><a href='./get-form.html'>Submit a GET request</a></p>
      <p><a href='./post-form.html'>Submit a POST request</a></p>
    </div>")

(defn get-form [req]
   "<div>
      <h1>Hello GET Form!</h1>
      <p>Submit a message with GET</p>
      <form method=\"get\" action=\"get-submit\">
       <input type=\"text\" name=\"name\" />
       <input type=\"submit\" value\"submit\" />
      </form>
      <p><a href='..'>Return to main page</p>
    </div>")

(defn post-form [req]
   "<div>
      <h1>Hello POST Form!</h1>
      <p>Submit a message with POST</p>
      <form method=\"post\" action=\"post-submit\">
      <input type=\"text\" name=\"name\" />
       <input type=\"submit\" value\"submit\" />
      </form>
      <p><a href='..'>Return to main page</p>
    </div>")

(defn display-result [req]
  (let [rq req {:keys [params uri]} req
        param-name (get params "name")
        param-body (get params "body")
        req-type (if (= uri "/get-submit") "GET" "POST")]
    (str
     "<div><p>"        
     (println (str "BODY\n<br>" (type param-body)))
     (doseq [[k v] rq] (println (str "debug" k "    "v)))  "</p>
        <h1>Hello " param-name "!</h1>
        <p>Submitted via a " req-type " request.</p>
        <p><a href='..'>Return to main page</p>
      </div>")))

(defn not-found []
  "<h1>404 Error!</h1>
   <b>Page not found!</b>
   <p><a href='..'>Return to main page</p>")

(def DEBUG "<br>DEBUG::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br>")

(defn ring.handler.dump---handle-dump
  [req]
  (rhd/handle-dump req))

(defn ring.util.request---body-string
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (rur/body-string req)})

;;  {:status 200
;;   :headers {"Content-Type" "text/html"}
;;   :oogie {"a" "b"}
;;   :body (rhd/handle-dump req)     })
;;   :body (str   (rur/body-string {:a 1, :b 2}) DEBUG (rhd/handle-dump req)     )})
;;   :body (str (rhd/handle-dump req) (seq (v/showbody req)) (rur/body-string req))})
;;   :body (str (:remote-addr req) "<br>" (rur/body-string req) "<br>" (rhd/handle-dump req))})

(defn showbody
  [req]
  (for [ [k v] req ] (str k " "  v)))
