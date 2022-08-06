//  Needs to work on intersection of linked lists

package com.leetcode.easy.intersection_of_two_linked_lists;

class ListNode {
    int data;
    ListNode next;

    ListNode (int data) {
        this.data = data;
    }
}

public class Solution {
    //Given the heads of two singly linked-lists headA and headB, return the node
    //at which the two lists intersect. If the two linked lists have no intersection at

    //all, return null.
    //
    // For example, the following two linked lists begin to intersect at node c1:
    //
    // The test cases are generated such that there are no cycles anywhere in the
    //entire linked structure.
    //
    // Note that the linked lists must retain their original structure after the
    //function returns.
    //
    // Custom Judge:
    //
    // The inputs to the judge are given as follows (your program is not given
    //these inputs):
    //
    //
    // intersectVal - The value of the node where the intersection occurs. This is 0
    // if there is no intersected node.
    // listA - The first linked list.
    // listB - The second linked list.
    // skipA - The number of nodes to skip ahead in listA (starting from the head)
    //to get to the intersected node.
    // skipB - The number of nodes to skip ahead in listB (starting from the head)
    //to get to the intersected node.
    //
    //
    // The judge will then create the linked structure based on these inputs and
    //pass the two heads, headA and headB to your program. If you correctly return the
    //intersected node, then your solution will be accepted.
    //
    //
    // Example 1:
    //
    //
    //Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2
    //, skipB = 3
    //Output: Intersected at '8'
    //Explanation: The intersected node's value is 8 (note that this must not be 0
    //if the two lists intersect).
    //From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [
    //5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3
    //nodes before the intersected node in B.
    //
    //
    // Example 2:
    //
    //
    //Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3,
    //skipB = 1
    //Output: Intersected at '2'
    //Explanation: The intersected node's value is 2 (note that this must not be 0
    //if the two lists intersect).
    //From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [
    //3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node
    //before the intersected node in B.
    //
    //
    // Example 3:
    //
    //
    //Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
    //Output: No intersection
    //Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it
    //reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
    //while skipA and skipB can be arbitrary values.
    //Explanation: The two lists do not intersect, so return null.
    //
    //
    //
    // Constraints:
    //
    //
    // The number of nodes of listA is in the m.
    // The number of nodes of listB is in the n.
    // 1 <= m, n <= 3 * 10⁴
    // 1 <= Node.val <= 10⁵
    // 0 <= skipA < m
    // 0 <= skipB < n
    // intersectVal is 0 if listA and listB do not intersect.
    // intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
    //
    //
    //
    //Follow up: Could you write a solution that runs in
    //O(m + n) time and use only
    //O(1) memory?
    //
    // Related Topics Hash Table Linked List Two Pointers 👍 10359 👎 971


    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//public class Solution {
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a_pointer = headA;
        ListNode b_pointer = headB;

        while (a_pointer != b_pointer) {

            a_pointer = a_pointer == null ? headB : a_pointer.next;
            b_pointer = b_pointer == null ? headA : b_pointer.next;

        }

        return a_pointer;

    }

    public static void main(String[] args) {
        //Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2
        //, skipB = 3
        //Output: Intersected at '8'
        //Explanation: The intersected node's value is 8 (note that this must not be 0
        //if the two lists intersect).
        //From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [
        //5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3
        //nodes before the intersected node in B.
        //
        //
        // Example 2:
        //
        //
        //Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3,
        //skipB = 1
        //Output: Intersected at '2'
        //Explanation: The intersected node's value is 2 (note that this must not be 0
        //if the two lists intersect).
        //From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [
        //3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node
        //before the intersected node in B.
        //
        //
        // Example 3:
//        int[] listA = {2,6,4};
        int[] listA = {1,9,1,2,4};
//        int[] listB = {1,5};
        int[] listB = {3,2,4};
        //  O/P: No intersection

        ListNode head3A = new ListNode(listA[0]);
        ListNode current3A = head3A;

        for (int i = 1; i < listA.length; i++) {

            ListNode node = new ListNode(listA[i]);

            current3A.next = node;
            current3A = node;
        }

        ListNode head3B = new ListNode(listB[0]);
        ListNode current3B = head3B;

        for (int i = 1; i < listB.length; i++) {

            ListNode node = new ListNode(listB[i]);

            current3B.next = node;
            current3B = node;
        }

        System.out.println(getIntersectionNode(head3A,head3B));
   }
}
//leetcode submit region end(Prohibit modification and deletion)

