/**
 * Problem: Odd Even Linked List (LeetCode)
 * Link: https://leetcode.com/problems/odd-even-linked-list/ (MEDIUM)
 *
 * This solution rearranges a singly linked list so that all the nodes positioned at odd indices are grouped together,
 * followed by all the nodes positioned at even indices, while maintaining the relative order of the nodes.
 *
 * Approach:
 * - **Step 1:** Create two pointers, `odd` and `even`, initialized at the first and second nodes respectively.
 * - **Step 2:** Traverse the list, alternating between odd and even nodes. For each node, update the next pointers
 *   accordingly to group odd-indexed nodes together and even-indexed nodes together.
 * - **Step 3:** After traversing the list, connect the last odd node to the head of the even nodes to get the final reordered list.
 * - **Edge Case:** If the list is empty or has only one node, return the original list.
 *
 * Time Complexity: O(n) [Single pass through the linked list]
 * Space Complexity: O(1) [Reordering done in place without extra space]
 */

class Solution {
    
    // Function to rearrange nodes in an odd-even fashion.
    public ListNode oddEvenList(ListNode head) {

        // Step 1: Handle edge cases where the list has less than 2 nodes.
        if (head == null || head.next == null) return head;

        // Step 2: Initialize odd and even pointers, as well as their respective heads.
        ListNode odd = head, even = head.next, oddHead = odd, evenHead = even;

        // Step 3: Traverse the list and group odd and even indexed nodes.
        while (odd != null && even != null) {
            odd.next = even.next;            // Connect current odd node to the next odd node.
            if (even.next == null) break;    // Break if there are no more even nodes.
            even.next = even.next.next;      // Connect current even node to the next even node.

            // Move to the next odd and even nodes.
            odd = odd.next;
            even = even.next;
        }

        // Step 4: Traverse the odd list to find its last node.
        odd = oddHead;
        while (odd.next != null) {
            odd = odd.next;
        }

        // Step 5: Connect the last odd node to the head of the even list.
        odd.next = evenHead;

        // Return the reordered list with odd and even grouped together.
        return oddHead;
    }
}
