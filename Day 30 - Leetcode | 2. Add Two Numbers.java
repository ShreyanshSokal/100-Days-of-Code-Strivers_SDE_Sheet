/**
 * Problem: 2. Add Two Numbers
 * Link: https://leetcode.com/problems/add-two-numbers/ {MEDIUM}
 *
 * Approach:
 * - We traverse both linked lists `l1` and `l2` simultaneously, adding their corresponding values along with any carry-over from the previous addition.
 * - The sum is split into two parts: 
 *   - `sum[0]` holds the current digit (units place).
 *   - `sum[1]` holds the carry (tens place).
 * - We create new nodes for each digit and link them to the result list.
 * - Continue the process for the remaining nodes in `l1` or `l2` after the simultaneous traversal is complete.
 * - If there's any carry left after processing both lists, it's added as the last node.
 * - Finally, we return `newHead.next` which points to the head of the resultant linked list.
 *
 * Time Complexity (TC): O(max(L1, L2))
 * - We traverse both linked lists `l1` and `l2` only once, so the time complexity depends on the length of the longer list.
 *
 * Space Complexity (SC): O(max(L1, L2))
 * - The space complexity is proportional to the length of the output linked list, which can be at most `max(L1, L2) + 1` due to the carry-over.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int[] sum = new int[2];

        ListNode newHead = new ListNode(-1), connector = newHead;

        while(l1 != null && l2 != null) {
            int curSum = l1.val + l2.val + sum[1];
            
            sum[0] = curSum % 10;
            sum[1] = curSum / 10;

            ListNode temp = new ListNode(sum[0]);
            connector.next = temp;
            connector = temp;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int curSum = l1.val + sum[1];
            
            sum[0] = curSum % 10;
            sum[1] = curSum / 10;

            ListNode temp = new ListNode(sum[0]);
            connector.next = temp;
            connector = temp;

            l1 = l1.next;
        }

        while(l2 != null) {
            int curSum = l2.val + sum[1];
            
            sum[0] = curSum % 10;
            sum[1] = curSum / 10;

            ListNode temp = new ListNode(sum[0]);
            connector.next = temp;
            connector = temp;

            l2 = l2.next;
        }

        if(sum[1] != 0) {
            connector.next = new ListNode(sum[1]);
        }

        return newHead.next;
    }
}
```
