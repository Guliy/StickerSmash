(ns components.IconButton
  (:require ["@expo/vector-icons/MaterialIcons$default" :as MaterialIcons]
            ["react-native" :refer [Pressable StyleSheet Text]]))

(defn IconButton [{:keys [icon label onPress]}]
  #jsx [Pressable {:style styles.iconButton :onPress onPress}
        [MaterialIcons {:name icon :size 24 :color "#fff"}]
        [Text {:style styles.iconButtonLabel} label]])

(def styles
  (StyleSheet.create
   {:iconButton {:justifyContent :center
                 :alignItem :center}

    :iconButtonLabel {:color "#fff"
                      :marginTop 12}}))
