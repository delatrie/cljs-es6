(ns cljs-es6.main
  (:require [goog.dom :refer [getElement]]
            [goog.events :refer [listen EventType]]
            [left-pad]
            ["@delatrie-org/cljs-es6-1" :refer [enhanceValue]]
            ["@delatrie-org/cljs-es6-2" :refer [enhanceValue] :rename {enhanceValue enhanceValue2}]
            ["@delatrie-org/cljs-es6-3" :as es6-3]))

(doseq [[e h] (->> {"commonjs" #(left-pad % 10)
                    "es6-1" enhanceValue
                    "es6-2" enhanceValue2
                    "es6-3" #((.-default es6-3) %)}
                   (map
                    (fn [[id f]]
                      [(getElement id)
                       (fn [& _] (js/alert (str "[" (f "stranger") "]")))])))]
  (listen e (.-CLICK EventType) h))