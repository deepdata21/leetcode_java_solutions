package com.leetcode.easy.diameter_of_binary_tree;

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
    //Given the root of a binary tree, return the length of the diameter of the
    //tree.
    //
    // The diameter of a binary tree is the length of the longest path between any
    //two nodes in a tree. This path may or may not pass through the root.
    //
    // The length of a path between two nodes is represented by the number of edges
    //between them.
    //
    //
    // Example 1:
    //
    //
    //Input: root = [1,2,3,4,5]
    //Output: 3
    //Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    //
    //
    // Example 2:
    //
    //
    //Input: root = [1,2]
    //Output: 1
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the tree is in the range [1, 10⁴].
    // -100 <= Node.val <= 100
    //
    //
    // Related Topics Tree Depth-First Search Binary Tree 👍 8751 👎 540


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

    //  Global variable to store diameter
    static int d;

    //  Method to return the longest diameter
    static int diameterOfBinaryTree(TreeNode root) {

        d = 0;
        longestPath(root);
        return d;
    }

    //  Private method to implement the depth-first search
    //      to find the longest diameter
    static int longestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //  Recursively find the longest path in
        //      both left child and right child
        int leftPath = longestPath(root.left);
        int rightPath = longestPath(root.right);

        //  Update the diameter if leftPath + rightPath is
        //      greater than current diameter
        d = Math.max(d, leftPath + rightPath);

        //  Return the longest path between leftPath and rightPath
        //  Remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] dataArray1 = {1,2,3,4,5};
        //  O/P: 3

        // Example 2:
        int[] dataArray2 = {1,2};
        //  O/P: 1

        TreeNode treeNode = new TreeNode();

    }

}
//leetcode submit region end(Prohibit modification and deletion)

