package com.leetcode.easy.longest_palindrome;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    //Given a string s which consists of lowercase or uppercase letters, return the
    //length of the longest palindrome that can be built with those letters.
    //
    // Letters are case sensitive, for example, "Aa" is not considered a palindrome
    //here.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "abccccdd"
    //Output: 7
    //Explanation: One longest palindrome that can be built is "dccaccd", whose
    //length is 7.
    //
    //
    // Example 2:
    //
    //
    //Input: s = "a"
    //Output: 1
    //Explanation: The longest palindrome that can be built is "a", whose length is
    //1.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 2000
    // s consists of lowercase and/or uppercase English letters only.
    //
    //
    // Related Topics Hash Table String Greedy 👍 3325 👎 187


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int longestPalindrome(String s) {
                //  Approach #1 (Without HashSet)
        //  result: lenght of the longest palindrome
        int result = 0;
        int[] characterCount = new int[128];

        for (char c : s.toCharArray()) {
            characterCount[c]++;
        }

        for (int countNumber : characterCount) {
            //  Add total occurrences of paired character
            //  Multiplied by 2 since both occurrences of the character
            //      contribute to the length
            result += countNumber / 2 * 2;
        }

        //  Find and add (if present) the central
        //      unpaired charcter
        if (result < s.length()) {
            result++;
        }

        return result;

        //  Approach #1 (With HashSet)
//        if (s == null || s.length() < 1) {
//            return 0;
//        }
//
//        Set<Character> characterSet = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            char c = s.charAt(i);
//
//            if (characterSet.contains(c)) {
//                characterSet.remove(c);
//            } else {
//                characterSet.add(c);
//            }
//        }
//
//        if (characterSet.size() <= 1) {
//            return s.length();
//        }
//
//        //  Remove unpaired characters from s
//        //  Add 1 to include the central unpaired character
//        //  The if statement immediately above takes care of
//        //     the case with only one unpaired character
//        return s.length() - characterSet.size() + 1;
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "abccccdd";
        //Output: 7

        // Example 2:
        String s2 = "a";
        //Output: 1

        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
