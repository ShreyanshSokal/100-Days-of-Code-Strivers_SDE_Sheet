/**
 * Problem: Flattening a Linked List
 * Link: https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1 {MEDIUM}
 *
 * Approach:
 * - The `flatten` function takes a linked list where each node has a `next` pointer and a `bottom` pointer.
 * - The `bottom` pointer is used to point to a linked list, and the goal is to flatten this multi-level linked list into a single-level sorted linked list.
 * - The `mergeTwoLists` function is used to merge two sorted linked lists.
 * - The `flatten` function is recursively called to flatten the list starting from the `next` node, then the current list is merged with the already flattened list.
 *
 * Time Complexity (TC): O(n * m)
 * - `n` is the number of nodes in the main list.
 * - `m` is the number of nodes in the sublist.
 * - Merging two lists is O(m), and flattening involves merging `n` times.
 *
 * Space Complexity (SC): O(1)
 * - No extra space is used other than pointers for merging and flattening.
 */

class Solution {
    
    // Function to merge two sorted linked lists
    Node mergeTwoLists(Node a, Node b) {
        
        Node temp, res;
        temp = res = new Node(-1); // Temporary dummy node
        
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom; // Move temp to the next position
        }
        
        // Attach the remaining part of the list that is not null
        if (a != null) temp.bottom = a;
        else temp.bottom = b;
        
        return res.bottom; // Return the merged list starting from res.bottom
    }
    
    // Function to flatten a linked list
    Node flatten(Node head) {
        
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null)
            return head;
        
        // Recursively flatten the remaining list
        Node returnedNode = flatten(head.next);
        
        // Merge the current list with the flattened list
        return mergeTwoLists(head, returnedNode);
    }
}
