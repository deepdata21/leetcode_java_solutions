package com.leetcode.easy.valid_palindrome;

public class Solution {
    //A phrase is a palindrome if, after converting all uppercase letters into
    //lowercase letters and removing all non-alphanumeric characters, it reads the same
    //forward and backward. Alphanumeric characters include letters and numbers.
    //
    // Given a string s, return true if it is a palindrome, or false otherwise.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "A man, a plan, a canal: Panama"
    //Output: true
    //Explanation: "amanaplanacanalpanama" is a palindrome.
    //
    //
    // Example 2:
    //
    //
    //Input: s = "race a car"
    //Output: false
    //Explanation: "raceacar" is not a palindrome.
    //
    //
    // Example 3:
    //
    //
    //Input: s = " "
    //Output: true
    //Explanation: s is an empty string "" after removing non-alphanumeric
    //characters.
    //Since an empty string reads the same forward and backward, it is a palindrome.
    //
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 2 * 10⁵
    // s consists only of printable ASCII characters.
    //
    // Related Topics Two Pointers String 👍 4005 👎 5451


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {

            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) !=
                    Character.toLowerCase(s.charAt(j))) {
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "A man, a plan, a canal: Panama";
        //  O/P: true

        // Example 2:
        String s2 = "race a car";
        //  O/P: false

        // Example 3:
        String s3 = " ";
        //  O/P: true

        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

