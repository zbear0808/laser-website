(ns main.components.footer
  (:require
    [helix.core :refer [defnc]]
    [helix.dom :as d]))


(defnc footer []
  (d/footer {:class "footer"}
            (d/div {:class "footer-social-links"}
                   ;; Instagram
                   (d/a {:href "https://instagram.com/zugood"
                         :target "_blank"
                         :rel "noopener noreferrer"
                         :class "btn social-link social-link-instagram"
                         :aria-label "Instagram"}
                        (d/svg {:xmlns "http://www.w3.org/2000/svg"
                                :width "24"
                                :height "24"
                                :viewBox "0 0 24 24"
                                :fill "none"
                                :stroke "currentColor"
                                :stroke-width "2"
                                :stroke-linecap "round"
                                :stroke-linejoin "round"}
                               (d/rect {:x "2" :y "2" :width "20" :height "20" :rx "5" :ry "5"})
                               (d/path {:d "M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"})
                               (d/line {:x1 "17.5" :y1 "6.5" :x2 "17.51" :y2 "6.5"})))

                   ;; LinkedIn
                   (d/a {:href "https://linkedin.com/in/zubaira2"
                         :target "_blank"
                         :rel "noopener noreferrer"
                         :class "btn social-link social-link-linkedin"
                         :aria-label "LinkedIn"}
                        (d/svg {:xmlns "http://www.w3.org/2000/svg"
                                :width "24"
                                :height "24"
                                :viewBox "0 0 24 24"
                                :fill "none"
                                :stroke "currentColor"
                                :stroke-width "2"
                                :stroke-linecap "round"
                                :stroke-linejoin "round"}
                               (d/path {:d "M16 8a6 6 0 0 1 6 6v7h-4v-7a2 2 0 0 0-2-2 2 2 0 0 0-2 2v7h-4v-7a6 6 0 0 1 6-6z"})
                               (d/rect {:x "2" :y "9" :width "4" :height "12"})
                               (d/circle {:cx "4" :cy "4" :r "2"})))

                   ;; YouTube
                   (d/a {:href "#"  ; Placeholder - fill in your YouTube URL
                         :target "_blank"
                         :rel "noopener noreferrer"
                         :class "btn social-link social-link-youtube"
                         :aria-label "YouTube"}
                        (d/svg {:xmlns "http://www.w3.org/2000/svg"
                                :width "24"
                                :height "24"
                                :viewBox "0 0 24 24"
                                :fill "none"
                                :stroke "currentColor"
                                :stroke-width "2"
                                :stroke-linecap "round"
                                :stroke-linejoin "round"}
                               (d/path {:d "M22.54 6.42a2.78 2.78 0 0 0-1.94-2C18.88 4 12 4 12 4s-6.88 0-8.6.46a2.78 2.78 0 0 0-1.94 2A29 29 0 0 0 1 11.75a29 29 0 0 0 .46 5.33A2.78 2.78 0 0 0 3.4 19c1.72.46 8.6.46 8.6.46s6.88 0 8.6-.46a2.78 2.78 0 0 0 1.94-2 29 29 0 0 0 .46-5.25 29 29 0 0 0-.46-5.33z"})
                               (d/polygon {:points "9.75 15.02 15.5 11.75 9.75 8.48 9.75 15.02"})))

                   ;; Email
                   (d/a {:href "mailto:zugood.lasers@gmail.com"
                         :class "btn social-link social-link-email"
                         :aria-label "Email"}
                        (d/svg {:xmlns "http://www.w3.org/2000/svg"
                                :width "24"
                                :height "24"
                                :viewBox "0 0 24 24"
                                :fill "none"
                                :stroke "currentColor"
                                :stroke-width "2"
                                :stroke-linecap "round"
                                :stroke-linejoin "round"}
                               (d/path {:d "M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z"})
                               (d/polyline {:points "22,6 12,13 2,6"}))))))
