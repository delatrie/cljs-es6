(ns cljs-es6.main
  (:require [left-pad]
            [goog.dom :refer [getElement]]
            [goog.events :refer [listen EventType]]))

(listen
 (getElement "app-btn")
 (.-CLICK EventType)
 (fn [& _] (js/console.log (str "[" (left-pad "foo" 10) "]"))))