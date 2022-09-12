package com.leetcode.medium.lru_cache;

import java.util.Map;
import java.util.HashMap;

//public class Solution {
    //Design a data structure that follows the constraints of a Least Recently Used
    //(LRU) cache.
    //
    // Implement the LRUCache class:
    //
    //
    // LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    //
    // int get(int key) Return the value of the key if the key exists, otherwise
    //return -1.
    // void put(int key, int value) Update the value of the key if the key exists.
    //Otherwise, add the key-value pair to the cache. If the number of keys exceeds
    //the capacity from this operation, evict the least recently used key.
    //
    //
    // The functions get and put must each run in O(1) average time complexity.
    //
    //
    // Example 1:
    //
    //
    //Input
    //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    //Output
    //[null, null, null, 1, null, -1, null, -1, 3, 4]
    //
    //Explanation
    //LRUCache lRUCache = new LRUCache(2);
    //lRUCache.put(1, 1); // cache is {1=1}
    //lRUCache.put(2, 2); // cache is {1=1, 2=2}
    //lRUCache.get(1);    // return 1
    //lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    //lRUCache.get(2);    // returns -1 (not found)
    //lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    //lRUCache.get(1);    // return -1 (not found)
    //lRUCache.get(3);    // return 3
    //lRUCache.get(4);    // return 4
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= capacity <= 3000
    // 0 <= key <= 10⁴
    // 0 <= value <= 10⁵
    // At most 2 * 10⁵ calls will be made to get and put.
    //
    //
    // Related Topics Hash Table Linked List Design Doubly-Linked List 👍 15077 👎 6
    //18

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    class DoublyLinkedNode {
        int key;
        int value;
        DoublyLinkedNode previousNode;
        DoublyLinkedNode nextNode;
    }

    private Map<Integer, DoublyLinkedNode> cacheMap = new HashMap<>();
    private int cacheSize;
    private int cacheCapacity;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    //  Add node at the front but after the dummy head node
    private void addNode(DoublyLinkedNode node) {
        node.previousNode = head;
        node.nextNode = head.nextNode;

        head.nextNode.previousNode = node;
        head.nextNode = node;
    }

    private void removeNode(DoublyLinkedNode node) {
        DoublyLinkedNode previousNode = node.previousNode;
        DoublyLinkedNode nextNode = node.nextNode;

        previousNode.nextNode = nextNode;
        nextNode.previousNode = previousNode;
    }

    //  Move an existing node at the front but after the dummy head node
    private void moveToFront(DoublyLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    //  Remove the last node, which is an existing node
    //      right before the dummy tail
    private DoublyLinkedNode popEndNode() {
        DoublyLinkedNode endNode = tail.previousNode;
        removeNode(endNode);
        return endNode;
    }

    public LRUCache(int capacity) {
        this.cacheSize = 0;
        this.cacheCapacity = capacity;

        head = new DoublyLinkedNode();
        tail = new DoublyLinkedNode();

        head.nextNode = tail;
        tail.previousNode = head;
    }

    public int get(int key) {
        DoublyLinkedNode node = cacheMap.get(key);

        if (node == null) {
            return -1;
        }

        moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        DoublyLinkedNode node = cacheMap.get(key);

        if (node == null) {
            DoublyLinkedNode updatedNode = new DoublyLinkedNode();
            updatedNode.key = key;
            updatedNode.value = value;

            cacheMap.put(key, updatedNode);
            addNode(updatedNode);

            //  Increase the size the LRUCache by 1
            ++cacheSize;

            if (cacheSize > cacheCapacity) {
                DoublyLinkedNode endNode = popEndNode();
                cacheMap.remove(endNode.key);

                //  Decrease the size the LRUCache by 1
                --cacheSize;
            }
        } else {
            node.value = value;
            moveToFront(node);
        }
    }
}

class Solution {

    public static void main(String[] args) {

        // Example 1:
        //Input
        //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));

        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

        //Output
        //[null, null, null, 1, null, -1, null, -1, 3, 4]
        //
        //Explanation
        //LRUCache lRUCache = new LRUCache(2);
        //lRUCache.put(1, 1); // cache is {1=1}
        //lRUCache.put(2, 2); // cache is {1=1, 2=2}
        //lRUCache.get(1);    // return 1
        //lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        //lRUCache.get(2);    // returns -1 (not found)
        //lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        //lRUCache.get(1);    // return -1 (not found)
        //lRUCache.get(3);    // return 3
        //lRUCache.get(4);    // return 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

