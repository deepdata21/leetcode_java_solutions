package com.leetcode.easy.longest_common_prefix;

public class Solution {
    //Write a function to find the longest common prefix string amongst an array of
    //strings.
    //
    // If there is no common prefix, return an empty string "".
    //
    //
    // Example 1:
    //
    //
    //Input: strs = ["flower","flow","flight"]
    //Output: "fl"
    //
    //
    // Example 2:
    //
    //
    //Input: strs = ["dog","racecar","car"]
    //Output: ""
    //Explanation: There is no common prefix among the input strings.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= strs.length <= 200
    // 0 <= strs[i].length <= 200
    // strs[i] consists of only lowercase English letters.
    //
    //
    // Related Topics String 👍 9542 👎 3269

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() ||
                        strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        // Example 1:
        String[] strs1 = {"flower","flow","flight"};
        //  O/P: "fl"

        // Example 2:
        String[] strs2 = {"dog","racecar","car"};
        //  O/P: ""

        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
