(ns collision.utils.vector)

(defn merge
  "merge two vectors"
  [vec1 vec2]
  (vec (concat vec1 vec2)))

(defn remove
  "remove elem in vector"
  [vec pos]
  (merge (subvec vec 0 pos) (subvec vec (inc pos))))

(defn append
  "append element at the end of vector"
  [elem vec]
  (merge vec [elem]))