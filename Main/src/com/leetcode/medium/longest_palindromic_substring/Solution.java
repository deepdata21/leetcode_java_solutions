package com.leetcode.medium.longest_palindromic_substring;

public class Solution {
    //Given a string s, return the longest palindromic substring in s.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "babad"
    //Output: "bab"
    //Explanation: "aba" is also a valid answer.
    //
    //
    // Example 2:
    //
    //
    //Input: s = "cbbd"
    //Output: "bb"
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 1000
    // s consist of only digits and English letters.
    //
    //
    // Related Topics String Dynamic Programming 👍 20743 👎 1190


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    private static int centralExpansion(int left, int right, String s) {
        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //  "- 1" because index starts from "0"
        return right - left - 1;
    }

    static String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int leftBoundary = 0;
        int rightBoundary = 0;

        for (int i = 0; i < s.length(); i++) {
            //  For strings with odd length (example: "abcba")
            int oddLength = centralExpansion(i, i, s);

            //  For strings with even length (example: "abba")
            int evenLength = centralExpansion(i, i + 1, s);

            int maxLength = Math.max(oddLength, evenLength);

            //  To deal with index out of bound cases
            if (maxLength > rightBoundary - leftBoundary) {
                //  Because, indices range between 0 and length - 1
                //  Example: string.length() = 5
                //      0, 1, 2, 3, 4
                //      (5 - 1) / 2 = 2
                //      5 / 2 = 2
                //  Example: string.length() = 6
                //      0, 1, 2, 3, 4, 5
                //      (6 - 1) / 2 = 2
                //      6 / 2 = 3
                leftBoundary = i - (maxLength - 1) / 2;
                rightBoundary = i + maxLength / 2;
            }
        }

        //  return longest substring that begins with leftBoundary
        //      and ends in rightBoundary (inclusive)
        return s.substring(leftBoundary, rightBoundary + 1);
    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "babad";
        //  O/P: "bab"

        // Example 2:
        String s2 = "cbbd";
        //  O/P: "bb"

        // Example 3:
        String s3 = "eracecarluhgouwqzyufg";
        //  O/P: "racecar"

        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
        System.out.println(longestPalindrome(s3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
