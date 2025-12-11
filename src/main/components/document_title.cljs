(ns main.components.document-title
  (:require
    ["react-router-dom" :refer [useLocation]]
    [helix.core :refer [defnc]]
    [helix.hooks :as hooks]))


(def route-titles
  {"/" nil
   "/pictures" "Pictures"
   "/videos" "Videos"
   "/about" "About"
   "/contact" "Booking"})


(defnc document-title []
  (let [location (useLocation)
        pathname (.-pathname location)]

    (hooks/use-effect
      [pathname]
      (let [page-title (route-titles pathname)
            full-title (if page-title
                         (str "ZuGood Lasers | " page-title)
                         "ZuGood Lasers")]
        (set! (.-title js/document) full-title)))

    nil))
