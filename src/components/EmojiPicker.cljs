(ns components.EmojiPicker
  (:require ["@expo/vector-icons/MaterialIcons$default" :as MaterialIcons]
            ["react-native" :refer [Modal View Text Pressable StyleSheet]]))

(defn EmojiPicker [{:keys [isVisible, onClose children]}]
  #jsx [Modal {:animationType "slide" :transparent true :visible isVisible}
        [View {:style styles.modalContent}
         [View {:style styles.titleContainer}
          [Text {:style styles.title}]
          [Pressable {:onPress onClose}
           [MaterialIcons {:name :close :color "#fff" :size 12}]]]
         children]])

(def styles
  (StyleSheet.create
   {:modalContent
    {:height "25%"
     :width "100%"
     :backgroundColor "#25292e"
     :borderTopRightRadius 18
     :borderTopLeftRadius 18
     :position "absolute"
     :bottom 0}

    :titleContainer
    {:height "16%"
     :backgroundColor "#464C55"
     :borderTopRightRadius 10
     :borderTopLeftRadius 10
     :paddingHorizontal 20
     :flexDirection "row"
     :alignItems "center"
     :justifyContent "space-between"}

    :title
    {:color "#fff"
     :fontSize 16}

    :pickerContainer
    {:flexDirection "row"
     :justifyContent "center"
     :alignItems "center"
     :paddingHorizontal 50
     :paddingVertical 20}}))
