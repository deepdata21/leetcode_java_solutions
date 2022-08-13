package com.leetcode.medium.remove_all_adjacent_duplicates_in_string_ii;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    //You are given a string s and an integer k, a k duplicate removal consists of
    //choosing k adjacent and equal letters from s and removing them, causing the left
    //and the right side of the deleted substring to concatenate together.
    //
    // We repeatedly make k duplicate removals on s until we no longer can.
    //
    // Return the final string after all such duplicate removals have been made. It
    //is guaranteed that the answer is unique.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "abcd", k = 2
    //Output: "abcd"
    //Explanation: There's nothing to delete.
    //
    // Example 2:
    //
    //
    //Input: s = "deeedbbcccbdaa", k = 3
    //Output: "aa"
    //Explanation:
    //First delete "eee" and "ccc", get "ddbbbdaa"
    //Then delete "bbb", get "dddaa"
    //Finally delete "ddd", get "aa"
    //
    // Example 3:
    //
    //
    //Input: s = "pbbcggttciiippooaais", k = 2
    //Output: "ps"
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 10⁵
    // 2 <= k <= 10⁴
    // s only contains lowercase English letters.
    //
    //
    // Related Topics String Stack 👍 4226 👎 81

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static String removeDuplicates(String s, int k) {
        //  Approach #1: Uisng iterative with Memoization
//        StringBuilder sBuilder = new StringBuilder(s);
//        int[] countElement = new int[sBuilder.length()];
//
//        for (int i = 0; i < sBuilder.length(); i++) {
//            if (i == 0 || sBuilder.charAt(i) != sBuilder.charAt(i-1)) {
//                countElement[i] = 1;
//            } else {
//                countElement[i] = countElement[i - 1] + 1;
//                if (countElement[i] == k) {
//                    //  Delete charactes in range (a,b)
//                    sBuilder.delete(i - k + 1, i + 1);
//                    i = i - k;
//                }
//            }
//        }
//        return sBuilder.toString();
        //  Approach #2: Using stack
        StringBuilder sBuilder = new StringBuilder(s);
        Deque<Integer> countElementStack = new ArrayDeque<>();

        for (int i = 0; i < sBuilder.length(); i++) {
            if (i == 0 || sBuilder.charAt(i) != sBuilder.charAt(i - 1)) {
                countElementStack.push(1);
            } else {
                int newCountElement = countElementStack.pop() + 1;
                if (newCountElement == k) {
                    //  Delete charactes in range (a,b)
                    sBuilder.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    countElementStack.push(newCountElement);
                }
            }
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "abcd";
        int k1 = 2;
        //  O/P: "abcd"

        // Example 2:
        String s2 = "deeedbbcccbdaa";
        int k2 = 3;
        //  O/P: "aa"

        // Example 3:
        String s3 = "pbbcggttciiippooaais";
        int k3 = 2;
        //  O/P: "ps"

        System.out.println(removeDuplicates(s1, k1));
        System.out.println(removeDuplicates(s2, k2));
        System.out.println(removeDuplicates(s3, k3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

