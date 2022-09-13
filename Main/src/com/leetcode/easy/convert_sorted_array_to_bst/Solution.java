package com.leetcode.easy.convert_sorted_array_to_bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    //Given an integer array nums where the elements are sorted in ascending order,
    //convert it to a height-balanced binary search tree.
    //
    // A height-balanced binary tree is a binary tree in which the depth of the two
    //subtrees of every node never differs by more than one.
    //
    //
    // Example 1:
    //
    //
    //Input: nums = [-10,-3,0,5,9]
    //Output: [0,-3,9,-10,null,5]
    //Explanation: [0,-10,5,null,-3,null,9] is also accepted:
    //
    //
    //
    // Example 2:
    //
    //
    //Input: nums = [1,3]
    //Output: [3,1]
    //Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= nums.length <= 10⁴
    // -10⁴ <= nums[i] <= 10⁴
    // nums is sorted in a strictly increasing order.
    //
    //
    // Related Topics Array Divide and Conquer Tree Binary Search Tree Binary Tree ?
    //? 8126 👎 407


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//class Solution {
    public static TreeNode sortedArrayToBST(int[] nums) {

        return null;
    }

    //  LC# 108
    public static void main(String[] args) {
        // Example 1:
        //Input: nums = [-10,-3,0,5,9]
        //Output: [0,-3,9,-10,null,5]
        //Explanation: [0,-10,5,null,-3,null,9] is also accepted:

        // Example 2:
        //Input: nums = [1,3]
        //Output: [3,1]
        //Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

    }
}
//leetcode submit region end(Prohibit modification and deletion)
