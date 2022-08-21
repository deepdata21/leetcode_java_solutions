package com.leetcode.easy.implement_queue_using_stacks;

//import java.util.ArrayDeque;
//import java.util.Deque;
import java.util.Stack;

//Implement a first in first out (FIFO) queue using only two stacks. The
    //implemented queue should support all the functions of a normal queue (push, peek, pop,
    //and empty).
    //
    // Implement the MyQueue class:
    //
    //
    // void push(int x) Pushes element x to the back of the queue.
    // int pop() Removes the element from the front of the queue and returns it.
    // int peek() Returns the element at the front of the queue.
    // boolean empty() Returns true if the queue is empty, false otherwise.
    //
    //
    // Notes:
    //
    //
    // You must use only standard operations of a stack, which means only push to
    //top, peek/pop from top, size, and is empty operations are valid.
    // Depending on your language, the stack may not be supported natively. You may
    //simulate a stack using a list or deque (double-ended queue) as long as you use
    //only a stack's standard operations.
    //
    //
    //
    // Example 1:
    //
    //
    //Input
    //["MyQueue", "push", "push", "peek", "pop", "empty"]
    //[[], [1], [2], [], [], []]
    //Output
    //[null, null, null, 1, 1, false]
    //
    //Explanation
    //MyQueue myQueue = new MyQueue();
    //myQueue.push(1); // queue is: [1]
    //myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    //myQueue.peek(); // return 1
    //myQueue.pop(); // return 1, queue is [2]
    //myQueue.empty(); // return false
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= x <= 9
    // At most 100 calls will be made to push, pop, peek, and empty.
    // All the calls to pop and peek are valid.
    //
    //
    //
    // Follow-up: Can you implement the queue such that each operation is amortized
    //O(1) time complexity? In other words, performing n operations will take overall
    //O(n) time even if one of those operations may take longer.
    //
    // Related Topics Stack Design Queue 👍 4102 👎 265


//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {

//    private Deque<Integer> stack1 = new ArrayDeque<>();
//    private Deque<Integer> stack2 = new ArrayDeque<>();
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int topElement;
    public MyQueue() {

    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            topElement = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(!stack2.isEmpty()) {
            return stack2.peek();
        }
        return topElement;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class Solution {
    public static void main(String[] args) {

        // Example 1:
        //Input
        //["MyQueue", "push", "push", "peek", "pop", "empty"]
        //[[], [1], [2], [], [], []]
        //  O/P: //[null, null, null, 1, 1, false]

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
