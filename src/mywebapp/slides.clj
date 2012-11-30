(ns mywebapp.slides
    (:use [hiccup core page element] mywebapp.views))


(defn big-slide [title body]
            [:section [:h1 title] 
                [:p body]])

(defn big-slide-list [title items]
        [:section [:h1 title]
          (map (fn [x] [:p x]) items)])

(defn slide [items]
        [:section  (map (fn [x] [:p x]) items)])



(defn big-slide-bullets [title items]
        [:section [:h1 title]
          (unordered-list items)])


(defn less-big-slide [title body]
            [:section [:h3 title] 
                [:p body]])

(defn link [url] [:a [:href url]])



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
          ["@michaelneale" "developer.cloudbees.com" "https://github.com/michaelneale/clojure-revealjs"
          (image "/clojure_logo.png")])                         
    (slide [(image "/cloudbees.png") 
        (link "http://developer-blog.cloudbees.com") (link "http://twitter.com/michaelneale")])


    ]]))
















