package com.leetcode.easy.remove_all_adjacent_duplicates_in_string;

public class Solution {
    //You are given a string s consisting of lowercase English letters. A duplicate
    //removal consists of choosing two adjacent and equal letters and removing them.
    //
    // We repeatedly make duplicate removals on s until we no longer can.
    //
    // Return the final string after all such duplicate removals have been made. It
    //can be proven that the answer is unique.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "abbaca"
    //Output: "ca"
    //Explanation:
    //For example, in "abbaca" we could remove "bb" since the letters are adjacent
    //and equal, and this is the only possible move.  The result of this move is that
    //the string is "aaca", of which only "aa" is possible, so the final string is
    //"ca".
    //
    //
    // Example 2:
    //
    //
    //Input: s = "azxxzy"
    //Output: "ay"
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 10⁵
    // s consists of lowercase English letters.
    //
    //
    // Related Topics String Stack 👍 3742 👎 168

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static String removeDuplicates(String s) {
        StringBuilder sBuilder = new StringBuilder();
        int sBuilderLength = 0;

        for (char c : s.toCharArray()) {
            if (sBuilderLength != 0 &&
                c == sBuilder.charAt(sBuilderLength - 1)) {
                //  First, delete char at index: sBuilderLength - 1
                //  Then, decrease the value of sBuilderLength by 1
                sBuilder.deleteCharAt(sBuilderLength-- - 1);
            } else {
                sBuilder.append(c);
                sBuilderLength++;
            }
        }

    return sBuilder.toString();
    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "abbaca";
        //Output: "ca"

        // Example 2:
        String s2 = "azxxzy";
        //Output: "ay"

        System.out.println(removeDuplicates(s1));
        System.out.println(removeDuplicates(s2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

