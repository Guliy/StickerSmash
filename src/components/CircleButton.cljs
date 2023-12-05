(ns components.CircleButton
  (:require ["@expo/vector-icons/MaterialIcons$default" :as MaterialIcons]
            ["react-native" :refer [View Pressable StyleSheet]]))

(defn CircleButton [{:keys [onPress]}]
  #jsx [View {:style styles.circleButtonContainer}
        [Pressable {:style styles.circleButton :onPress onPress}
         [MaterialIcons {:name "add" :size 38 :color "#25292e"}]]])

(def styles
  (StyleSheet.create
   {:circleButtonContainer
    {:width 84
     :height 84
     :marginHorizontal 60
     :borderWidth 4
     :borderColor "#ffd33d"
     :borderRadius 42
     :padding 3}

    :circleButton
    {:flex 1
     :justifyContent :center
     :alignItems :center
     :borderRadius 42
     :backgroundColor "#fff"}}))
