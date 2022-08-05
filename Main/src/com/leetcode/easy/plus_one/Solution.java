package com.leetcode.easy.plus_one;

import java.util.Arrays;

public class Solution {
    //You are given a large integer represented as an integer array digits, where
    //each digits[i] is the iᵗʰ digit of the integer. The digits are ordered from most
    //significant to least significant in left-to-right order. The large integer does
    //not contain any leading 0's.
    //
    // Increment the large integer by one and return the resulting array of digits.
    //
    //
    //
    // Example 1:
    //
    //
    //Input: digits = [1,2,3]
    //Output: [1,2,4]
    //Explanation: The array represents the integer 123.
    //Incrementing by one gives 123 + 1 = 124.
    //Thus, the result should be [1,2,4].
    //
    //
    // Example 2:
    //
    //
    //Input: digits = [4,3,2,1]
    //Output: [4,3,2,2]
    //Explanation: The array represents the integer 4321.
    //Incrementing by one gives 4321 + 1 = 4322.
    //Thus, the result should be [4,3,2,2].
    //
    //
    // Example 3:
    //
    //
    //Input: digits = [9]
    //Output: [1,0]
    //Explanation: The array represents the integer 9.
    //Incrementing by one gives 9 + 1 = 10.
    //Thus, the result should be [1,0].
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= digits.length <= 100
    // 0 <= digits[i] <= 9
    // digits does not contain any leading 0's.
    //
    //
    // Related Topics Array Math 👍 4746 👎 4311


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    public static void main(String[] args) {

        // Example 1:
        int[] digits1 = {1,2,3};
        //  O/P: [1,2,4]

        // Example 2:
        int[] digits2 = {4,3,2,1};
        //  O/P: [4,3,2,2]

        // Example 3:
        int[] digits3 = {9};
        //  O/P: [1,0]

        System.out.println(Arrays.toString(plusOne(digits1)));
        System.out.println(Arrays.toString(plusOne(digits2)));
        System.out.println(Arrays.toString(plusOne(digits3)));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
