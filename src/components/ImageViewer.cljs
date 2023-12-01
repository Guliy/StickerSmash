(ns components.ImageViewer
  (:require ["react-native" :refer [StyleSheet, Image]]))

(def styles (StyleSheet.create
             {:image {:width 320
                      :height 440
                      :borderRadius 18}}))

(defn ImageViewer
  [{:keys [placeholderImageSource]}]
  #jsx [Image {:source placeholderImageSource
               :style styles.image}])

(def default ImageViewer)
