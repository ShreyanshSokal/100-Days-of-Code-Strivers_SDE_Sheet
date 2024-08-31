/**
 * Problem: Linked List Cycle
 * Link: https://leetcode.com/problems/linked-list-cycle/ {EASY}
 *
 * Approach:
 * - This method detects if a cycle exists in a singly linked list using the two-pointer technique, also known as Floyd's Cycle Detection Algorithm.
 * - We use two pointers, `slow` and `fast`. The `slow` pointer moves one step at a time, while the `fast` pointer moves two steps at a time.
 * - If there is a cycle, the `fast` pointer will eventually meet the `slow` pointer.
 * - Once a cycle is detected, to find the start of the cycle, we reset the `slow` pointer to the head of the list.
 * - Both pointers then move one step at a time. The point at which they meet is the start of the cycle.
 *
 * Time Complexity (TC): O(n)
 * - In the worst case, both pointers will traverse the list, which takes O(n) time where `n` is the number of nodes in the linked list.
 *
 * Space Complexity (SC): O(1)
 * - Only constant extra space is used for the two pointers.
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        // Detect cycle using Floyd's Cycle Detection Algorithm
        do {
            // If fast pointer reaches null or end of the list, there is no cycle
            if (fast == null || fast.next == null) return false;

            // Move fast pointer by two steps and slow pointer by one step
            fast = fast.next.next;
            slow = slow.next;

        } while (fast != slow);

        // To find the start of the cycle
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return true; // Cycle exists in the linked list
    }
}
