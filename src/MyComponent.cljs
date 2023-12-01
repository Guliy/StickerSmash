(ns MyComponent
  (:require ["react" :refer [useState]]
            ["react-native" :refer [Text View Button]]))

(defn MyComponent []
  (let [[state setState] (useState 0)]
    #jsx [:View
          [:Text {:style {:color "#ccc"}} "You clicked " state " times"]
          [:Button {:onPress (fn [[_ _ _]]
                               (setState (inc state)))
                    :title "Click me"}]]))
(def default MyComponent)
