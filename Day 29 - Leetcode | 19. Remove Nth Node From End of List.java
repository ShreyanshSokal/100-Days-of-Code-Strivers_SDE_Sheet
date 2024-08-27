/**
 * Problem: 19. Remove Nth Node From End of List
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Approach:
 * - Create a new ListNode `newHead` and set its next as `head` to handle edge cases.
 * - Use two pointers, `fast` and `slow`, both initialized at `newHead`.
 * - Move the `fast` pointer `n` steps ahead.
 * - Traverse the list with both `fast` and `slow` until `fast` reaches the end.
 * - Remove the nth node by adjusting the `next` pointer of the `slow` pointer.
 * - Return `newHead.next` which is the head of the modified list.
 *
 * Time Complexity (TC): O(L)
 * - We traverse the list twice in the worst case: 
 *   first to move the `fast` pointer `n` steps ahead, 
 *   and second to reach the end of the list.
 *   Therefore, the time complexity is linear with respect to the length of the list `L`.
 *
 * Space Complexity (SC): O(1)
 * - We use a constant amount of extra space for the pointers `newHead`, `fast`, and `slow`.
 *   Therefore, the space complexity is constant.
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode newHead = new ListNode(-1);
       newHead.next = head;

       ListNode fast = newHead, slow = newHead;

       for(int i = 1; i <= n; i++) {
            fast = fast.next;
       }

       while(fast.next != null) {
           fast = fast.next;
           slow = slow.next;
       }
       
       slow.next = slow.next.next;

       return newHead.next;
    }
}
