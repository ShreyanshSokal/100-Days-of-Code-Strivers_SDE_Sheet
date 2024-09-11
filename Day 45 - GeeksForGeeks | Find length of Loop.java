/**
 * Problem: Length of Loop in Linked List (GeeksforGeeks)
 * Link: https://practice.geeksforgeeks.org/problems/find-length-of-loop/1 (MEDIUM)
 *
 * This solution finds the length of a loop in a given linked list. 
 * It detects if there is a loop and then counts the number of nodes in that loop.
 *
 * Approach:
 * - **Step 1:** Use two pointers, `slow` and `fast`, to detect a loop. Move `slow` by one step and `fast` by two steps.
 * - **Step 2:** If `slow` meets `fast`, there is a loop. Otherwise, return 0 indicating no loop.
 * - **Step 3:** Once a loop is detected, move both `head` and `slow` at the same pace to find the start of the loop.
 * - **Step 4:** After finding the start, traverse the loop to count the number of nodes and return that count.
 *
 * Time Complexity: O(n) [Two passes - one for detecting the loop, and one for counting nodes in the loop]
 * Space Complexity: O(1) [Only a few pointers used, no extra space]
 */

class Solution {
    
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {

        Node slow = head, fast = head;

        // Step 1: Use two pointers (slow and fast) to detect a loop.
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by 1 step.
            fast = fast.next.next;   // Move fast pointer by 2 steps.
            if (slow == fast) break; // If slow meets fast, a loop is detected.
        }

        // Step 2: If no loop is detected, return 0.
        if (fast == null || fast.next == null) return 0;

        // Step 3: Find the starting point of the loop by moving both head and slow pointers one step at a time.
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        // Now, head points to the start of the loop.

        int count = 0;
        // Step 4: Traverse the loop and count the number of nodes in it.
        do {
            head = head.next;   // Move through the loop.
            count++;            // Increment the count for each node in the loop.
        } while (head != slow); // Stop when we reach the starting point again.

        return count;  // Return the total number of nodes in the loop.
    }
}
