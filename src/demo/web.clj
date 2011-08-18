(ns demo.web (:use [ring.adapter.jetty] [BioClojure.seqUtils] ))

(defn demo []
  (let [random_motif (apply str (rand-motif-str (rand-int 30)))
        random_aa (rand-aa-str (rand-int 10))
        translated_aa (aa-to-3-letter "ASADD")]))

(defn app [req]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str ["Welcome Mini-ClotifMiner : The Flagship App of the BioClojure Framework " (rand-motif-str (rand-int 15)) ] )
   }
  )

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty app {:port port})))
