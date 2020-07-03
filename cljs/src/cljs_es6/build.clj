(ns cljs-es6.build
  (:require [cljs.build.api :as cljs]))

(defn -main []
  (cljs/build "src"
              {:output-dir "target/public/cljs-out"
               :output-to "target/public/cljs-out/main.js"
               :optimizations :advanced
               :main `cljs-es6.main
               :install-deps true
               :npm-deps {"left-pad" "1.3.0"}
               :verbose true
               :pretty-print false
               :source-map false
               :compiler-stats true
               :closure-defines {"goog.DEBUG" false}}))