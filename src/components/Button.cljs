(ns components.Button
  (:require ["react-native" :refer [View Text Pressable StyleSheet]]
            ["@expo/vector-icons/FontAwesome$default" :as FontAwesome]))

(declare styles)

(defn Button
  [{:keys [label theme]}]
  (if (= theme "primary")
    #jsx [View {:style (merge styles.buttonContainer
                              {:borderWidth 4 :borderColor "#ffd33d" :borderRadius 18})}
          #jsx [Pressable {:style  (merge styles.button {:backgroundColor "#fff"})
                           :onPress (fn [] (js/alert "You pressed a Primary button "))}
                [FontAwesome {:name "picture-o"
                              :size 18
                              :color "#25292e"
                              :style styles.buttonIcon}]
                [Text {:style (assoc styles.buttonLabel :color "#25292e")} label]]]

    #jsx  [View {:style styles.buttonContainer}
           [Pressable {:style styles.button
                       :onPress (fn [] (js/alert "You pressed a button"))}
            [Text {:style (do [styles.buttonLabel {:color "red"}])} label]]]))

(def styles
  (StyleSheet.create
   {:buttonContainer
    {:width 320
     :height 68
     :marginHorizontal 20
     :alignItem "center"
     :justifyContent "center"
     :padding 3}

    :button
    {:borderRadius 10
     :width "100%"
     :height "100%"
     :alignItems "center"
     :justifyContent "center"
     :flex-direction "row"}

    :buttonIcon
    {:paddingRight 8}

    :buttonLabel
    {:fontSize 16
     :color "#fff"}}))
