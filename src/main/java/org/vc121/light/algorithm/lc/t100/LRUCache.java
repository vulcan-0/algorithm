package org.vc121.light.algorithm.lc.t100;

import java.util.*;

/**
 * 146. LRU 缓存
 * https://leetcode.cn/problems/lru-cache/
 *
 * @author Sam Lu
 * @date 2022/06/30
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    /**
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     * <p>
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     *
     * @param args
     */
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));

        // ["LRUCache","get","put","get","put","put","get","get"]
        // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        // [null,-1,null,-1,null,null,2,6]
        System.out.println("=======================");
        LRUCache lRUCache2 = new LRUCache(2);
        System.out.println(lRUCache2.get(2));
        lRUCache2.put(2, 6);
        System.out.println(lRUCache2.get(1));
        lRUCache2.put(1, 5);
        lRUCache2.put(1, 2);
        System.out.println(lRUCache2.get(1));
        System.out.println(lRUCache2.get(2));

        // ["LRUCache","put","put","put","put","get","get"]
        // [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        // [null,null,null,null,null,-1,3]
        System.out.println("=======================");
        LRUCache lRUCache3 = new LRUCache(2);
        lRUCache3.put(2, 1);
        lRUCache3.put(1, 1);
        lRUCache3.put(2, 3);
        lRUCache3.put(4, 1);
        System.out.println(lRUCache3.get(1));
        System.out.println(lRUCache3.get(2));
    }

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }

}
