package com.leetcode.medium.evaluate_reverse_polish_notation;

import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    //Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    //
    // Valid operators are +, -, *, and /. Each operand may be an integer or
    //another expression.
    //
    // Note that division between two integers should truncate toward zero.
    //
    // It is guaranteed that the given RPN expression is always valid. That means
    //the expression would always evaluate to a result, and there will not be any
    //division by zero operation.
    //
    //
    // Example 1:
    //
    //
    //Input: tokens = ["2","1","+","3","*"]
    //Output: 9
    //Explanation: ((2 + 1) * 3) = 9
    //
    //
    // Example 2:
    //
    //
    //Input: tokens = ["4","13","5","/","+"]
    //Output: 6
    //Explanation: (4 + (13 / 5)) = 6
    //
    //
    // Example 3:
    //
    //
    //Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    //Output: 22
    //Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    //= ((10 * (6 / (12 * -11))) + 17) + 5
    //= ((10 * (6 / -132)) + 17) + 5
    //= ((10 * 0) + 17) + 5
    //= (0 + 17) + 5
    //= 17 + 5
    //= 22
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= tokens.length <= 10⁴
    // tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
    //range [-200, 200].
    //
    //
    // Related Topics Array Math Stack 👍 3836 👎 686


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int evalRPN(String[] tokens) {

        Deque<Integer> myStack = new ArrayDeque<>();

        for (String token : tokens) {

            if (!"[+-*/]".contains(token)) {
                myStack.push(Integer.valueOf(token));
                continue;
            }

            //  2nd number is popped first
            //      because stack
            int numberTwo = myStack.pop();
            int numberOne = myStack.pop();

            int output = 0;

            switch (token) {
                case "+":
                    output = numberOne + numberTwo;
                    break;

                case "-":
                    output = numberOne - numberTwo;
                    break;

                case "*":
                    output = numberOne * numberTwo;
                    break;

                case "/":
                    output = numberOne / numberTwo;
                    break;
            }

            myStack.push(output);
        }

        return myStack.pop();

    }

    public static void main (String[] args) {

        // Example 1:
        String[] tokens1 = {"2","1","+","3","*"};
        //  O/P: 9

        // Example 2:
        String[] tokens2 = {"4","13","5","/","+"};
        //  O/P: 6

        // Example 3:
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        //  O/P: 22

        System.out.println(evalRPN(tokens1));
        System.out.println(evalRPN(tokens2));
        System.out.println(evalRPN(tokens3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

