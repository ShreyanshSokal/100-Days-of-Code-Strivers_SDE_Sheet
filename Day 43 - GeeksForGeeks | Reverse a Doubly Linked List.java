/**
 * Problem: Reverse a Doubly Linked List
 * Link: [Link to problem on relevant platform] (MEDIUM)
 *
 * This solution reverses a given doubly linked list (DLL) in place and returns the new head of the reversed list.
 * The algorithm swaps the `next` and `prev` pointers of each node in the list to reverse the direction.
 *
 * Approach:
 * - Initialize `prev` as null and `cur` as the current head of the list.
 * - Traverse the list while adjusting the `next` and `prev` pointers of each node:
 *   - Set `head.next` to `prev` (reversing the link).
 *   - Set `head.prev` to the next node (to maintain the bidirectional nature).
 *   - Move `prev` and `head` forward through the list, keeping track of `next` for future iteration.
 * - Once all nodes are processed, return `prev` as the new head of the reversed list.
 *
 * Time Complexity: O(n) [Single traversal of the doubly linked list]
 * Space Complexity: O(1) [In-place modification of the list]
 */

class Solution {

    // Helper recursive function to reverse the DLL (original approach leading to stack overflow).
    DLLNode f(DLLNode node, DLLNode prev) {
        if (node == null) return prev;

        DLLNode cur = f(node.next, node);
        node.prev = cur;
        node.next = prev;

        return cur;
    }

    // Main function to reverse a doubly linked list iteratively.
    public DLLNode reverseDLL(DLLNode head) {
        // Initialize pointers to reverse the list iteratively.
        DLLNode prev = null;
        DLLNode cur = head;
        DLLNode next = head != null ? head.next : null;  // Handle the case where head is null.

        // Traverse through the list, swapping `next` and `prev` pointers.
        while (head != null) {
            head.next = prev;  // Reverse the `next` pointer.
            head.prev = next;  // Reverse the `prev` pointer.

            // Move the pointers forward for the next iteration.
            prev = head;
            head = next;
            if (next == null) break;  // If next is null, we've reached the end.
            next = next.next;
        }

        // Return the new head of the reversed list.
        return prev;
    }
}
