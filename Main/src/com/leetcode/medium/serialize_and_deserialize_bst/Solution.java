package com.leetcode.medium.serialize_and_deserialize_bst;

//  Need to implement tree

import java.util.ArrayDeque;

//  Needs to implement TreeNode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    //Serialization is converting a data structure or object into a sequence of
    //bits so that it can be stored in a file or memory buffer, or transmitted across a
    //network connection link to be reconstructed later in the same or another computer
    //environment.
    //
    // Design an algorithm to serialize and deserialize a binary search tree. There
    //is no restriction on how your serialization/deserialization algorithm should
    //work. You need to ensure that a binary search tree can be serialized to a string,
    //and this string can be deserialized to the original tree structure.
    //
    // The encoded string should be as compact as possible.
    //
    //
    // Example 1:
    // Input: root = [2,1,3]
    //Output: [2,1,3]
    //
    // Example 2:
    // Input: root = []
    //Output: []
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the tree is in the range [0, 10⁴].
    // 0 <= Node.val <= 10⁴
    // The input tree is guaranteed to be a binary search tree.
    //
    //
    // Related Topics String Tree Depth-First Search Breadth-First Search Design
    //Binary Search Tree Binary Tree 👍 2865 👎 137


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Codec {

        //  Postorder DFS follows: left -> right -> root
        public StringBuilder postorderDFS(TreeNode root,
                                          StringBuilder sBuilder) {

            if (root == null) {
                return sBuilder;
            }

            postorderDFS(root.left, sBuilder);
            postorderDFS(root.right, sBuilder);
            sBuilder.append(root.val);
            sBuilder.append(' ');

            return sBuilder;
        }

        // Encoding a tree to a single string
        public String serialize(TreeNode root) {

            StringBuilder sBuilder = postorderDFS(root, new StringBuilder());

            if (sBuilder.length() > 0) {
                sBuilder.deleteCharAt(sBuilder.length() - 1);
            }

            return sBuilder.toString();
        }

        public TreeNode deserializeHelper(Integer low,
                                          Integer high,
                                          ArrayDeque<Integer> arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return null;
            }

            int val = arrayDeque.getLast();

            if (val < low || val > high) {
                return null;
            }

            arrayDeque.removeLast();
            TreeNode root = new TreeNode(val);
            root.right = deserializeHelper(val, high, arrayDeque);
            root.left = deserializeHelper(low, val, arrayDeque);
            return root;
        }

        // Decoding the encoded data to tree.
        public TreeNode deserialize(String data) {

            if (data.isEmpty()) {
                return null;
            }

            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

            for (String string : data.split("\\s+")) {
                arrayDeque.add(Integer.valueOf(string));
            }

            return deserializeHelper(Integer.MIN_VALUE,
                    Integer.MAX_VALUE, arrayDeque);
        }
    }

    public static void main(String[] args) {

        // Example 1:
        int[] root1 = {2, 1, 3};
        //  O/P: [2,1,3]

        // Example 2:
        int[] root2 = {};
        //  O/P: []

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)
