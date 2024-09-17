/**
 * Problem: Delete All Occurrences of a Given Key in Doubly Linked List (Custom)
 * Link: [No specific link] (MEDIUM)
 *
 * This solution removes all occurrences of a given value (key) `x` from a doubly linked list. 
 * It updates the list such that no nodes contain the value `x` and adjusts the pointers accordingly.
 *
 * Approach:
 * - **Step 1:** Iterate through the doubly linked list and for each node:
 *     - If the node’s value is not `x`, proceed to the next node.
 *     - If the node’s value is `x`, delete the node using a helper function `delete`.
 * - **Step 2:** In the `delete` function:
 *     - If the node is at the head (i.e., `prev == null`), update the head pointer to the next node.
 *     - If the node is at the end (i.e., `next == null`), update the previous node to have no next node.
 *     - For nodes in the middle, update the `prev` and `next` pointers to bypass the node being deleted.
 * - **Step 3:** Return the updated head of the linked list after all deletions.
 *
 * Time Complexity: O(n) [Single traversal of the doubly linked list]
 * Space Complexity: O(1) [In-place modification of the list]
 */

class Solution {
    
    // Helper function to delete a specific node from the doubly linked list.
    static Node delete(Node node) {
        // Case 1: The node is the only element in the list.
        if (node.prev == null && node.next == null) {
            return null;  // List becomes empty.
        }
        
        // Case 2: The node is at the head of the list.
        if (node.prev == null) {
            Node nextNode = node.next;  // Move head to the next node.
            node.next = null;  // Disconnect the current node.
            return nextNode;   // Return the new head.
        }
        // Case 3: The node is at the end of the list.
        else if (node.next == null) {
            Node prevNode = node.prev;  // Move the previous node to the end.
            node.prev = null;  // Disconnect the current node.
            prevNode.next = null;  // The previous node becomes the new end.
            return null;  // No further updates needed.
        }
        // Case 4: The node is in the middle of the list.
        else {
            Node prevNode = node.prev;  // Get the previous node.
            prevNode.next = node.next;  // Update previous node's next to bypass the current node.
            node.next = null;  // Disconnect the current node.
            return prevNode.next;  // Return the next node after deletion.
        }
    }
    
    // Main function to delete all occurrences of `x` from the list.
    static Node deleteAllOccurOfX(Node head, int x) {
        Node newHead = null;  // To store the new head of the list.
        
        // Iterate through the list.
        while (head != null) {
            // If the current node does not contain the value `x`, move to the next.
            if (head.data != x) {
                newHead = (newHead == null) ? head : newHead;  // Set the new head if not already set.
                head = head.next;  // Move to the next node.
            }
            // If the current node contains the value `x`, delete it.
            else {
                head = delete(head);  // Delete the node and update head.
            }
        }
        
        return newHead;  // Return the new head of the modified list.
    }
}
