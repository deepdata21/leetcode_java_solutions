package com.leetcode.medium.binary_tree_right_side_view;

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
    //Given the root of a binary tree, imagine yourself standing on the right side
    //of it, return the values of the nodes you can see ordered from top to bottom.
    //
    //
    // Example 1:
    //
    //
    //Input: root = [1,2,3,null,5,null,4]
    //Output: [1,3,4]
    //
    //
    // Example 2:
    //
    //
    //Input: root = [1,null,3]
    //Output: [1,3]
    //
    //
    // Example 3:
    //
    //
    //Input: root = []
    //Output: []
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
    // Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 86
    //91 👎 503

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
    /**
     * --------------------*
     * Complexity Analysis
     * --------------------*
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(h) where h is the height of the tree;
     *                   however, it's O(n) in the worst case
     *                   (skewed tree)
     */

    /**
     * -----------------------------*
     * Approach: DFS Using Recursion
     * -----------------------------*
     */

    //  Declare and initialize an instance/member variable
    //      (an ArrayList) to be returned as the answer
    List<Integer> rightSideValues = new ArrayList<>();

    /**
     * @param  root             the root node of the given tree
     * @return rightSideValues  ArrayList with values corresponding to nodes
     *                              that can be seen from the right side
     */

    public List<Integer> rightSideView(TreeNode root) {
//        //  Check edge case
        if (root == null) {
            //  If the given roo node is null
            //      return rightSideValues as is (i.e. empty)
            return this.rightSideValues;
        }

        //  Call the helper method;
        //      start from the root level (hence level depth = 0)
        recursionHelper(root, 0);

        //  Return rightSideValues updated in the previous statement
        return rightSideValues;
    }

    /**
     * @param   root            the given root node
     * @param   levelDepth      the depth of the starting level
     */
    private void recursionHelper(TreeNode root, int levelDepth) {
        //  If you want to use the pre-increment operator on level depths
        //      declare two separate variables for left and right subtrees
//        int rightLevelDepth = levelDepth;
//        int leftLevelDepth = levelDepth;

        //  Update rightSideValues if its size has the same value
        //      as the depth of the current level
        if (this.rightSideValues.size() == levelDepth) {
            this.rightSideValues.add(root.val);
        }

        //  Call the recursionHelper FIRST on root.right b/c right side view
        //  If the current node/root has a right child (subtree)
        //      make a recursive call after (hence pre-increment operator)
        //      increasing the value of levelDepth by 1
        if (root.right != null) {
            recursionHelper(root.right, levelDepth + 1);
//            recursionHelper(root.right, ++rightLevelDepth);
        }

        //  If the current node/root has a left child (subtree)
        //      make a recursive call after (hence pre-increment operator)
        //      increasing the value of levelDepth by 1
        if (root.left != null) {
            recursionHelper(root.left, levelDepth + 1);
//            recursionHelper(root.left, ++leftLevelDepth);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        //Input: root = [1,2,3,null,5,null,4]
//        TreeNode root1 = new TreeNode(1);
//        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(3);
//        root1.left.right = new TreeNode(5);
//        root1.right.right = new TreeNode(4);
//
//        System.out.println("Example 1: " + solution.rightSideView(root1));
        //  O/P: [1,3,4]

        System.out.println();
        // Example 2:
        //Input: root = [1,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println("Example 2: " + solution.rightSideView(root2));
        //  O/P: [1,3]

        System.out.println();
        // Example 3:
//        //Input: root = []
//        TreeNode root3 = new TreeNode();
//
//        System.out.println("Example 3: " + solution.rightSideView(root3));
        //Output: []
    }
}
//leetcode submit region end(Prohibit modification and deletion)

