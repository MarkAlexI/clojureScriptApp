(ns app.core
  (:require-macros [hiccups.core :as hiccups])
  (:require [hiccups.runtime]))
(require '[goog.dom :as gdom])
(require '[goog.dom.classlist :as gc])

(def body (.querySelector js/document "body"))
(def heading (gdom/createElement "h2"))
(gdom/setTextContent heading "Work with html via library 'goog.dom'")
(gdom/appendChild body heading)
(gc/add heading "site__secondary_header")

(def paragraph
  (gdom/createElement "p"))
(gdom/setTextContent paragraph "This paragraph is written directly from the source code.")
(gdom/appendChild body paragraph)
(gc/add paragraph "site__paragraph")

(def hic-container 
  (gdom/createDom "div" #js {:id "hic-container"
                             :class "container"}))
(gdom/appendChild body hic-container)

(defn set-app-html! [html-str]
  (set! (.-innerHTML hic-container) html-str))

(defn render-app! []
  (set-app-html!
    (hiccups/html
      [:h2.site__secondary_header "Work with html via package 'hiccups'"]
      [:p.site__paragraph "This paragraph is written with render function."]
      [:a {:href "https://github.com/teropa/hiccups"
           :class "external-link"}
           "Hiccups"])))

(set! (.. js/document -body -style -backgroundColor) "smokewhite")
(render-app!)
