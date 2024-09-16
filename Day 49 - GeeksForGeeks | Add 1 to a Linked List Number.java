/**
 * Problem: Add 1 to a Number Represented as Linked List (Custom)
 * Link: [No specific link] (MEDIUM)
 *
 * This solution increments a number represented as a linked list by 1. Each node in the linked list represents
 * a single digit of the number, and the least significant digit is at the end of the list. The goal is to add 1
 * to the number and return the modified linked list.
 *
 * Approach:
 * - **Step 1:** Recursively traverse the linked list to reach the last node (least significant digit).
 * - **Step 2:** If the last node has a value of 9, set it to 0 and propagate a carry of 1 to the previous node. 
 *              Otherwise, simply increment the node's value.
 * - **Step 3:** For each recursive call, handle the carry propagation up the list.
 * - **Step 4:** After the recursive call completes, check if the head node still has a carry. If so, 
 *              create a new node with a value of 1 and make it the new head of the list.
 *
 * Time Complexity: O(n) [One pass to traverse and update the linked list]
 * Space Complexity: O(n) [Recursive stack space in case of carry propagation]
 */

class Solution {
    
    // Helper function to recursively add 1 to the list starting from the least significant digit.
    int add(Node node) {
        // Base case: If it's the last node in the list.
        if (node.next == null) {
            if (node.data == 9) {
                node.data = 0;  // If it's 9, set it to 0 and propagate a carry.
                return 1;       // Return carry of 1.
            } else {
                node.data++;     // Otherwise, simply increment the value.
                return 0;        // No carry needed.
            }
        }
        
        // Recursive call to process the next node.
        int carry = add(node.next);
        
        // If there is a carry, handle the current node.
        if (carry > 0) {
            if (node.data == 9) {
                node.data = 0;   // If it's 9, set it to 0 and continue carry.
                return 1;        // Propagate carry.
            }
            node.data++;         // Otherwise, increment the value and no carry.
        }
        
        return 0;  // No carry to propagate.
    }
    
    // Main function to add 1 to the number represented by the linked list.
    public Node addOne(Node head) {
        // Call the helper function to add 1 starting from the head.
        int carry = add(head);
        
        // If there is still a carry after processing the entire list, we need a new head.
        if (carry > 0) {
            Node newHead = new Node(1);  // Create a new head node with value 1.
            newHead.next = head;         // Attach the current head as the next node.
            return newHead;              // Return the new head of the list.
        }
        
        return head;  // Return the original head if no new head is needed.
    }
}
