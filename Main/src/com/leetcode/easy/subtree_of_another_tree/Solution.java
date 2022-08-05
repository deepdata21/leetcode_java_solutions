package com.leetcode.easy.subtree_of_another_tree;

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

public class Solution {
    //Given the roots of two binary trees root and subRoot, return true if there is
    //a subtree of root with the same structure and node values of subRoot and false
    //otherwise.
    //
    // A subtree of a binary tree tree is a tree that consists of a node in tree
    //and all of this node's descendants. The tree tree could also be considered as a
    //subtree of itself.
    //
    //
    // Example 1:
    //
    //
    //Input: root = [3,4,5,1,2], subRoot = [4,1,2]
    //Output: true
    //
    //
    // Example 2:
    //
    //
    //Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
    //Output: false
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the root tree is in the range [1, 2000].
    // The number of nodes in the subRoot tree is in the range [1, 1000].
    // -10⁴ <= root.val <= 10⁴
    // -10⁴ <= subRoot.val <= 10⁴
    //
    //
    // Related Topics Tree Depth-First Search String Matching Binary Tree Hash
    //Function 👍 5826 👎 317


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
    static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)){
            return true;
        }

        return (isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot));
    }

    private static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        return (isSameTree(root1.left, root2.left) &&
                isSameTree(root1.right, root2.right));

    }

    public static void main(String[] args) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

