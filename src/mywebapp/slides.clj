(ns mywebapp.slides
    (:use [hiccup core page element] mywebapp.views))


(defn big-slide [title body]
            [:section [:h1 title] 
                [:p body]])

(defn big-slide-soothe [title body]
            [:section {:data-state "soothe"} [:h1 title] 
                [:p body]])

(defn big-slide-alert [title body]
            [:section {:data-state "alert"} [:h1 title] 
                [:p body]])


(defn big-slide-list [title & items]
        [:section [:h1 title]
          (map (fn [x] [:p x]) items)])

(defn slide [& items]
        [:section [:h ""]  (map (fn [x] [:p x]) items)])




(defn big-slide-bullets [title & items]
        [:section [:h1 title]
          (unordered-list items)])


(defn less-big-slide [title body]
            [:section [:h3 title] 
                [:p body]])

(defn link [url] [:a {:href url} url])




(defn code-block [code]
    (str 
        "<pre><code contenteditable style=\"font-size: 18px; margin-top: 20px;\">" 
        code "</code></pre>"))    
    

(defn slides-page []
  (template   
   [:div {:class "reveal"}
   [:div {:class "slides"}
    (big-slide-list 
        "Clojure - another run at lisp"
          "@michaelneale" (link "developer.cloudbees.com") "https://github.com/michaelneale/clojure-revealjs"
          (image "/clojure_logo.png"))                         
    (slide (image "/cloudbees.png") 
        (link "http://developer.cloudbees.com") (link "http://twitter.com/michaelneale"))

    (big-slide-bullets "What is Clojure" "Another take on lisp" "Lisp 1"
        (link "http://stackoverflow.com/questions/4578574") 
        "A lisp JVM/CLR and JS targeting (LLVM too?)")
    (big-slide-alert "I n c e p t i o n" (image "/presentation.png"))

    (big-slide-list "What is LISP?" 
        "A toolkit for building a language to solve your problems (a DSL)"
        "The language the universe was written in")

    (big-slide-soothe (image "/lisp_god.png") "")
    (big-slide-alert (image "/mccarthy.png") "")

    (big-slide-list "STAY CALM" "don't let the parens put you off" 
        "S-expressions are like the AST directly"
         "S-expressions allow macros to actually work"
         "Homoiconic - data is functions is data"
         )

    (slide (code-block "(function-name [arguments] do stuff)\n;; comments"))
    (big-slide-list "learning" 
        "Took me a long weekend to feel almost comfortable"
        "MIT SICP lectures - excellent")

    (big-slide-list "where is clojure used" 
            "Anywhere JVM can run (server side)"
            "Big data apps (eg flightcaster backend)"
            "Web apps"
            "in the browser (clojurescript)"
            "At CloudBees")

    (slide "A project (using Leiningen)" (image "/project_setup.png"))

    (slide "Consuming a http service" (image "/http_api.png"))

    (slide "Loading all the repos in a github org" (image "/github.png"))

    (big-slide-alert "my god it's full of parentheses" (image "/fullofstars.png"))

    (big-slide "REPL" (image "/repl.png"))

    (big-slide "filtering" (image "/filtering.png"))

    (big-slide "rest http" (image "/http_rest.png"))

    

    ]]))
















