package com.leetcode.easy.valid_anagram;

public class Solution {
    //Given two strings s and t, return true if t is an anagram of s, and false
    //otherwise.
    //
    // An Anagram is a word or phrase formed by rearranging the letters of a
    //different word or phrase, typically using all the original letters exactly once.
    //
    //
    // Example 1:
    // Input: s = "anagram", t = "nagaram"
    //Output: true
    //
    // Example 2:
    // Input: s = "rat", t = "car"
    //Output: false
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length, t.length <= 5 * 10⁴
    // s and t consist of lowercase English letters.
    //
    //
    //
    // Follow up: What if the inputs contain Unicode characters? How would you
    //adapt your solution to such a case?
    //
    // Related Topics Hash Table String Sorting 👍 5728 👎 232

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        java.util.Map<Character, Integer> sMap = new java.util.HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0) + 1);
            sMap.put(t.charAt(i), sMap.getOrDefault(t.charAt(i),0) - 1);
        }

        for (char c : sMap.keySet()) {
            if (sMap.get(c) != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "anagram";
        String t1 = "nagaram";
        //  O/P: true

        // Example 2:
        String s2 = "rat";
        String t2 = "car";
        //  O/P: false

        System.out.println("Example 1: " + isAnagram(s1,t1));
        System.out.println("Example 2: " + isAnagram(s2,t2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

