package com.leetcode.hard.serialize_and_deserialize_binary_tree;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    //Serialization is the process of converting a data structure or object into a
    //sequence of bits so that it can be stored in a file or memory buffer, or
    //transmitted across a network connection link to be reconstructed later in the same or
    //another computer environment.
    //
    // Design an algorithm to serialize and deserialize a binary tree. There is no
    //restriction on how your serialization/deserialization algorithm should work. You
    //just need to ensure that a binary tree can be serialized to a string and this
    //string can be deserialized to the original tree structure.
    //
    // Clarification: The input/output format is the same as how LeetCode
    //serializes a binary tree. You do not necessarily need to follow this format, so please be
    //creative and come up with different approaches yourself.
    //
    //
    // Example 1:
    //
    //
    //Input: root = [1,2,3,null,null,4,5]
    //Output: [1,2,3,null,null,4,5]
    //
    //
    // Example 2:
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
    // The number of nodes in the tree is in the range [0, 10⁴].
    // -1000 <= Node.val <= 1000
    //
    //
    // Related Topics String Tree Depth-First Search Breadth-First Search Design
    //Binary Tree 👍 7289 👎 273


    //leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 */
//public class Codec {

    //  Approach 1: Recursive
    //  Time Complextity: O(N)
    //  Space Complextity: O(N)

    public String serializeHelper (TreeNode root, String str) {

        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = serializeHelper(root.left, str);
            str = serializeHelper(root.right, str);
        }
       return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        //  Following DFS pre-order traversal
        //      (root -> left -> right),
        //      encodes a tree to a single string

        //  Declare an empty string
        String myString = "";

        return serializeHelper(root, myString);
    }

    public TreeNode deserializeHelper (List<String> sList) {

        if (sList.get(0).equals("null")) {
            sList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode (Integer.valueOf(sList.get(0)));
        sList.remove(0);
        root.left = deserializeHelper(sList);
        root.right = deserializeHelper(sList);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        //  Split the encoded/serlialized string data
        //      on , to produce a string array
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));

        return deserializeHelper(dataList);
    }

    public static void main(String[] args) {

        // Example 1:
        //Input: root = [1,2,3,null,null,4,5]
        List<String> list = List.of("1","2","3","4","5");
        TreeNode root1 = new TreeNode(Integer.valueOf(list.get(0)));
        root1.left = new TreeNode(Integer.valueOf(list.get(1)));
        root1.right = new TreeNode(Integer.valueOf(list.get(2)));
        root1.right.left = new TreeNode(Integer.valueOf(list.get(3)));
        root1.right.right = new TreeNode(Integer.valueOf(list.get(4)));
        //  O/P: [1,2,3,null,null,4,5]

        // Example 2:
        //Input: root = []
        TreeNode root2 = null;
        //Output: []

        Solution ser = new Solution();
        Solution deser = new Solution();

        TreeNode ans1 = deser.deserialize(ser.serialize(root1));
        TreeNode ans2 = deser.deserialize(ser.serialize(root2));

        System.out.println(ans1);
        System.out.println(ans2);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

