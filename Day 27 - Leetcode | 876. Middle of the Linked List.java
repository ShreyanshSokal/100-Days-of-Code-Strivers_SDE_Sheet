
/**
 * Problem: Find the Middle of the Linked List
 * The task is to find the middle node of a singly linked list.
 * If the list has an even number of nodes, return the second middle node.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;           // Value of the current node
 *     ListNode next;     // Pointer to the next node in the list
 *     ListNode() {}      // Default constructor
 *     ListNode(int val) { this.val = val; }                      // Constructor with node value
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Constructor with value and next node
 * }
 */

class Solution {
    
    // Function to find the middle node of the linked list
    public ListNode middleNode(ListNode head) {
        // Initialize two pointers: slow and fast
        ListNode slow = head, fast = head.next;

        // Initial attempt: Brute Force Approach (Commented Out)
        // In this approach, we would traverse the list to count the total number of nodes (len)
        // Then, traverse the list again up to the middle (len/2) and return that node as the middle.
        // while(slow != null)
        // {
        //     len ++;
        //     slow = slow.next;
        // }
        //
        // slow = head;
        // int mid = 0;
        // while(mid != len/2)
        // {
        //     mid++;
        //     slow = slow.next;
        // }
        // return slow;

        // Optimized Approach: Using Two Pointers (Slow and Fast)
        // - The fast pointer moves twice as fast as the slow pointer.
        // - When the fast pointer reaches the end of the list, the slow pointer will be at the middle.

        while(fast != null) {
            // Move the slow pointer one step forward
            slow = slow.next;

            // If fast reaches the end (odd number of nodes), return the slow pointer as the middle node
            if(fast.next == null) {
                System.out.println("fast next is null " + fast.val);
                return slow;
            }

            // Move the fast pointer two steps forward
            fast = fast.next.next;
        }

        // If the loop completes, the slow pointer is at the middle node
        return slow;
    }
}
/*

### Explanation:
- **Brute Force Approach** (Commented Out):
  - This approach involves two traversals of the linked list. The first traversal counts the number of nodes (`len`), and the second traversal moves to the middle node (`len/2`).
  - This approach has a time complexity of `O(n)` but requires two full traversals of the list.

- **Optimized Approach**:
  - This method uses the two-pointer technique (`slow` and `fast`). The `slow` pointer moves one step at a time, while the `fast` pointer moves two steps.
  - By the time the `fast` pointer reaches the end of the list, the `slow` pointer will be at the middle.
  - This approach only requires one traversal, making it more efficient with a time complexity of `O(n)` but only one pass through the list.

This solution highlights both the brute-force and optimized approaches, with explanations and comments to guide understanding.
  */
