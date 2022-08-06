package com.leetcode.medium.longest_common_subsequence;

public class Solution {
//Given two strings text1 and text2, return the length of their longest common
//subsequence. If there is no common subsequence, return 0.
//
// A subsequence of a string is a new string generated from the original string
//with some characters (can be none) deleted without changing the relative order
//of the remaining characters.
//
//
// For example, "ace" is a subsequence of "abcde".
//
//
// A common subsequence of two strings is a subsequence that is common to both
//strings.
//
//
// Example 1:
//
//
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//
//
// Example 2:
//
//
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//
//
// Example 3:
//
//
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
//
//
//
// Constraints:
//
//
// 1 <= text1.length, text2.length <= 1000
// text1 and text2 consist of only lowercase English characters.
//
//
// Related Topics String Dynamic Programming 👍 7621 👎 85


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int longestCommonSubsequence(String text1, String text2) {

        //   Make a grid of 0's with text2.length() + 1 columns
        //      and text1.length() + 1 rows
        int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];

        //  Iterate up each column, starting from the last one
        for (int col = text2.length() - 1; col >=0; col--) {
            for (int row = text1.length() - 1; row >=0; row--) {
                //  If the corresponding characters for this cell are the same
                if (text1.charAt(row) == text2.charAt(col)) {
                    dpGrid[row][col] = 1 + dpGrid[row + 1][col + 1];
                    //  Otherwise they must be different
                } else {
                    dpGrid[row][col] = Math.max(dpGrid[row + 1][col],
                            dpGrid[row][col + 1]);
                }
            }
        }
        //  The original problem's answer is in dpGrid[0][0]. Return it.
        return dpGrid[0][0];
    }

    public static void main(String[] args) {
        // Example 1:
        String textA1 = "abcde";
        String textA2 = "ace";
        //  O/P: 3

        // Example 2:
        String textB1 = "abc";
        String textB2 = "abc";
        //  O/P: 3

        // Example 3:
        String textC1 = "abc";
        String textC2 = "def";
        //  O/P: 0

        System.out.println(longestCommonSubsequence(textA1, textA2));
        System.out.println(longestCommonSubsequence(textB1, textB2));
        System.out.println(longestCommonSubsequence(textC1, textC2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

