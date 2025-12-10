(ns main.pages.pictures
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]))

(def image-files
  ["BASS GIRLS teddy.jpg"
   "BASS GIRLS wide.jpg"
   "boogie boi.jpg"
   "CHYLPics-13.jpg"
   "CHYLPics-18.jpg"
   "CHYLPics-2.jpg"
   "CHYLPics-29.jpg"
   "CHYLPics-4.jpg"
   "CHYLPics-6.jpg"
   "crowd.jpg"
   "gensuo VERT.jpg"
   "gudemami.jpg"
   "indigo b2b.jpg"
   "REYSUO BW compress.jpg"
   "REYSUO BW full frame.jpg"
   "REYSUO front stage.jpg"
   "REYSUO vert.jpg"
   "yeahdudesame.jpg"])

(defnc picture-item [{:keys [filename]}]
  (d/div {:class "picture-container"}
    (d/img {:src (str "./images/" filename)
            :alt filename
            :class "picture-img"
            :loading "lazy"})))

(defnc pictures-page []
  (d/div {:class "page pictures-page"}
    (d/h1 "Pictures")
    (d/div {:class "pictures-grid"}
      (for [filename image-files]
        ($ picture-item {:key filename :filename filename})))))
