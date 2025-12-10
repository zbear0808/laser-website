(ns main.app
  (:require ["react-dom/client" :as rdom]
            ["react-router-dom" :refer [BrowserRouter Routes Route]]
            [helix.core :refer [defnc $]]
            [helix.dom :as d]
            [main.components.header :refer [header]]
            [main.components.document-title :refer [document-title]]
            [main.pages.home :refer [home-page]]
            [main.pages.pictures :refer [pictures-page]]
            [main.pages.videos :refer [videos-page]]
            [main.pages.about :refer [about-page]]
            [main.pages.contact :refer [contact-page]]))

(defnc app []
  ($ BrowserRouter
    (d/div {:class "app-container"}
      ($ document-title)
      ($ header)
      (d/main {:class "main-content"}
        ($ Routes
          ($ Route {:path "/" :element ($ home-page)})
          ($ Route {:path "/pictures" :element ($ pictures-page)})
          ($ Route {:path "/videos" :element ($ videos-page)})
          ($ Route {:path "/about" :element ($ about-page)})
          ($ Route {:path "/contact" :element ($ contact-page)}))))))

(defonce root
  (rdom/createRoot 
    (js/document.getElementById "app")))

(defn render []
  (.render root ($ app)))

(defn ^:export init []
  (render))
