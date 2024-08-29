/**
 * Problem: Reverse a Linked List
 * 
 * Approach:
 * - This method reverses a singly linked list iteratively.
 * - We initialize `newHead` to `null`, which will eventually point to the new head of the reversed list.
 * - As we traverse the original list, we store the next node in a temporary variable `next` to avoid losing reference.
 * - We then update the current node's `next` pointer to point to `newHead`.
 * - Move `newHead` to the current node, effectively building the reversed list as we go.
 * - Finally, move `head` to the next node in the original list and repeat the process until all nodes are reversed.
 * - Return `newHead` as the head of the reversed linked list.
 *
 * Time Complexity (TC): O(n)
 * - We traverse each node of the linked list exactly once.
 *
 * Space Complexity (SC): O(1)
 * - The reversal is done in place, so no additional space is used beyond a few pointers.
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode newHead = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        
        return newHead;
    }
}
```
