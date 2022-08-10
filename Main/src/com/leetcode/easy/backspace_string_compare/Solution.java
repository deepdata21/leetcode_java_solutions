package com.leetcode.easy.backspace_string_compare;

import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    //Given two strings s and t, return true if they are equal when both are typed
    //into empty text editors. '#' means a backspace character.
    //
    // Note that after backspacing an empty text, the text will continue empty.
    //
    //
    // Example 1:
    //
    //
    //Input: s = "ab#c", t = "ad#c"
    //Output: true
    //Explanation: Both s and t become "ac".
    //
    //
    // Example 2:
    //
    //
    //Input: s = "ab##", t = "c#d#"
    //Output: true
    //Explanation: Both s and t become "".
    //
    //
    // Example 3:
    //
    //
    //Input: s = "a#c", t = "b"
    //Output: false
    //Explanation: s becomes "c" while t becomes "b".
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= s.length, t.length <= 200
    // s and t only contain lowercase letters and '#' characters.
    //
    //
    //
    // Follow up: Can you solve it in O(n) time and O(1) space?
    //
    // Related Topics Two Pointers String Stack Simulation 👍 5307 👎 230

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    static String build(String S) {

        //  Create a stack using ArrayDeque
        //  Code to interface (use Deque interface)
        //      and ArrayDeque class
        Deque<Character> resultStack = new ArrayDeque<>();

        for (char c : S.toCharArray()) {
           if (c != '#')
               resultStack.push(c);
           else if (!resultStack.isEmpty())
               resultStack.pop();
        }

        return String.valueOf(resultStack);
    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "ab#c";
        String t1 = "ad#c";
        //  O/P: true

        // Example 2:
        String s2 = "ab##";
        String t2 = "c#d#";
        //  O/P: true

        // Example 3:
        String s3 = "a#c";
        String t3 = "b";
        //  O/P: false

        System.out.println(backspaceCompare(s1,t1));
        System.out.println(backspaceCompare(s2,t2));
        System.out.println(backspaceCompare(s3,t3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

