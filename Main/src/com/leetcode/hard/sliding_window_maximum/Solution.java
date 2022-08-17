package com.leetcode.hard.sliding_window_maximum;

import java.util.*;

//public class Solution {
 class MethodsToSolution {
    //You are given an array of integers nums, there is a sliding window of size k
    //which is moving from the very left of the array to the very right. You can only
    //see the k numbers in the window. Each time the sliding window moves right by one
    //position.
    //
    // Return the max sliding window.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    //Output: [3,3,5,5,6,7]
    //Explanation:
    //Window position                Max
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [1], k = 1
    //Output: [1]
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 10⁵
    // -10⁴ <= nums[i] <= 10⁴
    // 1 <= k <= nums.length
    //
    //
    // Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic
    //Queue 👍 11481 👎 376


    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    Deque<Integer> windowQueue = new ArrayDeque<>();
    //  Make nums available globally
    int[] nums;

    public void updatedWindowQueue(int index, int k) {

        //  Only keep the indexes of current sliding window
        if (!windowQueue.isEmpty() &&
                windowQueue.peekFirst() == index - k) {
            windowQueue.pollFirst();
        }

        //  Only keep the max value in the current sliding window
        while (!windowQueue.isEmpty() &&
                nums[index] > nums[windowQueue.peekLast()]) {
            windowQueue.pollLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        //  If either k or nums is zero
        //      return 0
        if (nums.length * k == 0) {
            return new int[0];
        }

        if (k == 1) {
            //  Returns the original list since
            //      the ONLY element is the max or min
            //      in the current window
            return nums;
        }

        //  Set nums to global nums
        this.nums = nums;
        int maximumIndex = 0;

        //  Initialize windowQueue
        for (int i = 0; i < k; i++) {
            updatedWindowQueue(i, k);
            windowQueue.offerLast(i);

            if (nums[i] > nums[maximumIndex]) {
                maximumIndex = i;
            }
        }

        //  Initialize result
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[maximumIndex];

        //  Final Step
        for (int i = k; i < nums.length; i++) {
            updatedWindowQueue(i, k);
            windowQueue.offerLast(i);
            result[i - k + 1] = nums[windowQueue.peekFirst()];
        }

        return result;
    }

}

class Solution {
    public static void main(String[] args) {

        MethodsToSolution methodsToSolution = new MethodsToSolution();

        // Example 1:
        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        int k1 = 3;
        //  O/P: [3,3,5,5,6,7]

        // Example 2:
        int[] nums2 = {1};
        int k2 = 1;
        //  O/P: [1]

        System.out.println(Arrays.toString(
                methodsToSolution.maxSlidingWindow(nums1, k1)));
        System.out.println(Arrays.toString(
                methodsToSolution.maxSlidingWindow(nums2, k2)));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
