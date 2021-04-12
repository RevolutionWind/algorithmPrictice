package lru;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * LRU算法设计
 * <p>
 * 为了实现LRU算法，要让put()和get()方法时间复杂度皆为O(1)。我们可以总结出这个数据结构的特点，
 * 查找快、插入快、删除快、有顺序之分（因为要区分最近和最久使用的数据）。
 * Hash表查找快，但是没有顺序。链表有顺序、增删快，但是查找慢。把两者结合，就可以实现LRU Cache模型
 *
 * @author sunxy
 * @date 2020/9/24
 */
@SuppressWarnings("unused")
public class LRUCache {
    static class Node {
        public int key, val;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    // LRU容量
    int capacity;
    // HashMap
    HashMap<Integer, Node> map;
    // 双向链表
    LinkedList<Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        cache = new LinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        cache.remove(node);
        cache.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else if (capacity == map.size()) {
            Node last = cache.removeLast();
            map.remove(last.key);
        }
        cache.addFirst(node);
        map.put(key, node);
    }

}



