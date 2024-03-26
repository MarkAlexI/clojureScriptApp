# clojureScriptApp
First app on clojureScript. The project uses only Clojure, without additional tools.
![cljsappimage](/cljs.png "cljsappimage")
For compiling script run in terminal: `clj -M -m cljs.main -d "clojureScriptApp/out" -c app.core -r`.
For building of production bundle run in terminal next command: `clj -M -m cljs.main -O advanced -c "app.core"`.