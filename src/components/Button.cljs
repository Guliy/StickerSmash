(ns components.Button
  (:require ["@expo/vector-icons/FontAwesome$default" :as FontAwesome]
            ["react-native" :refer [View Text Pressable StyleSheet]]))

(defn Button
  [{:keys [label theme onPress]}]
  (if (= "primary" theme)
    #jsx [View {:style [styles.buttonContainer
                        {:borderWidth 4 :borderColor "#ffd33d" :borderRadius 18}]}
          #jsx [Pressable {:style  (merge styles.button {:backgroundColor "#fff"})
                           :onPress onPress}
                [FontAwesome {:name "picture-o"
                              :size 18
                              :color "#25292e"
                              :style styles.buttonIcon}]
                [Text {:style (assoc styles.buttonLabel :color "#25292e")} label]]]

    #jsx  [View {:style styles.buttonContainer}
           [Pressable {:style styles.button
                       :onPress onPress}
            [Text {:style [styles.buttonLabel {:color "#fff"}]} label]]]))

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
     :flexDirection "row"}

    :buttonIcon
    {:paddingRight 8}

    :buttonLabel
    {:fontSize 16
     :color "#fff"}}))
