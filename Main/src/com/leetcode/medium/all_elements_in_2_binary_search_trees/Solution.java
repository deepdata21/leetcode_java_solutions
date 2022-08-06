package com.leetcode.medium.all_elements_in_2_binary_search_trees;

//  Needs to implement tree

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

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
//Given two binary search trees root1 and root2, return a list containing all
//the integers from both trees sorted in ascending order.
//
//
// Example 1:
//
//
//Input: root1 = [2,1,4], root2 = [1,0,3]
//Output: [0,1,1,2,3,4]
//
//
// Example 2:
//
//
//Input: root1 = [1,null,8], root2 = [8,1]
//Output: [1,1,8,8]
//
//
//
// Constraints:
//
//
// The number of nodes in each tree is in the range [0, 5000].
// -10⁵ <= Node.val <= 10⁵
//
//
// Related Topics Tree Depth-First Search Binary Search Tree Sorting Binary
//Tree 👍 2379 👎 69


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
//    class Solution {
    static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        while (root1 != null || root2 != null ||
                !stack1.isEmpty() || !stack2.isEmpty()) {

            //  Update both stacks
            //      by going left till possible

            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            //   Add the smallest value into output,
            //      pop it from the stack
            //      and then do one step right
            if (stack2.isEmpty() || !stack1.isEmpty() &&
                    stack1.getFirst().val <= stack2.getFirst().val) {
                root1 = stack1.pop();
                result.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = stack2.pop();
                result.add(root2.val);
                root2 = root2.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1:
        Integer[] rootA1 = {2,1,4};
        Integer[] rootA2 = {1,0,3};
        //  O/P: [0,1,1,2,3,4]

        // Example 2:
        Integer[] rootB1 = {1,null,8};
        Integer [] rootB2 = {8,1};
        //Output: [1,1,8,8]

        //  Placeholder
        System.out.println(java.util.List.of(1, 2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

