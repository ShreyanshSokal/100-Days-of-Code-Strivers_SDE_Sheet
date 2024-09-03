/**
 * Problem: Rotate List
 * Link: https://leetcode.com/problems/rotate-list/ {MEDIUM}
 *
 * Approach:
 * - The `rotateRight` function rotates a linked list to the right by `k` places.
 * - First, we calculate the length of the list. Then, we link the last node to the head, creating a circular list.
 * - We determine the effective rotations needed by computing `k % len`, as rotating by the list length results in the same list.
 * - We then traverse to the node that will become the new tail, break the circular link, and set the appropriate node as the new head.
 *
 * Time Complexity (TC): O(n)
 * - We traverse the entire list to determine its length and again to position the new head.
 *
 * Space Complexity (SC): O(1)
 * - No extra space is used except for a few pointers.
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        // EDGE CASE
        if (head == null || head.next == null || k == 0) return head;

        ListNode newHead = head, temp = head;
        int len = 1;

        // Calculate the length of the list
        while (temp.next != null) {
            len++;
            temp = temp.next;
        } 

        // Link the last node to the head to form a circular list
        temp.next = head;

        // Calculate the number of effective rotations
        int cur = k % len;

        // Traverse to the new tail of the rotated list
        while ((len - cur) != 0) {
            len--;
            newHead = newHead.next;
            temp = temp.next;
        }

        // Break the circular link
        temp.next = null;

        // Return the new head of the rotated list
        return newHead;
    }
}
