package com.leetcode.medium.min_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class Solution {
    //Design a stack that supports push, pop, top, and retrieving the minimum
    //element in constant time.
    //
    // Implement the MinStack class:
    //
    //
    // MinStack() initializes the stack object.
    // void push(int val) pushes the element val onto the stack.
    // void pop() removes the element on the top of the stack.
    // int top() gets the top element of the stack.
    // int getMin() retrieves the minimum element in the stack.
    //
    //
    // You must implement a solution with O(1) time complexity for each function.
    //
    //
    // Example 1:
    //
    //
    //Input
    //["MinStack","push","push","push","getMin","pop","top","getMin"]
    //[[],[-2],[0],[-3],[],[],[],[]]
    //
    //Output
    //[null,null,null,null,-3,null,0,-2]
    //
    //Explanation
    //MinStack minStack = new MinStack();
    //minStack.push(-2);
    //minStack.push(0);
    //minStack.push(-3);
    //minStack.getMin(); // return -3
    //minStack.pop();
    //minStack.top();    // return 0
    //minStack.getMin(); // return -2
    //
    //
    //
    // Constraints:
    //
    //
    // -2³¹ <= val <= 2³¹ - 1
    // Methods pop, top and getMin operations will always be called on non-empty
    //stacks.
    // At most 3 * 10⁴ calls will be made to push, pop, top, and getMin.
    //
    //
    // Related Topics Stack Design 👍 9389 👎 667

//leetcode submit region begin(Prohibit modification and deletion)

    private static Deque<Integer> myStack = new ArrayDeque<>();
    private static Deque<int[]> minimumStack = new ArrayDeque<>();

    public Solution() {

    }

    public static void push(int val) {
        myStack.push(val);

        if (minimumStack.isEmpty() ||
            val < minimumStack.peek()[0]) {
            minimumStack.push(new int[] {val, 1});
        } else if (val == minimumStack.peek()[0]) {
            minimumStack.peek()[1]++;
        }
    }

    public static void pop() {

        if (myStack.peek().equals(minimumStack.peek()[0])) {
            minimumStack.peek()[1]--;
        }

        if (minimumStack.peek()[1] == 0) {
            minimumStack.pop();
        }

        myStack.pop();
    }

    public static int top() {
        return myStack.peek();
    }

    public static int getMin() {
        return minimumStack.peek()[0];
    }

    public static void main(String[] args) {
        // Example 1:
        //Input
        //["MinStack","push","push","push","getMin","pop","top","getMin"]
        //[[],[-2],[0],[-3],[],[],[],[]]
        //Output
        //[null,null,null,null,-3,null,0,-2]

    //Explanation
    //MinStack minStack = new MinStack();
    //minStack.push(-2);
    //minStack.push(0);
    //minStack.push(-3);
    //minStack.getMin(); // return -3
    //minStack.pop();
    //minStack.top();    // return 0
    //minStack.getMin(); // return -2

       Solution minStack = new Solution();
       System.out.println(Arrays.toString(minStack.myStack.toArray()));

       minStack.push(-2);
       System.out.println(Arrays.toString(minStack.myStack.toArray()));

       minStack.push(0);
       System.out.println(Arrays.toString(minStack.myStack.toArray()));

       minStack.push(-3);
       System.out.println(Arrays.toString(minStack.myStack.toArray()));

       minStack.getMin();
       System.out.println(minStack.getMin());

       minStack.pop();

       minStack.top();
       System.out.println(minStack.top());

       minStack.getMin();
       System.out.println(minStack.getMin());

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

