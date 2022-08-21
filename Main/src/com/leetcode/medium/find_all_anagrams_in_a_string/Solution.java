package com.leetcode.medium.find_all_anagrams_in_a_string;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    //Given two strings s and p, return an array of all the start indices of p's
    //anagrams in s. You may return the answer in any order.
    //
    // An Anagram is a word or phrase formed by rearranging the letters of a
    //different word or phrase, typically using all the original letters exactly once.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "cbaebabacd", p = "abc"
    //Output: [0,6]
    //Explanation:
    //The substring with start index = 0 is "cba", which is an anagram of "abc".
    //The substring with start index = 6 is "bac", which is an anagram of "abc".
    //
    //
    // Example 2:
    //
    //
    //Input: s = "abab", p = "ab"
    //Output: [0,1,2]
    //Explanation:
    //The substring with start index = 0 is "ab", which is an anagram of "ab".
    //The substring with start index = 1 is "ba", which is an anagram of "ab".
    //The substring with start index = 2 is "ab", which is an anagram of "ab".
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length, p.length <= 3 * 10⁴
    // s and p consist of lowercase English letters.
    //
    //
    // Related Topics Hash Table String Sliding Window 👍 8417 👎 268


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int leftIndex = 0;
        int matchedCharacterCount = 0;
        List<Integer> matchedIndices = new ArrayList<>();

        Map<Character, Integer> pHMap = new HashMap<>();

        for (char pCharacter : p.toCharArray()) {
            pHMap.put(pCharacter,
                    pHMap.getOrDefault (pCharacter,0) + 1);
        }

        for (int rightIndex = 0; rightIndex < s.length() ; rightIndex++) {
            char rightCharacter = s.charAt(rightIndex);
            if (pHMap.containsKey(rightCharacter)) {
                pHMap.put(rightCharacter,
                    pHMap.get(rightCharacter) - 1);
                if (pHMap.get(rightCharacter) == 0) {
                    matchedCharacterCount++;
                }
            }

            //  If found an anagram
            if (matchedCharacterCount == pHMap.size()) {
                //  Add leftIndex as the starting index
                //      of the anagram
                matchedIndices.add(leftIndex);
            }

            if (rightIndex >= p.length() - 1) {
                //  leftIndex++ in the following lines means
                //      give character at leftIndex
                //      and THEN, increase leftIndex by 1;
                //      meaning, leftIndex = leftIndex + 1
                char leftCharacter = s.charAt(leftIndex++);

                if (pHMap.containsKey(leftCharacter)) {
                    //  Check if leftCharacter is already matched
                    if(pHMap.get(leftCharacter) == 0) {
                        //  Decrease matched index by 1 since leftCharacter
                        //      is being removed
                        matchedCharacterCount--;
                    }
                    //  Put leftCharacter back for future matching
                    pHMap.put(leftCharacter, pHMap.get(leftCharacter) + 1);
                }
            }
        }
        return matchedIndices;
    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "cbaebabacd";
        String p1 = "abc";
        //  O/P: [0,6]

        // Example 2:
        String s2 = "abab";
        String p2 = "ab";
        //  O/P: [0,1,2]

        System.out.println(findAnagrams(s1, p1));
        System.out.println(findAnagrams(s2, p2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
