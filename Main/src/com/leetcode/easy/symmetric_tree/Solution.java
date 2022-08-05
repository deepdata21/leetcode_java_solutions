package com.leetcode.easy.symmetric_tree;

//  TreeNode needs to be implemented

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
    //Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
    // symmetric around its center).
    //
    //
    // Example 1:
    //
    //
    //Input: root = [1,2,2,3,4,4,3]
    //Output: true
    //
    //
    // Example 2:
    //
    //
    //Input: root = [1,2,2,null,3,null,3]
    //Output: false
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the tree is in the range [1, 1000].
    // -100 <= Node.val <= 100
    //
    //
    //
    //Follow up: Could you solve it both recursively and iteratively?
    //
    // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 10
    //235 👎 243


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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.val == root2.val)
                && isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left);

    }

    public static void main(String[] args) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

