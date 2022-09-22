package com.leetcode.medium.time_based_key_value_store;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
    //Design a time-based key-value data structure that can store multiple values
    //for the same key at different time stamps and retrieve the key's value at a
    //certain timestamp.
    //
    // Implement the TimeMap class:
    //
    //
    // TimeMap() Initializes the object of the data structure.
    // void set(String key, String value, int timestamp) Stores the key key with
    //the value value at the given time timestamp.
    // String get(String key, int timestamp) Returns a value such that set was
    //called previously, with timestamp_prev <= timestamp. If there are multiple such
    //values, it returns the value associated with the largest timestamp_prev. If there
    //are no values, it returns "".
    //
    //
    //
    // Example 1:
    //
    //
    //Input
    //["TimeMap", "set", "get", "get", "set", "get", "get"]
    //[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4]
    //, ["foo", 5]]
    //Output
    //[null, null, "bar", "bar", null, "bar2", "bar2"]
    //
    //Explanation
    //TimeMap timeMap = new TimeMap();
    //timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along
    //with timestamp = 1.
    //timeMap.get("foo", 1);         // return "bar"
    //timeMap.get("foo", 3);         // return "bar", since there is no value
    //corresponding to foo at timestamp 3 and timestamp 2, then the only value is at
    //timestamp 1 is "bar".
    //timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along
    //with timestamp = 4.
    //timeMap.get("foo", 4);         // return "bar2"
    //timeMap.get("foo", 5);         // return "bar2"
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= key.length, value.length <= 100
    // key and value consist of lowercase English letters and digits.
    // 1 <= timestamp <= 10⁷
    // All the timestamps timestamp of set are strictly increasing.
    // At most 2 * 10⁵ calls will be made to set and get.
    //
    //
    // Related Topics Hash Table String Binary Search Design 👍 2541 👎 262

//leetcode submit region begin(Prohibit modification and deletion)
//class TimeMap {

    //  Declare timeMap for global use
    private Map<String, TreeMap> timeMap;

    public TimeMap() {
        //  Initialize timeMap
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        //  If given key is not already in timeMap,
        //      put key and a new tree map
        if(!timeMap.containsKey(key)) {
           timeMap.put(key, new TreeMap<>());
        }

        //  First get the value for the given key:
        //      a TreeMap
        //  Put timestamp as key and value as value in the TreeMap
        timeMap.get(key).put(timestamp, value);

    }

    public String get(String key, int timestamp) {
        //  Get the value (as TreeMap) for a given key
        //      from the TimeMap, and
        //      store it newly declared treeMap
        TreeMap<Integer, String> treeMap = timeMap.get(key);

        //  If treeMap is null, return an empty string
        if (treeMap == null) {
            return "";
        }

        //  Returns the greatest key less than or equal to
        //      the given key, or null if there is no such key.
        //  Declare an integer to store the greatest key (timestamp here)
        //      less than or equal to the given key
        Integer floorTimestamp = treeMap.floorKey(timestamp);

        //  If floorTimestamp is null, return an empty string
        if (floorTimestamp == null) {
            return "";
        }

        //  Return the value from treeMap corresponding
        //      to the greatest key (timestamp here)
        //      less than or equal to the given key
        return treeMap.get(floorTimestamp);
    }

    public static void main(String[] args) {

        // Example 1:
        //Input
        //["TimeMap", "set", "get", "get", "set", "get", "get"]
        //[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4]
        //, ["foo", 5]]

        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
//        timeMap.get("foo", 1);
        System.out.println(timeMap.get("foo", 1));
//        timeMap.get("foo", 3);
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
//        timeMap.get("foo", 4);
        System.out.println(timeMap.get("foo", 4));
//        timeMap.get("foo", 5);
        System.out.println(timeMap.get("foo", 5));

        //  O/P:
        //[null, null, "bar", "bar", null, "bar2", "bar2"]

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

