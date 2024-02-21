(ns app.core
  (:require-macros [hiccups.core :as hiccups])
  (:require [hiccups.runtime]))
(require '[goog.dom :as gdom])

(def body (.querySelector js/document "body"))
(def div (gdom/createElement "div"))
(gdom/appendChild body div)
(gdom/setProperties div #js {"class" "container"})

(def heading (gdom/createElement "h2"))
(gdom/setTextContent heading "Work with html via library Google Closure ('goog.dom')")
(gdom/appendChild div heading)
(gdom/setProperties heading #js {"class" "site__secondary_header"})

(def paragraph
  (gdom/createElement "p"))
(gdom/setTextContent paragraph "This paragraph is written directly from the source code.")
(gdom/appendChild div paragraph)
(gdom/setProperties paragraph #js {"class" "site__paragraph"})

(def link (gdom/createElement "a"))
(gdom/setTextContent link "Google Closure")
(gdom/appendChild div link)
(gdom/setProperties link #js {:class "external-link" :href "https://github.com/google/closure-library"})

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
           "Hiccups"]

      [:hr]
      [:h2.site__secondary_header "Issues"]
      [:h3.site__small_header "Нотатки на полях проекту"]
      [:p.site__paragraph "Після завершення великого проекту ("
        [:a {:href "https://github.com/MarkAlexI/bestOnlineStore"
           :class "external-link"}
           "Lykke Store"]
        "), який був для мене переломним, бо я настільки в backend ще не забирався, закортіло на деякий час переключитися."]
      [:p.site__paragraph "На очі трапило відео з Олександром Соловйовим "
        [:a {:href "https://youtu.be/jkaNm97QeLs?si=IzMm-Cw6ExMV5JsT"
           :class "external-link"}
           "Functional Reactive Programming & ClojureScript"]
        ", в якому ведучий дуже шикарно розказав про ClojureScript."]

      [:hr]
      [:h3.site__small_header "Передумови"]
      [:p.site__paragraph "JavaScript - класний і потужний. Не вважаю доцільним відмовлятися, або ховатися від нього. Closure(Script) зацікавила, передусім, можливістю альтернативи."]
      [:p.site__paragraph "Прогулянка передбачалася легкою."]

      [:hr]
      [:h3.site__small_header "Перші враження"]
      [:p.site__paragraph "Є ряд інструментів для роботи з Clojure(Script). І це перша найскладніша задача - що і чому використовувати. Більшість матеріалів поверхові. Довелось багато читати і працювати з терміналом."]
      [:p.site__paragraph "Також легкість Clojure поверхова - якби це була моя перша мова, я б голову зламав."]
      [:p.site__paragraph "Наостанок - для доступу до JavaScript є п'ять форм нотації. Головоломка ускладнюється."]

      [:hr]
      [:h3.site__small_header "Перші висновки"]
      [:p.site__paragraph "Два тижні перечитування технічної документації та експериментів з терміналом в сукупності відібрали час та привели до того, що цей проект радше 'перший млинець нанівець', без серйозної віддачі."]
      [:p.site__paragraph "Заплановану ціль не досягнуто. Проект лишиться як є, ознайомчим. Сам процес був цікавим, поступове занурення в Clojure продовжу, але без фанатизму."]
      [:p.site__paragraph "До речі, "
        [:a {:href "https://www.codewars.com/users/MarkAlexI"
           :class "external-link"}
           "Codewars"]
        " підтримує Clojure. Ознайомлення продовжується."]

      [:hr]
      [:h3.site__small_header "Корисні посилання"]
      [:p.site__paragraph "Ось дещо, відфільтроване."]
      [:ul
        [:li "#"]
        [:li "@"]
        [:li "$"]]
)))

(set! (.. js/document -body -style -backgroundColor) "smokewhite")
(render-app!)
