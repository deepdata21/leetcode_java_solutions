package com.leetcode.medium.string_to_integer_atoi;

public class Solution {
    //Implement the myAtoi(string s) function, which converts a string to a 32-bit
    //signed integer (similar to C/C++'s atoi function).
    //
    // The algorithm for myAtoi(string s) is as follows:
    //
    //
    // Read in and ignore any leading whitespace.
    // Check if the next character (if not already at the end of the string) is '-'
    //or '+'. Read this character in if it is either. This determines if the final
    //result is negative or positive respectively. Assume the result is positive if
    //neither is present.
    // Read in next the characters until the next non-digit character or the end of
    //the input is reached. The rest of the string is ignored.
    // Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If
    //no digits were read, then the integer is 0. Change the sign as necessary (from
    //step 2).
    // If the integer is out of the 32-bit signed integer range [-2³¹, 2³¹ - 1],
    //then clamp the integer so that it remains in the range. Specifically, integers
    //less than -2³¹ should be clamped to -2³¹, and integers greater than 2³¹ - 1 should
    //be clamped to 2³¹ - 1.
    // Return the integer as the final result.
    //
    //
    // Note:
    //
    //
    // Only the space character ' ' is considered a whitespace character.
    // Do not ignore any characters other than the leading whitespace or the rest
    //of the string after the digits.
    //
    //
    //
    // Example 1:
    //
    //
    //Input: s = "42"
    //Output: 42
    //Explanation: The underlined characters are what is read in, the caret is the
    //current reader position.
    //Step 1: "42" (no characters read because there is no leading whitespace)
    //         ^
    //Step 2: "42" (no characters read because there is neither a '-' nor '+')
    //         ^
    //Step 3: "42" ("42" is read in)
    //           ^
    //The parsed integer is 42.
    //Since 42 is in the range [-2³¹, 2³¹ - 1], the final result is 42.
    //
    //
    // Example 2:
    //
    //
    //Input: s = "   -42"
    //Output: -42
    //Explanation:
    //Step 1: "   -42" (leading whitespace is read and ignored)
    //            ^
    //Step 2: "   -42" ('-' is read, so the result should be negative)
    //             ^
    //Step 3: "   -42" ("42" is read in)
    //               ^
    //The parsed integer is -42.
    //Since -42 is in the range [-2³¹, 2³¹ - 1], the final result is -42.
    //
    //
    // Example 3:
    //
    //
    //Input: s = "4193 with words"
    //Output: 4193
    //Explanation:
    //Step 1: "4193 with words" (no characters read because there is no leading
    //whitespace)
    //         ^
    //Step 2: "4193 with words" (no characters read because there is neither a '-'
    //nor '+')
    //         ^
    //Step 3: "4193 with words" ("4193" is read in; reading stops because the next
    //character is a non-digit)
    //             ^
    //The parsed integer is 4193.
    //Since 4193 is in the range [-2³¹, 2³¹ - 1], the final result is 4193.
    //
    //
    //
    // Constraints:
    //
    //
    // 0 <= s.length <= 200
    // s consists of English letters (lower-case and upper-case), digits (0-9), ' ',
    // '+', '-', and '.'.
    //
    //
    // Related Topics String 👍 2120 👎 6210


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    static int myAtoi(String s) {
    public static int myAtoi(String s) {
        //  Initialize the index
        int index = 0;
        //  Sign of the output/result
        int sign = 1;
        //  The output
        int result = 0;

        //  Skip all leading whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        //  Now, check if positive or negative
        //  First check if positive
        if (index < s.length() && s.charAt(index) == '+') {
            //  Keep sign positive
            sign = 1;
            //  Move on to next character
            index++;
        //  Then check if negative
        } else if (index < s.length() && s.charAt(index) == '-') {
            //  Make the sign negative
            sign = -1;
            //  Move on to next character
            index++;
        }

        //  Move forward only next characters are digits
        //      End the loop if not digits
        while (index < s.length() &&
                Character.isDigit(s.charAt(index))) {

            //  ASCII character '0' has a value of 48
            //      and '1' is 49 and so on...
            int sDigit = s.charAt(index) - '0';

            //  Check overflow and underflow
            //  Check if result is out of 32-bit range
            if ((result > Integer.MAX_VALUE / 10) ||
                    //  Check if result is in 32-bit range
                    (result == Integer.MAX_VALUE / 10 &&
                            sDigit > Integer.MAX_VALUE % 10)) {
                // return maximum or minimum 32-bit integer value
                //     depending on if sign == 1 is true or false
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Build the result using the current digit
            result = 10 * result + sDigit;
            // Increase index by 1 and move on to next loop
            index++;
        }
        return sign * result;
    }

    public static void main(String[] args) {

        // Example 1:
        String s1 = "42";
        //Output: 42

        // Example 2:
        String s2 = "   -42";
        //Output: -42

        // Example 3:
        String s3 = "4193 with words";
        //Output: 4193

        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
