(ns App
  (:require ["react-native" :refer [Text View StyleSheet Image]]
            ["expo-status-bar" :refer [StatusBar]]
            ["../assets/images/background-image.png$default" :as PlaceholderImage]
            ["./components/ImageViewer" :refer [ImageViewer]]
            ["./components/Button" :refer [Button]]))

(def styles
  (StyleSheet.create
   {:container  {:flex 1
                 :backgroundColor "#25292e"
                 :alignItems "center"}
    :imageContainer {:flex 1
                     :paddingTop 58}
    :image {:width 320
            :height 440
            :borderRadius 18}
    :footerContainer
    {:flex 1/3
     :alignItems "center"}}))

(defn App []
  #jsx [:View {:style styles.container}
        [:View {:style styles.imageContainer}
         [ImageViewer {:placeholderImageSource PlaceholderImage}]]
        [:View {:style styles.footerContainer}
         [:Button {:label "Choose a proto!" :theme "primary"}]
         [:Button {:label "Use this photo"}]]

        [:StatusBar {:style "auto"}]])

(def default App)
