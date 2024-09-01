/**
 * Problem: Linked List Cycle II
 * Link: https://leetcode.com/problems/linked-list-cycle-ii/ {MEDIUM}
 *
 * Approach:
 * - The function `detectCycle` detects the node where a cycle begins in a linked list.
 * - It uses two pointers, `slow` and `fast`, which move at different speeds (slow moves one step, fast moves two steps).
 * - If there is a cycle, these pointers will meet inside the cycle.
 * - Once a cycle is detected, reset the `slow` pointer to the head and move both pointers one step at a time.
 * - The node where they meet again is the start of the cycle.
 *
 * Time Complexity (TC): O(n)
 * - The list is traversed multiple times but in a linear manner.
 * - Both pointers move through the list with linear time complexity.
 *
 * Space Complexity (SC): O(1)
 * - The algorithm uses a constant amount of extra space for pointers.
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        // Edge cases: If the list is empty or has only one node
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        // Detecting cycle using two pointers
        do {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
        } while (slow != fast);

        // Reset slow to head and find the start of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // The node where both pointers meet is the start of the cycle
    }
}
