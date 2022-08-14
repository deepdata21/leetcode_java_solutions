package com.leetcode.medium.group_anagrams;

import java.util.*;

public class Solution {
    //Given an array of strings strs, group the anagrams together. You can return
    //the answer in any order.
    //
    // An Anagram is a word or phrase formed by rearranging the letters of a
    //different word or phrase, typically using all the original letters exactly once.
    //
    //
    // Example 1:
    // Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    //
    // Example 2:
    // Input: strs = [""]
    //Output: [[""]]
    //
    // Example 3:
    // Input: strs = ["a"]
    //Output: [["a"]]
    //
    //
    // Constraints:
    //
    //
    // 1 <= strs.length <= 10⁴
    // 0 <= strs[i].length <= 100
    // strs[i] consists of lowercase English letters.
    //
    //
    // Related Topics Array Hash Table String Sorting 👍 11018 👎 350


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static List<List<String>> groupAnagrams(String[] strs) {

        //  Return empty list if given string array is empty
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        //  Create HashMap to generate the required output
        Map<String, List> hMap = new HashMap<>();

        //  Create integer array of 26
        //      to count the occurrence of each letter
        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sBuilder = new StringBuilder("");

            for (int i = 0; i < 26; i++) {
                sBuilder.append('#');
                sBuilder.append(count[i]);
            }

            String hMapKey = sBuilder.toString();
            if (!hMap.containsKey(hMapKey)){
                hMap.put(hMapKey, new ArrayList<>());
            }
            hMap.get(hMapKey).add(s);
        }

        System.out.println(hMap.keySet());
        System.out.println(hMap.values());
        return new ArrayList(hMap.values());
    }

    public static void main(String[] args) {
        // Example 1:
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        //  O/P: [["bat"],["nat","tan"],["ate","eat","tea"]]

        // Example 2:
        String[] strs2 = {""};
        //  O/P: [[""]]

        // Example 3:
        String[] strs3 = {"a"};
        //  O/P: [["a"]]

        // Example 4:
        String[] strs4 = {};
        //  O/P: [["a"]]

        System.out.println(groupAnagrams(strs1));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));
        System.out.println(groupAnagrams(strs4));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
