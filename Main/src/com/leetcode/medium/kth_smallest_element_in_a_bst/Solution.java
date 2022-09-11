package com.leetcode.medium.kth_smallest_element_in_a_bst;

import java.util.Deque;
import java.util.ArrayDeque;

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
    //Given the root of a binary search tree, and an integer k, return the kᵗʰ
    //smallest value (1-indexed) of all the values of the nodes in the tree.
    //
    //
    // Example 1:
    //
    //
    //Input: root = [3,1,4,null,2], k = 1
    //Output: 1
    //
    //
    // Example 2:
    //
    //
    //Input: root = [5,3,6,2,4,null,null,1], k = 3
    //Output: 3
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the tree is n.
    // 1 <= k <= n <= 10⁴
    // 0 <= Node.val <= 10⁴
    //
    //
    //
    // Follow up: If the BST is modified often (i.e., we can do insert and delete
    //operations) and you need to find the kth smallest frequently, how would you
    //optimize?
    //
    // Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 8110
    // 👎 140


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
    public static int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        Deque<TreeNode> myStack = new ArrayDeque<>();

        while (true) {
            while (root != null) {
                myStack.push(root);
                root = root.left;
            }

            root = myStack.pop();

            if (--k == 0) {
                return root.val;
            }

            root = root.right;
        }
    }

    public static void main(String[] args) {
        // Example 1:
        // Input: root = [3,1,4,null,2], k = 1

        //          3
        //        /   \
        //       1     4
        //        \
        //         2

        TreeNode lA2 = new TreeNode(2, null, null);
        TreeNode lA1 = new TreeNode(1, null, lA2);
        TreeNode rA1 = new TreeNode(4, null, null);
        TreeNode rootA1 = new TreeNode(3, lA1, rA1);
        int k1 = 1;
        //  O/P: 1

        System.out.println(kthSmallest(rootA1, k1));

        // Example 2:
        // Input: root = [5,3,6,2,4,null,null,1], k = 3

        //          5
        //        /   \
        //       3     6
        //     /  \
        //    2    4
        //   /
        //  1

        TreeNode lB3 = new TreeNode(1, null, null);
        TreeNode lB2 = new TreeNode(2, lB3, null);
        TreeNode rB2 = new TreeNode(4, null, null);
        TreeNode lB1 = new TreeNode(3, lB2, rB2);
        TreeNode rB1 = new TreeNode(6, null, null);
        TreeNode rootB1 = new TreeNode(5, lB1, rB1);
        int k2 = 3;
        System.out.println(kthSmallest(rootB1, k2));
        //  O/P: 3
    }
}
//leetcode submit region end(Prohibit modification and deletion)
