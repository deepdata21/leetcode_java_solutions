package com.leetcode.hard.largest_rectangle_in_histogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    //Given an array of integers heights representing the histogram's bar height
    //where the width of each bar is 1, return the area of the largest rectangle in the
    //histogram.
    //
    //
    // Example 1:
    //
    //
    //Input: heights = [2,1,5,6,2,3]
    //Output: 10
    //Explanation: The above is a histogram where width of each bar is 1.
    //The largest rectangle is shown in the red area, which has an area = 10 units.
    //
    //
    // Example 2:
    //
    //
    //Input: heights = [2,4]
    //Output: 4
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= heights.length <= 10⁵
    // 0 <= heights[i] <= 10⁴
    //
    //
    // Related Topics Array Stack Monotonic Stack 👍 11987 👎 166


//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public static int largestRectangleArea(int[] heights) {
        //  Initialize largest area with 0
        int largestArea = 0;

        //  Creat a stack
        Deque<Integer> myStack = new ArrayDeque<>();
        //  Push -1 to the stack to help with out of bounds
        //      calculations
        myStack.push(-1);

        //  Iterate over all elements in the given heights array
        for (int i = 0; i < heights.length; i++) {
            //  Calculate and update largestArea if
            //      element on top of the stack
            //      is bigger than the current element
            while (myStack.peek() != -1 &&
                   heights[i] <= heights[myStack.peek()]) {
                //  current height/element
                int currentMaxHeight = heights[myStack.pop()];
                //  myStack.peek()—after myStack.pop() in line above—
                //      is left boundary
                //      and i is right boundary
                //      subtract -1 because 0-indexed
                int currentWidth = i - myStack.peek() - 1;

                largestArea = Math.max(largestArea,
                        currentMaxHeight * currentWidth);
            }

            myStack.push(i);
        }

        //  For the last element in the given heights array
        while (myStack.peek() != -1) {
            //  last height/element
            int currentMaxHeight = heights[myStack.pop()];
            //  myStack.peek()—after myStack.pop() in line above—
            //      is left boundary
            //      and heights.length is right boundary
            //      subtract -1 because 0-indexed
            int currentWidth = heights.length - myStack.peek() - 1;

            largestArea = Math.max(largestArea,
                    currentMaxHeight * currentWidth);

        }

        return largestArea;
    }

    public static void main(String[] args) {
        // Example 1:
        int[] heights1 = {2,1,5,6,2,3};
        //  O/P: 10

        // Example 2:
        int[] heights2 = {2,4};
        //  O/P: 4

        System.out.println(largestRectangleArea(heights1));
        System.out.println(largestRectangleArea(heights2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

