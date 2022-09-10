package com.leetcode.medium.clone_graph;

// Needs to implement to toString method to see output
// cloneGraph method works

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(ArrayList<Node> _neighbors) {
        neighbors = _neighbors;
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    //Given a reference of a node in a connected undirected graph.
    //
    // Return a deep copy (clone) of the graph.
    //
    // Each node in the graph contains a value (int) and a list (List[Node]) of its
    //neighbors.
    //
    //
    //class Node {
    //    public int val;
    //    public List<Node> neighbors;
    //}
    //
    //
    //
    //
    // Test case format:
    //
    // For simplicity, each node's value is the same as the node's index (1-indexed)
    //. For example, the first node with val == 1, the second node with val == 2, and
    //so on. The graph is represented in the test case using an adjacency list.
    //
    // An adjacency list is a collection of unordered lists used to represent a
    //finite graph. Each list describes the set of neighbors of a node in the graph.
    //
    // The given node will always be the first node with val = 1. You must return
    //the copy of the given node as a reference to the cloned graph.
    //
    //
    // Example 1:
    //
    //
    //Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
    //Output: [[2,4],[1,3],[2,4],[1,3]]
    //Explanation: There are 4 nodes in the graph.
    //1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
    //2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
    //3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
    //4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
    //
    //
    // Example 2:
    //
    //
    //Input: adjList = [[]]
    //Output: [[]]
    //Explanation: Note that the input contains one empty list. The graph consists
    //of only one node with val = 1 and it does not have any neighbors.
    //
    //
    // Example 3:
    //
    //
    //Input: adjList = []
    //Output: []
    //Explanation: This an empty graph, it does not have any nodes.
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes in the graph is in the range [0, 100].
    // 1 <= Node.val <= 100
    // Node.val is unique for each node.
    // There are no repeated edges and no self-loops in the graph.
    // The Graph is connected and all nodes can be visited starting from the given
    //node.
    //
    //
    // Related Topics Hash Table Depth-First Search Breadth-First Search Graph 👍 66
    //69 👎 2781


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

//class Solution {
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        //  HashMap/HashTable to map given (graph) node to the
        //      cloned node as value
        //  To avoid cycles and keep track of visited node
        Map<Node, Node> visitedNodes = new HashMap<>();

        //  Create a queue to make use a FIFO data structure
        Queue<Node> bfsQueue = new LinkedList<>();

        //  Add the given node as the first element of
        //      the queue
        bfsQueue.offer(node);

        //  Add the given node as key, AND
        //      its clone as value
        visitedNodes.put(node, new Node(node.val, new ArrayList<>()));

        //  while loop for BFS
        while (!bfsQueue.isEmpty()) {

            //  Remove and save the current node from the front
            //      REMEMBER: First In First Out
            Node currentNode = bfsQueue.poll();

            //  Loop through all the neighbors
            //     of the current node
            for (Node currentNeighbor : currentNode.neighbors) {
                //  Check if the map of visited nodes is empty
                if (!visitedNodes.containsKey(currentNeighbor)) {
                    //  If map not empty, add the current neighbor
                    //      (and its clone) of the current node to the map
                    visitedNodes.put(currentNeighbor,
                            new Node(currentNeighbor.val, new ArrayList<>()));

                    //  And, add current neighbor the queue
                    bfsQueue.offer(currentNeighbor);
                }

                //  Update the cloned neighbors' list
                //      using the current node
                visitedNodes.get(currentNode).neighbors.add(
                        visitedNodes.get(currentNeighbor));
            }
        }

        //  Return the cloned node from the visitedNode map,
        //      which is the value associated with the given node
        //      put as key
        return visitedNodes.get(node);
    }

    public static void main(String[] args) {

        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        // Example 1:
        // Input: adjList = [[2,4],[1,3],[2,4],[1,3]];
        //  O/P: [[2,4],[1,3],[2,4],[1,3]]

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println(cloneGraph(node1).val);
        System.out.println(cloneGraph(node1).neighbors.get(0).val);
        System.out.println(cloneGraph(node1).neighbors.get(1).val);

        // Example 2:
        //Input: adjList = [[]]
        //  O/P: [[]]

        Node nodeb1 = new Node(new ArrayList<>());
        System.out.println(cloneGraph(nodeb1).val);

        // Example 3:
        //Input: adjList = []
        //  O/P: []

        Node nodec1 = new Node();
        System.out.println(cloneGraph(nodec1).val);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

