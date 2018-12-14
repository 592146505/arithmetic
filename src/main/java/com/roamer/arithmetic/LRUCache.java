package com.roamer.arithmetic;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法
 *
 * @author roamer
 * @version V1.0
 * @date 2018/12/6
 */
public class LRUCache<K, V> {

    /**
     * 头节点
     */
    private Node<K, V> head;

    /**
     * 尾节点
     */
    private Node<K, V> end;

    private Map<K, Node<K, V>> hashMap;

    /**
     * 上限
     */
    private int limit;

    public LRUCache(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit cannot less than zero");
        }
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    /**
     * 根据key查询对应value
     *
     * @param key
     * @return
     */
    public V get(@NotNull K key) {
        Node<K, V> node = hashMap.get(key);
        if (null == node) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    /**
     * 放入键值对
     *
     * @param key
     * @param value
     */
    public void put(@NotNull K key, V value) {
        Node<K, V> node = hashMap.get(key);
        // 不存在则放入
        if (null == node) {
            if (hashMap.size() >= limit) {
                // 删除头节点
                Node<K, V> oldNode = removeNode(head);
                hashMap.remove(oldNode.key);
            }
            node = new Node<>(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            refreshNode(node);
        }

    }

    /**
     * 删除key对应的value
     *
     * @param key 要删除的K
     * @return
     */
    public K remove(@NotNull K key) {
        if (!hashMap.containsKey(key)) {
            return null;
        }
        Node<K, V> node = hashMap.get(key);
        // 删除节点
        removeNode(node);
        return hashMap.remove(key).key;
    }


    /**
     * 尾部插入节点
     *
     * @param node 插入的节点
     */
    private void addNode(Node<K, V> node) {
        if (null != end) {
            end.next = node;
            node.prev = end;
            node.next = null;
        }
        end = node;
        if (null == head) {
            head = node;
        }
    }

    /**
     * 刷新被访问的节点位置
     *
     * @param node 被访问的节点
     */
    private void refreshNode(Node<K, V> node) {
        // 如是尾节点则无需移动
        if (end == node) {
            return;
        }
        // 删除节点
        removeNode(node);

        // 新增节点
        addNode(node);
    }


    /**
     * 删除节点
     *
     * @param node 删除的节点
     * @return 删除节点的KEY
     */
    private Node<K, V> removeNode(Node<K, V> node) {
        if (end == node) {
            end = end.prev;
        } else if (head == node) {
            head = head.next;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return node;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void print() {
        if (head == null) {
            return;
        }
        Node<K, V> node = head;
        do {
            System.out.println("Node: {key: " + node.key + ", value: " + node.value + "}");
            node = node.next;
        } while (null != node);

    }
}
