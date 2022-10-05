package com.leetcode.medium.lowest_common_ancestor_of_a_binary_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    //Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
    //in the tree.
    //
    // According to the definition of LCA on Wikipedia: “The lowest common ancestor
    //is defined between two nodes p and q as the lowest node in T that has both p
    //and q as descendants (where we allow a node to be a descendant of itself).”
    //
    //
    // Example 1:
    //
    //
    //Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    //Output: 3
    //Explanation: The LCA of nodes 5 and 1 is 3.
    //
    //
    // Example 2:
    //
    //
    //Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    //Output: 5
    //Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
    //of itself according to the LCA definition.
    //
    //
    // Example 3:
    //
    //
    //Input: root = [1,2], p = 1, q = 2
    //Output: 1
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
    // p and q will exist in the tree.
    //
    //
    // Related Topics Tree Depth-First Search Binary Tree 👍 12520 👎 307


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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //  Time Complexity: O(n)
        //  Space Complexity: O(1) when not considering the recursive call stack
        //                   O(h) when considering the recursive call stack
        //                      where h is the height of the tree

        //  Recursive Approach:
        //      High level Idea -
        //                  Step 1: Look for given nodes (p and q) following
        //                      left and right subtrees starting from the root;
        //                      use recursive calls
        //                  Step 2: If a node (p OR q) is found,
        //                          return not null to its parent node
        //                  Step 3: If no nodes found in a subtree returns null
        //                          to the parent node
        //                  Step 4: Check different possibilite using if
        //                          statements (see the code below)

        //  Base case
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        //  Recursive calls to search the left subtree
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);

        //  Recursive calls to search the right subtree
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        //  If none of the left and right subtrees is null
        //      return root as the answer
        if (leftNode != null && rightNode != null) {
            return root;
        }

        //  If both of the left and right subtrees are null
        //      return null as the answer
        if (leftNode == null && rightNode == null) {
            return null;
        }

        //  If leftNode is null (and rightNode is not null)
        //      returns the rightNode as the answer,
        //  Or, if rightNode is null (and leftNode is not null)
        //      returns the leftNode as the answer,
        //  Since, we already tested other possibilities
        //      in the previous if statements
        return leftNode != null ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        //Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1

        //  Building the tree
        TreeNode root = new TreeNode(3);
        TreeNode p = root.left = new TreeNode(5);   //  Also given TreeNode p
        TreeNode q = root.right = new TreeNode(1);  //  Also given TreeNode q
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        //  O/P: 3

        System.out.println("---");
        // Example 2:
        //Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        //  Building the tree
        root = new TreeNode(3);
        p = root.left = new TreeNode(5);   //  Also given TreeNode p
        root.right = new TreeNode(1);  //  Also given TreeNode q
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        q = root.left.right.right = new TreeNode(4);
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        //  O/P: 5

        System.out.println("---");
        // Example 3:
        //Input: root = [1,2], p = 1, q = 2
        //  Building the tree
        p = root = new TreeNode(1);//  Also given TreeNode p
        q = root.left = new TreeNode(2);  //  Also given TreeNode q
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        //  O/P: 1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

