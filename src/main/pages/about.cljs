(ns main.pages.about
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]))

(defnc about-page []
  (d/div {:class "page about-page"}
    (d/h1 "Who is he 🤨")
    (d/p 
      "I'm the greatest laser artist alive "
      (d/br)
      "(realistically just one of the good ones in the Seattle / PNW area)")
    (d/p
      "Been performing since 2023, big fan of all genres of EDM, but especially trap and dnb")

    (d/h2 "What he do❓")
    (d/p
      "He is primarily a laser operator and uses Beyond. Also experienced with "
      "setting up and operating laser equipment at venues of all sizes. "
      "Performed at various shows ran by small artists, as well as insomniac "
      "festivals. Even performed for notable artists such as Acraze, Reaper, and CHYL")
    (d/p
      "Sometimes he also makes Visuals, (looking to learn to be a VJ soon)")

    (d/h2 "What can I pay him to do 🤑")
    (d/ul {:class "services-list"}
      (d/li "Rent out and setup laser hardware (Seattle only)")
      (d/li "Operate lasers")
      (d/li "Timecoded Laser shows")
      (d/li "Timecoded Visuals (I use TouchDesigner and some Blender)"))))
