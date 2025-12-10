(ns main.components.header
  (:require ["react-router-dom" :refer [useNavigate]]
            [helix.core :refer [defnc]]
            [helix.dom :as d]
            [helix.hooks :as hooks]))

(defnc header []
  (let [navigate (useNavigate)
        [sidebar-open? set-sidebar-open!] (hooks/use-state false)
        [is-hovering? set-hovering!] (hooks/use-state false)
        [offset-x set-offset-x!] (hooks/use-state 0)
        [offset-y set-offset-y!] (hooks/use-state 0)
        title-ref (hooks/use-ref nil)
        toggle-sidebar #(set-sidebar-open! not)
        close-sidebar #(set-sidebar-open! false)
        navigate-and-close (fn [path]
                             (navigate path)
                             (close-sidebar))
        
        ;; Handle mouse movement to calculate offset
        handle-mouse-move (fn [e]
                           (when-let [element @title-ref]
                             (let [rect (.getBoundingClientRect element)
                                   x (.-clientX e)
                                   y (.-clientY e)
                                   element-x (.-left rect)
                                   element-y (.-top rect)
                                   element-width (.-width rect)
                                   element-height (.-height rect)
                                   center-x (+ element-x (/ element-width 2))
                                   center-y (+ element-y (/ element-height 2))
                                   offset-from-center-x (- x center-x)
                                   offset-from-center-y (- y center-y)
                                   ;; Normalize to -1 to 1 range
                                   normalized-x (/ offset-from-center-x (/ element-width 2))
                                   normalized-y (/ offset-from-center-y (/ element-height 2))
                                   ;; Clamp values
                                   clamped-x (max -1 (min 1 normalized-x))
                                   clamped-y (max -1 (min 1 normalized-y))]
                               (set-offset-x! clamped-x)
                               (set-offset-y! clamped-y))))
        
        ;; Handle mouse enter
        handle-mouse-enter (fn [e]
                            (set-hovering! true)
                            (handle-mouse-move e))
        
        ;; Handle mouse leave
        handle-mouse-leave (fn []
                            (set-hovering! false)
                            (set-offset-x! 0)
                            (set-offset-y! 0))]
    (d/header {:class "header"}
      (d/nav {:class "header-nav header-nav-left desktop-only"}
        (d/button {:class "btn header-link"
                   :on-click #(navigate "/pictures")}
          "Pictures")
        (d/button {:class "btn header-link"
                   :on-click #(navigate "/videos")}
          "Videos"))
      
      (d/button {:class "hamburger-btn mobile-only"
                 :on-click toggle-sidebar
                 :aria-label "Toggle navigation menu"}
        (d/span {:class (str "hamburger-icon " (when sidebar-open? "open"))}
          (d/span {:class "hamburger-line"})
          (d/span {:class "hamburger-line"})
          (d/span {:class "hamburger-line"})))
      
      (d/div {:class "header-title"}
        (d/h1 {:ref title-ref
               :class (str "header-name" (when is-hovering? " trichromatic"))
               :style {:--offset-x offset-x
                      :--offset-y offset-y}
               :on-click #(do (navigate "/") (close-sidebar))
               :on-mouse-enter handle-mouse-enter
               :on-mouse-move handle-mouse-move
               :on-mouse-leave handle-mouse-leave}
          "ZUBAIR AHMED"))
      
      (d/nav {:class "header-nav header-nav-right desktop-only"}
        (d/button {:class "btn header-link"
                   :on-click #(navigate "/about")}
          "About Me")
        (d/button {:class "btn header-link"
                   :on-click #(navigate "/contact")}
          "Booking"))
      
      ;; Mobile placeholder for layout balance
      (d/div {:class "header-spacer mobile-only"})
      
      (d/div {:class (str "sidebar-overlay " (when sidebar-open? "open"))
              :on-click close-sidebar})
      
      (d/nav {:class (str "sidebar " (when sidebar-open? "open"))}
        (d/div {:class "sidebar-links"}
          (d/button {:class "btn sidebar-link"
                     :on-click #(navigate-and-close "/pictures")}
            "Pictures")
          (d/button {:class "btn sidebar-link"
                     :on-click #(navigate-and-close "/videos")}
            "Videos")
          (d/button {:class "btn sidebar-link"
                     :on-click #(navigate-and-close "/about")}
            "About Me")
          (d/button {:class "btn sidebar-link"
                     :on-click #(navigate-and-close "/contact")}
            "Booking"))))))
