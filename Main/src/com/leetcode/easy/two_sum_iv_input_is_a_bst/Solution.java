package com.leetcode.easy.two_sum_iv_input_is_a_bst;

import java.util.Map;
import java.util.HashMap;

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
    //Given the root of a Binary Search Tree and a target number k, return true if
    //there exist two elements in the BST such that their sum is equal to the given
    //target.
    //
    //
    // Example 1:
    //
    //
    //Input: root = [5,3,6,2,4,null,7], k = 9
    //Output: true
    //
    //
    // Example 2:
    //
    //
    //Input: root = [5,3,6,2,4,null,7], k = 28
    //Output: false
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the tree is in the range [1, 10⁴].
    // -10⁴ <= Node.val <= 10⁴
    // root is guaranteed to be a valid binary search tree.
    // -10⁵ <= k <= 10⁵
    //
    //
    // Related Topics Hash Table Two Pointers Tree Depth-First Search Breadth-First
    //Search Binary Search Tree Binary Tree 👍 5190 👎 227


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

    Map<Integer, Integer> hMap = new HashMap<>();
    int nodeCount = 0;
    boolean flag = false;

    public boolean findTarget(TreeNode root, int k) {
        recursionHelper(root, k);
        return flag;
    }

    private void recursionHelper(TreeNode root, int k) {

        if (root == null) {
            return;
        }

        this.hMap.put(root.val, nodeCount++);

        int complement = k - root.val;

        if (hMap.containsKey(complement) &&
                hMap.get(complement) != nodeCount - 1) {
            flag = true;
        }

        if (root.left != null) {
            recursionHelper(root.left, k);
        }

        if (root.right != null) {
            recursionHelper(root.right, k);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        //Input: root = [5,3,6,2,4,null,7], k = 9
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);

//        int k1 = 9;

//        System.out.println(solution.findTarget(root, k1));
        //Output: true

        // Example 2:
        //Input: root = [5,3,6,2,4,null,7], k = 28
        //  SAME as root in Example 1

        int k2 = 28;

        System.out.println(solution.findTarget(root, k2));
        //Output: false

    }
}
//leetcode submit region end(Prohibit modification and deletion)

