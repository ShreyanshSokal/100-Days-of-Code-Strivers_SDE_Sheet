// Problem: 206. Reverse Linked List
// The task is to reverse a singly linked list, where the input is the head of the list and the output is the head of the reversed list.

class Solution {
    
    // Recursive Approach
    // This function recursively reverses the linked list.
    public ListNode reverseList(ListNode head) {
        
        // Base case: If the list is empty or has only one node, return the head as it is.
        if(head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);
        
        // The node that follows head will now point back to head
        ListNode headNext = head.next;
        headNext.next = head;

        // Set the next of the current head to null as it becomes the new tail
        head.next = null;        
        
        // Return the new head of the reversed list
        return newHead;
    }
}

// ### Explanation:
// - **Recursive Approach**:
//   - This approach uses recursion to reverse the linked list.
//   - The base case checks if the `head` is `null` or if it’s the last node (`head.next == null`), in which case the function returns `head`.
//   - The recursive call `reverseList(head.next)` will reverse all nodes following the current `head`.
//   - After the recursive call returns, the next node (`head.next`) is adjusted to point back to the current `head`.
//   - Finally, the `head.next` is set to `null` to make it the new tail of the reversed list, and the new head of the reversed list is returned.

// This solution effectively demonstrates how to reverse a linked list using a recursive approach, with clear explanations for each step.
