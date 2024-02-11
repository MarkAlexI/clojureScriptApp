(ns app.core)
(require '[goog.dom :as gdom])
(require '[goog.dom.classlist :as gc])

(def body (.querySelector js/document "body"))
(def heading (gdom/createElement "h2"))
(gdom/setTextContent heading "Work with html via goog.dom")
(gc/add heading "site__secondary_header")
(gdom/appendChild body heading)

(def paragraph (gdom/createElement "p"))
(gdom/setTextContent paragraph "This paragraph is written directly from the source code.")
(gc/add paragraph "site__paragraph")
(gdom/appendChild body paragraph)

(set! (.. js/document -body -style -backgroundColor) "smokewhite")
