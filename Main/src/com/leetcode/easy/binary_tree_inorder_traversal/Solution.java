package com.leetcode.easy.binary_tree_inorder_traversal;

//  Needs to implement tree

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
    //Given the root of a binary tree, return the inorder traversal of its nodes'
    //values.
    //
    //
    // Example 1:
    //
    //
    //Input: root = [1,null,2,3]
    //Output: [1,3,2]
    //
    //
    // Example 2:
    //
    //
    //Input: root = []
    //Output: []
    //
    //
    // Example 3:
    //
    //
    //Input: root = [1]
    //Output: [1]
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the tree is in the range [0, 100].
    // -100 <= Node.val <= 100
    //
    //
    //
    //Follow up: Recursive solution is trivial, could you do it iteratively?
    //
    // Related Topics Stack Tree Depth-First Search Binary Tree 👍 8421 👎 390


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
    static List<Integer> inorderTraversal(TreeNode root) {
        //  Using Morris Traversal
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            //  If left is null, print the tree node and go to right
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                //  find the predecessor
                TreeNode predecessor = current.left;
                //  To find predecessor keep going right till right node is not null
                //      or right node is not current
                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                //  If right node is null then go left after
                //      establishing link from predecessor to current
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else { // Left is already visited.
                    //  Go right after visiting current
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        // Example 1:
        //
        //
        //Input: root = [1,null,2,3]
        //Output: [1,3,2]
        //
        //
        // Example 2:
        //
        //
        //Input: root = []
        //Output: []
        //
        //
        // Example 3:
        //
        //
        //Input: root = [1]
        //Output: [1]
        //
    }
}
//leetcode submit region end(Prohibit modification and deletion)

