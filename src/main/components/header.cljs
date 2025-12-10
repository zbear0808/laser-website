(ns main.components.header
  (:require ["react-router-dom" :refer [useNavigate]]
            [helix.core :refer [defnc $]]
            [helix.dom :as d]
            [helix.hooks :as hooks]))

(defnc header []
  (let [navigate (useNavigate)
        [sidebar-open? set-sidebar-open!] (hooks/use-state false)
        toggle-sidebar #(set-sidebar-open! not)
        close-sidebar #(set-sidebar-open! false)
        navigate-and-close (fn [path]
                             (navigate path)
                             (close-sidebar))]
    (d/header {:class "header"}
      ;; Desktop Navigation (left)
      (d/nav {:class "header-nav header-nav-left desktop-only"}
        (d/button {:class "header-link"
                   :on-click #(navigate "/pictures")}
          "Pictures")
        (d/button {:class "header-link"
                   :on-click #(navigate "/videos")}
          "Videos"))
      
      ;; Mobile Hamburger Button
      (d/button {:class "hamburger-btn mobile-only"
                 :on-click toggle-sidebar
                 :aria-label "Toggle navigation menu"}
        (d/span {:class (str "hamburger-icon " (when sidebar-open? "open"))}
          (d/span {:class "hamburger-line"})
          (d/span {:class "hamburger-line"})
          (d/span {:class "hamburger-line"})))
      
      ;; Title/Name (always visible)
      (d/div {:class "header-title"}
        (d/h1 {:class "header-name"
               :on-click #(do (navigate "/") (close-sidebar))}
          "ZUBAIR AHMED"))
      
      ;; Desktop Navigation (right)
      (d/nav {:class "header-nav header-nav-right desktop-only"}
        (d/button {:class "header-link"
                   :on-click #(navigate "/about")}
          "About Me")
        (d/button {:class "header-link"
                   :on-click #(navigate "/contact")}
          "Booking"))
      
      ;; Mobile placeholder for layout balance
      (d/div {:class "header-spacer mobile-only"})
      
      ;; Mobile Sidebar Overlay
      (d/div {:class (str "sidebar-overlay " (when sidebar-open? "open"))
              :on-click close-sidebar})
      
      ;; Mobile Sidebar
      (d/nav {:class (str "sidebar " (when sidebar-open? "open"))}
        (d/div {:class "sidebar-links"}
          (d/button {:class "sidebar-link"
                     :on-click #(navigate-and-close "/pictures")}
            "Pictures")
          (d/button {:class "sidebar-link"
                     :on-click #(navigate-and-close "/videos")}
            "Videos")
          (d/button {:class "sidebar-link"
                     :on-click #(navigate-and-close "/about")}
            "About Me")
          (d/button {:class "sidebar-link"
                     :on-click #(navigate-and-close "/contact")}
            "Booking"))))))
