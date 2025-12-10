(ns main.pages.home
  (:require ["react-router-dom" :refer [useNavigate]]
            [helix.core :refer [defnc $]]
            [helix.dom :as d]
            [main.components.slideshow :refer [image-slideshow]]))

;; Same images used on the pictures page
(def slideshow-images
  ["./images/CHYLPics-2.jpg"
   "./images/CHYLPics-4.jpg"
   "./images/CHYLPics-6.jpg"
   "./images/CHYLPics-13.jpg"
   "./images/CHYLPics-18.jpg"
   "./images/CHYLPics-29.jpg"
   "./images/BASS GIRLS teddy.jpg"
   "./images/REYSUO BW compress.jpg"])

(defnc home-page []
  (let [navigate (useNavigate)]
    (d/div {:class "page home-page"}
      (d/div {:class "home-grid"}
        ;; Videos Card - with animated gif
        (d/div {:class "home-card"
                :on-click #(navigate "/videos")}
          (d/div {:class "home-card-image"}
            (d/img {:src "./images/laserVid.gif"
                    :alt "Videos"
                    :class "home-card-img"})
            (d/div {:class "home-card-overlay-title"} "Videos")))
        
        ;; Pictures Card - with slideshow
        (d/div {:class "home-card"
                :on-click #(navigate "/pictures")}
          (d/div {:class "home-card-image"}
            ($ image-slideshow {:images slideshow-images
                                :interval-ms 2500})
            (d/div {:class "home-card-overlay-title"} "Pictures")))))))
