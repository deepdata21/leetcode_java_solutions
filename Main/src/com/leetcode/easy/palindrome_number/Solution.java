package com.leetcode.easy.palindrome_number;

public class Solution {
    //Given an integer x, return true if x is palindrome integer.
    //
    // An integer is a palindrome when it reads the same backward as forward.
    //
    //
    // For example, 121 is a palindrome while 123 is not.
    //
    //
    //
    // Example 1:
    //
    //
    //Input: x = 121
    //Output: true
    //Explanation: 121 reads as 121 from left to right and from right to left.
    //
    //
    // Example 2:
    //
    //
    //Input: x = -121
    //Output: false
    //Explanation: From left to right, it reads -121. From right to left, it
    //becomes 121-. Therefore it is not a palindrome.
    //
    //
    // Example 3:
    //
    //
    //Input: x = 10
    //Output: false
    //Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    //
    //
    //
    // Constraints:
    //
    //
    // -2³¹ <= x <= 2³¹ - 1
    //
    //
    //
    //Follow up: Could you solve it without converting the integer to a string?
    //
    // Related Topics Math 👍 6697 👎 2248


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int tempX = x;
        int reversedX = 0;

        while (tempX > 0) {
            int remainderTempX = tempX % 10;
            reversedX = reversedX * 10 + remainderTempX;
            tempX = tempX / 10;
        }

        if (reversedX == x) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        // Example 1:
        int x1 = 121;
        //  O/P: true

        // Example 2:
        int x2 = -121;
        //  O/P: false

        // Example 3:
        int x3 = 10;
        //  O/P: false

        System.out.println(isPalindrome(x1));
        System.out.println(isPalindrome(x2));
        System.out.println(isPalindrome(x3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
