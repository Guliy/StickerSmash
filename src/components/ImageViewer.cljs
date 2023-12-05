(ns components.ImageViewer
  (:require ["react-native" :refer [StyleSheet, Image]]))

(defn ImageViewer
  [{:keys [placeholderImageSource selectedImage]}]
  (let [source (if selectedImage {:uri selectedImage} placeholderImageSource)]
    #jsx [Image {:source source
                 :style styles.image}]))

(def styles (StyleSheet.create
             {:image {:width 320
                      :height 440
                      :borderRadius 18}}))
