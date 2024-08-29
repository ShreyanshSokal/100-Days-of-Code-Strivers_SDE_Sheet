/**
 * Problem: Intersection of Two Linked Lists
 * Link: https://leetcode.com/problems/intersection-of-two-linked-lists/ {EASY}
 *
 * Approach:
 * - This method finds the intersection node of two singly linked lists using an optimal solution.
 * - We start with two pointers `a` and `b`, initialized to the heads of the two linked lists `headA` and `headB`.
 * - Both pointers traverse the lists simultaneously. If they reach the end of their respective lists without finding an intersection, they switch to the head of the other list.
 * - This allows both pointers to traverse an equal length by the time they either meet at the intersection or reach the end of both lists (null).
 * - If there is an intersection, the pointers will meet at the intersection node after switching.
 * - If no intersection exists, both pointers will reach the end of their lists (null) simultaneously, and `a` (or `b`) will be null.
 *
 * Time Complexity (TC): O(m + n)
 * - Both pointers traverse at most `m + n` nodes, where `m` and `n` are the lengths of the two linked lists.
 *
 * Space Complexity (SC): O(1)
 * - Only constant extra space is used for the two pointers.
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        while (a != b) {
            // If pointer `a` reaches the end of list A, switch it to the head of list B
            if (a == null) { 
                a = headB; 
                continue; 
            }
            // If pointer `b` reaches the end of list B, switch it to the head of list A
            if (b == null) { 
                b = headA; 
                continue; 
            }

            // Move both pointers forward by one node
            a = a.next;
            b = b.next;
        }

        return a; // Either returns the intersection node or null if no intersection exists
    }
}
