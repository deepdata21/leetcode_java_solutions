package com.leetcode.medium.minimum_height_trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    //A tree is an undirected graph in which any two vertices are connected by
    //exactly one path. In other words, any connected graph without simple cycles is a
    //tree.
    //
    // Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1
    //edges where edges[i] = [ai, bi] indicates that there is an undirected edge between
    //the two nodes ai and bi in the tree, you can choose any node of the tree as the
    //root. When you select a node x as the root, the result tree has height h. Among
    //all possible rooted trees, those with minimum height (i.e. min(h)) are called
    //minimum height trees (MHTs).
    //
    // Return a list of all MHTs' root labels. You can return the answer in any
    //order.
    //
    // The height of a rooted tree is the number of edges on the longest downward
    //path between the root and a leaf.
    //
    //
    // Example 1:
    //
    //
    //Input: n = 4, edges = [[1,0],[1,2],[1,3]]
    //Output: [1]
    //Explanation: As shown, the height of the tree is 1 when the root is the node
    //with label 1 which is the only MHT.
    //
    //
    // Example 2:
    //
    //
    //Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
    //Output: [3,4]
    //
    //
    //
    // Constraints:
    //
    //
    // 1 <= n <= 2 * 10⁴
    // edges.length == n - 1
    // 0 <= ai, bi < n
    // ai != bi
    // All the pairs (ai, bi) are distinct.
    // The given input is guaranteed to be a tree and there will be no repeated
    //edges.
    //
    //
    // Related Topics Depth-First Search Breadth-First Search Graph Topological
    //Sort 👍 6016 👎 260

//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //  Time Complexity: O(v) where v is the number of nodes
        //  Space Complexity: O(v) where v is the number of nodes
        //  Pattern: Topological Sort
        //  Pattern: Tree BFS
        //      1. Test edge cases with n < 2, e.g. 0 or 1
        //      2. Declare an ArrayList of (hash) sets to build
        //          an adjacency list for the given tree/graph
        //      3. Create an ArrayList to hold current leaf nodes
        //              (nodes with only one edge)
        //      4. Iterate over all the current leaf nodes and
        //          remove them (and their corresponding edges)
        //          from the list after processing is done;
        //          this will expose new leaf nodes (if any) to be
        //          processed in the next iteration
        //      5. Iteration ends when # of unprocessed (available) nodes <= 2
        //      6. NOTE: edges are preserved, at available nodes <= 2,
        //          we have only one edge between two nodes

        //  Test and deal with edge cases
        if (n < 2) {
            //  If n < 2 then all nodes are possible
            //      root nodes of the minimum height trees
            List<Integer> rootNodes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                rootNodes.add(i);
            }

            return rootNodes;
        }

        //  Declare an ArrayList of sets/hash sets
        List<Set<Integer>> neighborNodes = new ArrayList<>();

        //  Initialize the adjacency list by adding
        //      n nodes with empty hash sets
        for (int i = 0; i < n; i++) {
            neighborNodes.add(new HashSet<>());
        }

        //  Connect the nodes with edges
        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];

            //  Since a tree is an undirected graph
            //  Get the hash set at startNode from the neighborNodes list,
            //      then add the endNode to the hash set
            neighborNodes.get(startNode).add(endNode);
            //  Get the hash set at endNode from the neighborNodes list,
            //      then add the startNode to the hash set
            neighborNodes.get(endNode).add(startNode);
        }

        //  Declare and initialize the first layer of leaf nodes
        List<Integer> leafNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            //  Create a test to find leaf nodes
            //      with an if condition
            //  Only one node in the hash set means one edge
            if (neighborNodes.get(i).size() == 1) {
                //  If leaf node, add it to the leafNode ArrayList
                leafNodes.add(i);
            }
        }

        //  Iterate over all the nodes until # of nodes <= 2
        //      because

        //  So, declare and intialize a variable to keep track of
        //      nodes remaining available node
        int nodesAvailable = n;

        while (nodesAvailable > 2) {

            //  Update nodesAvailable by subtracting current # of leaf nodes
            nodesAvailable -= leafNodes.size();

            //  Declare the next layer of leaf nodes
            //      as an empty ArrayList
            List<Integer> nextLeafNodes = new ArrayList<>();

            for (int node : leafNodes) {

                //  Find and store the next node neighbor
                //      to the current leaf node using iterator
                int nextNeighborNode =
                        neighborNodes.get(node).iterator().next();

                //  Now remove the current leaf node as
                //      the neighbor of the nextNeighborNode,
                //      since the current leaf node is being
                //      processed in this iteration
                neighborNodes.get(nextNeighborNode).remove(node);

                //  Perform a test to find new leaf nodes
                //      for next iteration with an if condition
                if (neighborNodes.get(nextNeighborNode).size() == 1) {
                    //  If leaf node, add it to the leafNode ArrayList
                      nextLeafNodes.add(nextNeighborNode);
                }

                //  Update the leafNodes ArrayList for the
                //      next iteration with nextLeafNodes
                leafNodes = nextLeafNodes;
                //  if nodesAvailable <= 2, updated leafNodes (nextLeafNodes)
                //      won't participate in the next iteration.
                //      Hence, the iteration stops here in that case

            }
        }

        //  Remaning leaf nodes will be root nodes
        //      of minimum height trees
        return leafNodes;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example 1:
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        //  O/P: [1]
        System.out.println(solution.findMinHeightTrees(n, edges));

        System.out.println("---");
        // Example 2:
        n = 6;
        edges = new int[][] {{3,0},{3,1},{3,2},{3,4},{5,4}};
        //  O/P: [3,4]
        System.out.println(solution.findMinHeightTrees(n, edges));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

