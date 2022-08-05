package com.leetcode.easy.lowest_common_ancestor_of_a_bst;

// Needs to implement TreeNode in the main method

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    //Given a binary search tree (BST), find the lowest common ancestor (LCA) node
    //of two given nodes in the BST.
    //
    // According to the definition of LCA on Wikipedia: “The lowest common ancestor
    //is defined between two nodes p and q as the lowest node in T that has both p
    //and q as descendants (where we allow a node to be a descendant of itself).”
    //
    //
    // Example 1:
    //
    //
    //Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //Output: 6
    //Explanation: The LCA of nodes 2 and 8 is 6.
    //
    //
    // Example 2:
    //
    //
    //Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    //Output: 2
    //Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant
    //of itself according to the LCA definition.
    //
    //
    // Example 3:
    //
    //
    //Input: root = [2,1], p = 2, q = 1
    //Output: 2
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the tree is in the range [2, 10⁵].
    // -10⁹ <= Node.val <= 10⁹
    // All Node.val are unique.
    // p != q
    // p and q will exist in the BST.
    //
    //
    // Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 6603
    // 👎 209


    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//class Solution {
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode current = root;

        while (current != null) {

            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else {
                return current;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        // Example 1:
        //
        //
        //Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        //Output: 6
        //Explanation: The LCA of nodes 2 and 8 is 6.
        //
        //
        // Example 2:
        //
        //
        //Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        //Output: 2
        //Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant
        //of itself according to the LCA definition.
        //
        //
        // Example 3:
        //
        //
        //Input: root = [2,1], p = 2, q = 1
        //Output: 2
    }
}
//leetcode submit region end(Prohibit modification and deletion)
