package com.leetcode.easy.ransom_note;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    //Given two strings ransomNote and magazine, return true if ransomNote can be
    //constructed by using the letters from magazine and false otherwise.
    //
    // Each letter in magazine can only be used once in ransomNote.
    //
    //
    // Example 1:
    // Input: ransomNote = "a", magazine = "b"
    //Output: false
    //
    // Example 2:
    // Input: ransomNote = "aa", magazine = "ab"
    //Output: false
    //
    // Example 3:
    // Input: ransomNote = "aa", magazine = "aab"
    //Output: true
    //
    //
    // Constraints:
    //
    //
    // 1 <= ransomNote.length, magazine.length <= 10⁵
    // ransomNote and magazine consist of lowercase English letters.
    //
    //
    // Related Topics Hash Table String Counting 👍 2158 👎 339


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> characterMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            int characterCount = characterMap.getOrDefault(
                    magazine.charAt(i), 0);
            characterMap.put(magazine.charAt(i), characterCount + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {

            int characterCount = characterMap.getOrDefault(
                    ransomNote.charAt(i), 0);

            if (characterCount == 0) {
                return false;
            }

            characterMap.put(ransomNote.charAt(i), characterCount - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1:
        String ransomNote1 = "a";
        String magazine1 = "b";
        //  O/P: false

        // Example 2:
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        //  O/P: false

        // Example 3:
        String ransomNote3 = "aa";
        String magazine3 = "aab";
        //  O/P: true

        System.out.println(canConstruct(ransomNote1, magazine1));
        System.out.println(canConstruct(ransomNote2, magazine2));
        System.out.println(canConstruct(ransomNote3, magazine3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

