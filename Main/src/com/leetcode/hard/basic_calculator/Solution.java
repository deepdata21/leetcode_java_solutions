package com.leetcode.hard.basic_calculator;

import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
//Given a string s representing a valid expression, implement a basic
//calculator to evaluate it, and return the result of the evaluation.
//
// Note: You are not allowed to use any built-in function which evaluates
//strings as mathematical expressions, such as eval().
//
//
// Example 1:
//
//
//Input: s = "1 + 1"
//Output: 2
//
//
// Example 2:
//
//
//Input: s = " 2-1 + 2 "
//Output: 3
//
//
// Example 3:
//
//
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 3 * 10⁵
// s consists of digits, '+', '-', '(', ')', and ' '.
// s represents a valid expression.
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
//
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
//
// There will be no two consecutive operators in the input.
// Every number and running calculation will fit in a signed 32-bit integer.
//
//
// Related Topics Math String Stack Recursion 👍 4059 👎 323

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int calculate(String s) {
        //  Initialize the current operand
        int currentOperand = 0;

        //  Initialize the current sign:
        //      1 for positive and -1 for negative
        int currentSign = 1;

        //  Initialize the result
        //      to updated as required
        //      before returning it at the end
        int result = 0;

        //  Declare a stack
        //      to store result and sign every time
        //      an open parenthesis is encountered
        //  Push result before pushing sign
        //      (done in separate statements)
        Deque<Integer> myStack = new ArrayDeque<>();

        //  Iterate over the entire length of the given string
        for (int i = 0; i < s.length(); i++) {
            //  Define a variable c to contain
            //      the current character
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                //  Update the current operand
                //  Always subtract character '0' since
                //      ASCII value of '0' is 48 and
                //      digit characters following '0'
                //      has correspoinding integer values added to 48
                currentOperand = currentOperand * 10 + (int) (c - '0');
            } else if (c == '+') {

                // Update the result by evaluating the
                //  current expression at the left
                result += currentSign * currentOperand;

                //  Reset the current sign to 1
                currentSign = 1;

                //  Reset the current operand to 0
                currentOperand = 0;

            } else if (c == '-') {
                result += currentSign * currentOperand;

                //  Update the current sign to -1
                currentSign = -1;

                //  Reset the current operand to 0
                currentOperand = 0;

            } else if (c == '(') {

                //  Needs to access currentSign first
                //      to deal with the final output
                //      following the evaluation of
                //      the expression inside the parentheses
                //  So, push result first to stack
                //      then, push the current sign to the same stack
                myStack.push(result);
                myStack.push(currentSign);

                 //  Reset the current sign to 1
                currentSign = 1;
                //  Reset the current result to 0
                result = 0;
            } else if (c == ')') {

                result +=  currentSign * currentOperand;

                //  Pop the sign from the top of the stack
                //      saved when its corresponding '('
                //      was encountered
                //  And, multiply the popped sign with the current result
                result *= myStack.pop();

                //  Pop the saved result from the top of the stack
                //  And, add the popped result with the current result
                result += myStack.pop();

                //  Reset the current operand to 0
                currentOperand = 0;
            }

        }

        return result + (currentSign * currentOperand);
    }

    public static void main(String[] args) {
        // Example 1:
        String s1 = "1 + 1";
        //  O/P: 2

        // Example 2:
        String s2 = " 2-1 + 2 ";
        //  O/P: 3

        // Example 3:
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        //  O/P: 23

        System.out.println(calculate(s1));
        System.out.println(calculate(s2));
        System.out.println(calculate(s3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

