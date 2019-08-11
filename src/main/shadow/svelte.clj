(ns shadow.svelte
  (:require
   [clojure.java.io :as io]
   [cljs.compiler :as cljs-comp]
   [clojure.string :as str]
   [hiccup.core :as h]))

(defn all-vars [state]
  (for [[ns ns-info] (get-in state [:compiler-env :cljs.analyzer/namespaces])
        ns-def (-> ns-info :defs vals)]
    ns-def))

(defn create-pages
  {:shadow.build/stage :flush}
  [state]
  (doseq [ns-def (all-vars state)
          :when (get-in ns-def [:meta :svelte/page])]

    (let [{:svelte/keys [page]}
          (:meta ns-def)

          page-ns
          (-> ns-def :name namespace cljs-comp/munge)

          page-var
          (-> ns-def :name name cljs-comp/munge)

          ;; Y U NO DATA THIS!
          content
          (h/html [:h1 "hello world"])

          out-dir
          (io/file "site" "src")

          out-file
          (io/file out-dir (str page ".svelte"))]
      (println "ns-def" ns-def)

      (io/make-parents out-file)
      (spit out-file content)))
  state)