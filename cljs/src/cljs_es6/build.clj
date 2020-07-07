(ns cljs-es6.build
  (:require [cljs.build.api :as cljs]))

(def builds {:debug {:output-dir "target/public/cljs-out/dev"
                     :output-to "target/public/cljs-out/dev/main.js"
                     :asset-path "cljs-out/dev"
                     :optimizations :none
                     :pretty-print true
                     :source-map true}
             :release {:output-dir "target/public/cljs-out/prod"
                       :output-to "target/public/cljs-out/prod/main.js"
                       :asset-path "cljs-out/prod"
                       :optimizations :advanced
                       :pretty-print false
                       :source-map false
                       :closure-defines {"goog.DEBUG" false}}})

(defn -main [b]
  (cljs/build
   "src"
   (merge
    ((keyword b) builds)
    {:main `cljs-es6.main
     :install-deps true
     :npm-deps {"left-pad" "1.3.0"
                "@delatrie-org/cljs-es6-1" "0.0.2"
                "@delatrie-org/cljs-es6-2" "0.0.3"
                "@delatrie-org/cljs-es6-3" "0.0.3"
                "@delatrie-org/cljs-es6-4" "0.0.5"}
     :verbose true
     :compiler-stats true})))