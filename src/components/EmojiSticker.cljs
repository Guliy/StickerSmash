(ns components.EmojiSticker
  (:require ["react-native-gesture-handler" :refer [Gesture, GestureDetector]]
            ["react-native-reanimated" :refer [useAnimatedStyle useSharedValue withSpring]]
            ["react-native-reanimated$default" :as  Animated]))

(defn EmojiSticker [{:keys [imageSize stickerSource]}]
  (let [scale-image (useSharedValue imageSize)
        translate-x  (useSharedValue 0)
        translate-y  (useSharedValue 0)
        double-tap (doto (Gesture.Tap)
                     (.numberOfTaps 2)
                     (.onStart #(if-not (= scale-image.value (* 2 imageSize))
                                  (set! scale-image.value (* 2 imageSize))
                                  (set! scale-image.value (/ scale-image.value 2)))))

        drag (doto (Gesture.Pan)
               (.onChange (fn [event]
                            (set! translate-x.value (+ translate-x.value event.changeX))
                            (set! translate-y.value (+ translate-y.value event.changeY)))))
        image-style (useAnimatedStyle #(-> {:width (withSpring scale-image.value)
                                            :height (withSpring scale-image.value)}))
        container-style (useAnimatedStyle #(-> {:transform
                                                [{:translate-x translate-x.value}
                                                 {:translate-y translate-y.value}]}))]

    #jsx [GestureDetector {:gesture drag}
          [Animated.View {:style [container-style {:top -350}]}
           [GestureDetector {:gesture double-tap}
            [Animated.Image {:source stickerSource
                             :resizeMode :contain
                             :style [image-style {:width imageSize :height imageSize}]}]]]]))
