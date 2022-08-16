package com.leetcode.medium.longest_substring_without_repeating;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    //Given a string s, find the length of the longest substring without repeating
    //characters.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.
    //
    //
    // Example 2:
    //
    //
    //Input: s = "bbbbb"
    //Output: 1
    //Explanation: The answer is "b", with the length of 1.
    //
    //
    // Example 3:
    //
    //
    //Input: s = "pwwkew"
    //Output: 3
    //Explanation: The answer is "wke", with the length of 3.
    //Notice that the answer must be a substring, "pwke" is a subsequence and not a
    //substring.
    //
    //
    //
    // Constraints:
    //
    //
    // 0 <= s.length <= 5 * 10⁴
    // s consists of English letters, digits, symbols and spaces.
    //
    //
    // Related Topics Hash Table String Sliding Window 👍 27544 👎 1183


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int lengthOfLongestSubstring(String s) {
            //  Start of the sliding window
        int windowStart = 0;

        //  Length of the window
        int windowSize = 0;

        //  HashMap to store characer frequencies
        Map<Character, Integer> characterFrequency = new HashMap<>();

        //  i = windowEnd
        for (int i = 0; i < s.length() ; i++) {

            char rightCharacter = s.charAt(i);
            if (characterFrequency.containsKey(rightCharacter)) {
                windowStart = Math.max(windowStart,
                        characterFrequency.get(rightCharacter) + 1);
            }

            characterFrequency.put(rightCharacter, i);

            //  Updates the maximum length/size of the substring
            windowSize = Math.max(windowSize, i - windowStart + 1);
        }

        return windowSize;
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "abcabcbb";
        //  O/P: 3

        // Example 2:
        String s2 = "bbbbb";
        //  O/P: 1

        // Example 3:
        String s3 = "pwwkew";
        //  O/P: 3

        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
