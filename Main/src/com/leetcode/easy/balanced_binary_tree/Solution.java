package com.leetcode.easy.balanced_binary_tree;

//  Needs to implement TreeNode
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

//  Utility class to store information from recursive calls
final class TreeInfo {
    public final boolean balanced;
    public final int height;

    public TreeInfo (boolean balanced, int height){
        this.balanced = balanced;
        this.height = height;
    }
}

public class Solution {
//Given a binary tree, determine if it is height-balanced.
//
// For this problem, a height-balanced binary tree is defined as:
//
//
// a binary tree in which the left and right subtrees of every node differ in
//height by no more than 1.
//
//
//
// Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: true
//
//
// Example 2:
//
//
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false
//
//
// Example 3:
//
//
//Input: root = []
//Output: true
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 5000].
// -10⁴ <= Node.val <= 10⁴
//
//
// Related Topics Tree Depth-First Search Binary Tree 👍 6632 👎 348


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

    //  Return whether or not the tree at root is balanced while...
    //      also storing the tree's height in a reference varialbe
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        //  An empty tree is balanced and has height = -1
        if (root == null) {
            return new TreeInfo(true, -1);
        }

        //  Check subtree to see if they are balanced
        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(false, -1);
        }

        //  Use the height obtained from the recursive calls to...
        //      determine if the current node is also balanced
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(false, -1);
        }

        if (java.lang.Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(
                    true, java.lang.Math.max(left.height, right.height) + 1);
        }

        return new TreeInfo(false, -1);
    }

    public boolean isBalanced(TreeNode root) {

        return isBalancedTreeHelper(root).balanced;

    }

    public static void main(String[] args) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

