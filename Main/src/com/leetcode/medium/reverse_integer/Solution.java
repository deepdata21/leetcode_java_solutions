package com.leetcode.medium.reverse_integer;

public class Solution {
    //Given a signed 32-bit integer x, return x with its digits reversed. If
    //reversing x causes the value to go outside the signed 32-bit integer range [-2³¹, 2³¹ -
    // 1], then return 0.
    //
    // Assume the environment does not allow you to store 64-bit integers (signed
    //or unsigned).
    //
    //
    // Example 1:
    //
    //
    //Input: x = 123
    //Output: 321
    //
    //
    // Example 2:
    //
    //
    //Input: x = -123
    //Output: -321
    //
    //
    // Example 3:
    //
    //
    //Input: x = 120
    //Output: 21
    //
    //
    //
    // Constraints:
    //
    //
    // -2³¹ <= x <= 2³¹ - 1
    //
    //
    // Related Topics Math 👍 7902 👎 10362


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static int reverse(int x) {

        //  Initialize the reversed integer to be built
        int reversedInt = 0;

        //  Check until given integer x is not 0,
        //      since x is divided by 10 in every step
        while (x != 0) {
            //  Find the remainder to pop the last digit
            int remainder = x % 10;
            //  Divide by 10 to get rid of the last digit
            x /= 10;

            //  Check overflow condition on the positive side
            if (reversedInt > Integer.MAX_VALUE / 10 ||
                    (reversedInt == Integer.MAX_VALUE / 10 &&
                            remainder > 7)) {
                return 0;
            }

            //  Check overflow condition on the negative side
            if (reversedInt < Integer.MIN_VALUE / 10 ||
                    (reversedInt == Integer.MIN_VALUE / 10 &&
                            remainder < -8)) {
                return 0;
            }

            //  Build the reversed integer
            reversedInt = reversedInt * 10 + remainder;
        }
        return reversedInt;
    }

    public static void main(String[] args) {
        // Example 1:
        int x1 = 123;
        //  O/P: 321

        // Example 2:
        int x2 = -123;
        //  O/P: -321

        // Example 3:
        int x3 = 120;
        //  O/P: 21

        System.out.println(reverse(x1));
        System.out.println(reverse(x2));
        System.out.println(reverse(x3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
