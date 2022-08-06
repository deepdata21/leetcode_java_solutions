package com.leetcode.easy.counting_bits;

import java.util.Arrays;

public class Solution {
    //Given an integer n, return an array ans of length n + 1 such that for each i (
    //0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
    //
    //
    // Example 1:
    //
    //
    //Input: n = 2
    //Output: [0,1,1]
    //Explanation:
    //0 --> 0
    //1 --> 1
    //2 --> 10
    //
    //
    // Example 2:
    //
    //
    //Input: n = 5
    //Output: [0,1,1,2,1,2]
    //Explanation:
    //0 --> 0
    //1 --> 1
    //2 --> 10
    //3 --> 11
    //4 --> 100
    //5 --> 101
    //
    //
    //
    // Constraints:
    //
    //
    // 0 <= n <= 10⁵
    //
    //
    //
    // Follow up:
    //
    //
    // It is very easy to come up with a solution with a runtime of O(n log n). Can
    //you do it in linear time O(n) and possibly in a single pass?
    // Can you do it without using any built-in function (i.e., like __builtin_
    //popcount in C++)?
    //
    //
    // Related Topics Dynamic Programming Bit Manipulation 👍 7397 👎 347


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int[] countBits(int n) {

        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; ++i) {

            //  i / 2 is i >> 1 (bit right shift operation)
            //  i % 2 is i & 1
            ans[i] = ans[i >> 1] + (i & 1);

        }

        return ans;
    }

    public static void main(String[] args) {

        // Example 1:
        int n1 = 2;
        //  O/P: [0,1,1]

        // Example 2:
        int n2 = 5;
        //  O/P: [0,1,1,2,1,2]

        // Example 3:
        int n3 = 55;

        System.out.println(Arrays.toString(countBits(n1)));
        System.out.println(Arrays.toString(countBits(n2)));
        System.out.println(Arrays.toString(countBits(n3)));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

