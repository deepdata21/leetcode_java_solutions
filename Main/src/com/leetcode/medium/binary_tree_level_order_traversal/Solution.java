package com.leetcode.medium.binary_tree_level_order_traversal;

import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

class TreeNode {

   int val;
   TreeNode left;
   TreeNode right;

    //   Empty constructor to allow empty TreeNode
    TreeNode () {
    }

   TreeNode (int val) {
      this.val = val;
   }

//   TreeNode (int val, TreeNode left, TreeNode right) {
//      this.val = val;
//      this.left = left;
//      this.right = right;
//   }
}

public class Solution {
    //Given the root of a binary tree, return the level order traversal of its
    //nodes' values. (i.e., from left to right, level by level).
    //
    //
    // Example 1:
    //
    //
    //Input: root = [3,9,20,null,null,15,7]
    //Output: [[3],[9,20],[15,7]]
    //
    //
    // Example 2:
    //
    //
    //Input: root = [1]
    //Output: [[1]]
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
    // The number of nodes in the tree is in the range [0, 2000].
    // -1000 <= Node.val <= 1000
    //
    //
    // Related Topics Tree Breadth-First Search Binary Tree 👍 10562 👎 199


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
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> outputList = new ArrayList<>();

        if (root == null) {
            return outputList;
        }

        Deque<TreeNode> levelQueue = new ArrayDeque<>();
        levelQueue.offer(root);

        while (!levelQueue.isEmpty()) {
            int currentSize = levelQueue.size();

            List<Integer> currentList = new ArrayList<>();

            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = levelQueue.poll();
                currentList.add(currentNode.val);

                if (currentNode.left != null) {
                    levelQueue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    levelQueue.offer(currentNode.right);
                }
            }
            outputList.add(currentList);
        }

        return outputList;
    }

        public static void main (String[] ars) {

        //  Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        //  O/P: [[3],[9,20],[15,7]]

        System.out.println(levelOrder(root1));
        System.out.println();

        //  Example 2
        TreeNode root2 = new TreeNode(1);
        //  O/P: [[1]]
        System.out.println(levelOrder(root2));
        System.out.println();

        //  [PROBLEMATIC] Example 3
        TreeNode root3 = new TreeNode();
        //  O/P: []
        System.out.println(levelOrder(root3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
