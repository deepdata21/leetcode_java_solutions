package com.leetcode.easy.kth_largest_element_in_a_stream;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    //Design a class to find the kᵗʰ largest element in a stream. Note that it is
    //the kᵗʰ largest element in the sorted order, not the kᵗʰ distinct element.
    //
    // Implement KthLargest class:
    //
    //
    // KthLargest(int k, int[] nums) Initializes the object with the integer k and
    //the stream of integers nums.
    // int add(int val) Appends the integer val to the stream and returns the
    //element representing the kᵗʰ largest element in the stream.
    //
    //
    //
    // Example 1:
    //
    //
    //Input
    //["KthLargest", "add", "add", "add", "add", "add"]
    //[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
    //Output
    //[null, 4, 5, 5, 8, 8]
    //
    //Explanation
    //KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
    //kthLargest.add(3);   // return 4
    //kthLargest.add(5);   // return 5
    //kthLargest.add(10);  // return 5
    //kthLargest.add(9);   // return 8
    //kthLargest.add(4);   // return 8
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= k <= 10⁴
    // 0 <= nums.length <= 10⁴
    // -10⁴ <= nums[i] <= 10⁴
    // -10⁴ <= val <= 10⁴
    // At most 10⁴ calls will be made to add.
    // It is guaranteed that there will be at least k elements in the array when
    //you search for the kᵗʰ element.
    //
    //
    // Related Topics Tree Design Binary Search Tree Heap (Priority Queue) Binary
    //Tree Data Stream 👍 3193 👎 1865

//leetcode submit region begin(Prohibit modification and deletion)
//class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap;

    public Solution(int k, int[] nums) {
//    static KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
        }

        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        // Example 1:

        int k = 3;
        int[] nums = {4, 5, 8, 2};

        //Solution solution = new Solution(3, [4, 5, 8, 2]);
        Solution solution = new Solution(k, nums);

//        solution.add(3);   // return 4
//        solution.add(5);   // return 5
//        solution.add(10);  // return 5
//        solution.add(9);   // return 8
//        solution.add(4);   // return 8

        System.out.println(solution.add(3));   // return 4
        System.out.println(solution.add(5));   // return 5
        System.out.println(solution.add(10));  // return 5
        System.out.println(solution.add(9));   // return 8
        System.out.println(solution.add(4));   // return 8

    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

