package com.leetcode.easy.valid_parentheses;
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
//Input: s = "()"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: s = "(]"
//Output: false
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁴
// s consists of parentheses only '()[]{}'.
//
// Related Topics String Stack 👍 13752 👎 629

import java.util.HashMap;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

     static boolean isValid(String s) {

         HashMap<Character, Character> mappings = new HashMap<>();
             mappings.put(')', '(');
             mappings.put(']', '[');
             mappings.put('}', '{');

        Stack<Character> myStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char topElement = myStack.isEmpty() ? '#' : myStack.pop();

                if (topElement != mappings.get(c)) {
                    return false;
                }

            } else {
                myStack.push(c);
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {

        //Output: true
        String s1 = "()";

        //Output: true
        String s2 = "()[]{}";

        //Output: false
        String s3 = "(]";

        isValid(s1);
        System.out.println(isValid(s1));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

