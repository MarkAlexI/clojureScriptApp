(ns app.core
  (:require-macros [hiccups.core :as hiccups])
  (:require [hiccups.runtime]))
(require '[goog.dom :as gdom])
(require '[goog.dom.classlist :as gc])

(def body (.querySelector js/document "body"))
(def heading (gdom/createElement "h2"))
(gdom/setTextContent heading "Work with html via library Google Closure ('goog.dom')")
(gdom/appendChild body heading)
(gc/add heading "site__secondary_header")

(def paragraph
  (gdom/createElement "p"))
(gdom/setTextContent paragraph "This paragraph is written directly from the source code.")
(gdom/appendChild body paragraph)
(gc/add paragraph "site__paragraph")

(defn create-container-with-gdom []
  (let [container (gdom/createDom "div" #js {:class "container"})]
    (let [header (gdom/createDom "h2" #js {:class "site__secondary_header" :innerText "ClojureScript is harder then JavaScript"})]
      (gdom/appendChild container header))
    (let [paragraph (gdom/createDom "p" #js {:class "site__paragraph" :innerText "Another way to create html with 'goog.dom'."})]
      (gdom/appendChild container paragraph))
    (let [link (gdom/createDom "a" #js {:class "external-link" :href "https://www.braveclojure.com/clojure-for-the-brave-and-true/"} "Clojure for brave and true")]
      (gdom/appendChild container link))
    container))

(defn add-html! []
  (let [container (create-container-with-gdom)]
    (gdom/appendChild (.-body js/document) container)))

(add-html!)

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
