(ns main.components.slideshow
  (:require
    [helix.core :refer [defnc $]]
    [helix.dom :as d]
    [helix.hooks :as hooks]))


(defnc image-slideshow [{:keys [images interval-ms]
                         :or {interval-ms 3000}}]
  (let [[current-index set-current-index!] (hooks/use-state 0)]

    (hooks/use-effect
      [current-index]
      (let [timer (js/setTimeout
                    #(set-current-index! (fn [idx]
                                           (mod (inc idx) (count images))))
                    interval-ms)]
        (fn [] (js/clearTimeout timer))))

    (d/div {:class "slideshow-container"}
           (for [[idx image] (map-indexed vector images)]
             (d/img {:key idx
                     :src image
                     :alt (str "Slide " (inc idx))
                     :class (str "slideshow-image "
                                 (when (= idx current-index) "active"))})))))
