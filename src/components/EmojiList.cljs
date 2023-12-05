(ns components.EmojiList
  (:require ["../../assets/images/emoji1.png$default" :as emoji1]
            ["../../assets/images/emoji2.png$default" :as emoji2]
            ["../../assets/images/emoji3.png$default" :as emoji3]
            ["../../assets/images/emoji4.png$default" :as emoji4]
            ["../../assets/images/emoji5.png$default" :as emoji5]
            ["../../assets/images/emoji6.png$default" :as emoji6]
            ["react" :refer [useState]]
            ["react-native" :refer [StyleSheet FlatList Image Platform Pressable]]))

(defn EmojiList [{:keys [onSelect onCloseModal]}]
  (let [[emoji _] (useState [emoji1 emoji2 emoji3 emoji4 emoji5 emoji6])]
    #jsx [FlatList {:horizontal true
                    :showsHorizontalScrollIndicator (= Platform.OS "web")
                    :data emoji
                    :contentContainerStyle styles.listContainer
                    :renderItem (fn [{:keys [item index]}]
                                  #jsx [Pressable {:onPress #(do (onSelect item) (onCloseModal))}
                                        [Image {:source item :key index :style styles.image}]])}]))

(def styles
  (StyleSheet.create
   {:listContainer
    {:borderTopRightRadius 10
     :borderTopLeftRadius 10
     :paddingHorizontal 20
     :flexDirection "row"
     :alignItems "center"
     :justifyContent "space-between"}

    :image
    {:width 100
     :height 100
     :marginRight 20}}))
