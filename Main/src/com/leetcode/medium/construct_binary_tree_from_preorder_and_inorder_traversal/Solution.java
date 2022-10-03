package com.leetcode.medium.construct_binary_tree_from_preorder_and_inorder_traversal;

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
    //Given two integer arrays preorder and inorder where preorder is the preorder
    //traversal of a binary tree and inorder is the inorder traversal of the same tree,
    // construct and return the binary tree.
    //
    //
    // Example 1:
    //
    //
    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //Output: [3,9,20,null,null,15,7]
    //
    //
    // Example 2:
    //
    //
    //Input: preorder = [-1], inorder = [-1]
    //Output: [-1]
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= preorder.length <= 3000
    // inorder.length == preorder.length
    // -3000 <= preorder[i], inorder[i] <= 3000
    // preorder and inorder consist of unique values.
    // Each value of inorder also appears in preorder.
    // preorder is guaranteed to be the preorder traversal of the tree.
    // inorder is guaranteed to be the inorder traversal of the tree.
    //
    //
    // Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 11086
    //👎 307


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
    //  Recursive Approch
    //  Time Complexity: O(N)
    //  Space Complexity: O(N)

    //  Breaking down the probblem:
    //      we have int[] preorder and int[] inorder
    //      for the SAME binary tree
    //      we need the return the binary tree

    //  Preorder traversal means, traversing
    //      root node -> left node -> right node
    //  Inorder traversal means, traversing
    //      left node-> root node -> right node

    //  So, the very first element of int[] preorder
    //      is the root of the binary tree

    //  Since, int[] preorder and int[] inorder consist
    //      of UNIQUE values (see constraints), we can use
    //      a hashmap (hash table) to store the node values
    //      and corresponding indices from int[] inorder
    //      to find index the root node in int[] inorder.

    //   For inroder traversl:
    //      left node-> root node -> right node,
    //      so, we can use the root index in int[] inorder
    //      to find the left and right subtrees
    //      on its left and right sides

    //  Finally, to build the binary tree we can use
    //      recursion on left and right subtrees
    //  NOTE:   We will keep using int[] preorder
    //              to find the root nodes for subtress
    //          And, we will use the hashmap from int[] inorder
    //          to determine the right index of the left subtree
    //          and the left index of the right subtree
    //          using the index of the root node in each subtree

    //  Declare a global variable to store
    //      the root indices from int[] inorder
    //  And, initialize it with 0
    private int rootIndex;

    //  Declare a Map data structure to build a hash table
    //      to store the node values and corresponding indices
    //      from int[] inorder
    private Map<Integer, Integer> inorderTraversalMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //  Initialize the rootIndex with 0
        rootIndex = 0;

        //  Build the hashmap as mentioned earlier
        inorderTraversalMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            //  key = node value
            //  value = index of node value
            inorderTraversalMap.put(inorder[i], i);
        }


        return recursiveHelper(preorder, rootIndex, preorder.length - 1);
    }

    public TreeNode recursiveHelper(int[] traversalArray,
                                    int leftIndex,
                                    int rightIndex) {

        //  Recursion base case: returns null if
        //      the left index in greater than the right index
        if (leftIndex > rightIndex) {
            return null;
        }

        //  Store the first element of the given preorder traversal array
        //       as the value of the root node
        //  rootIndex++: means FIRST apply rootIndex in the current statement
        //      and then increase its value by 1 (to be used for a later call)
        int nodeValue = traversalArray[rootIndex++];
        TreeNode root = new TreeNode(nodeValue);

        //  Recursively build the left subtree
        root.left = recursiveHelper(traversalArray,
                leftIndex,
                inorderTraversalMap.get(nodeValue) - 1);

        //  Recursively build the right subtree
        root.right = recursiveHelper(traversalArray,
                inorderTraversalMap.get(nodeValue) + 1,
                rightIndex);

        return root;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example 1:
        int[] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        //  .val to print only the value of root node
        System.out.println(solution.buildTree(preorder, inorder).val);

        System.out.println("---");
        // Example 2:
        preorder = new int[] {-1};
        inorder = new int[] {-1};
        //  .val to print only the value of root node
        System.out.println(solution.buildTree(preorder, inorder).val);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
