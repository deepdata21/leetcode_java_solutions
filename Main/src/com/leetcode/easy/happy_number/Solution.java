package com.leetcode.easy.happy_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //Write an algorithm to determine if a number n is happy.
    //
    // A happy number is a number defined by the following process:
    //
    //
    // Starting with any positive integer, replace the number by the sum of the
    //squares of its digits.
    // Repeat the process until the number equals 1 (where it will stay), or it
    //loops endlessly in a cycle which does not include 1.
    // Those numbers for which this process ends in 1 are happy.
    //
    //
    // Return true if n is a happy number, and false if not.
    //
    //
    // Example 1:
    //
    //
    //Input: n = 19
    //Output: true
    //Explanation:
    //1² + 9² = 82
    //8² + 2² = 68
    //6² + 8² = 100
    //1² + 0² + 0² = 1
    //
    //
    // Example 2:
    //
    //
    //Input: n = 2
    //Output: false
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= n <= 2³¹ - 1
    //
    //
    // Related Topics Hash Table Math Two Pointers 👍 6134 👎 776

    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {

    static boolean isHappy(int n) {

        Set<Integer> inLoop = new HashSet<>();

        int totalsum;
        int remainder;

        while (inLoop.add(n)) {

            totalsum = 0;

            while (n > 0) {
                remainder = n % 10;
                totalsum += remainder * remainder;
                n = n / 10;
            }

            if (totalsum == 1) {
                return true;
            } else {
                n = totalsum;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Example 1:
        int n1 = 19;
        //  O/P: true

        // Example 2:
        int n2 = 2;
        //  O/P: false

        System.out.println(isHappy(n1));
        System.out.println(isHappy(n2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

