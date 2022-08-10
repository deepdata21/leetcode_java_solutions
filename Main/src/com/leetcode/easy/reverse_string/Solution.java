package com.leetcode.easy.reverse_string;

public class Solution {
    //Write a function that reverses a string. The input string is given as an
    //array of characters s.
    //
    // You must do this by modifying the input array in-place with O(1) extra
    //memory.
    //
    //
    // Example 1:
    // Input: s = ["h","e","l","l","o"]
    //Output: ["o","l","l","e","h"]
    //
    // Example 2:
    // Input: s = ["H","a","n","n","a","h"]
    //Output: ["h","a","n","n","a","H"]
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length <= 10⁵
    // s[i] is a printable ascii character.
    //
    //
    // Related Topics Two Pointers String Recursion 👍 5715 👎 982


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static void reverseString(char[] s) {
        int leftPointer = 0;
        int rightPointer = s.length - 1;

        //  Continue the while loop as long as
        //      left pointer remains smaller than the right pointer
        while (leftPointer < rightPointer) {
            //  Store character at current left pointer
            char temp = s[leftPointer];

            //  Set character at right pointer index as
            //      the character at current left pointer index
            //      and increase left pointer by 1
            s[leftPointer++] = s[rightPointer];

            //  Set temp at current right pointer index
            //      and decrease right pointer by 1
            s[rightPointer--] = temp;
        }

        System.out.println(s);
    }

    public static void main(String[] args) {
        // Example 1:
        String str1 = "hello";
        String[] str1Array = {"h","e","l","l","o"};
        char[] s1 = str1.toCharArray();
        char[] s1Array = {'h','e','l','l','o'};
        //  O/P: ["o","l","l","e","h"]

        // Example 2:
        String str2 = "Hannah";
        String[] str2Array = {"H","a","n","n","a","h"};
        char[] s2 = str2.toCharArray();
        //  O/P: ["h","a","n","n","a","H"]

        System.out.println(s1);
        reverseString(s1);
        System.out.println();

        System.out.println(s1Array);
        reverseString(s1Array);
        System.out.println();

        System.out.println(s2);
        reverseString(s2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
