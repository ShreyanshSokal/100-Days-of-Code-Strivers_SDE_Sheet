// Day 28: Problem - 21. Merge Two Sorted Lists

// Problem Link: https://leetcode.com/problems/merge-two-sorted-lists

/**
 * Problem: Merge Two Sorted Lists
 * The task is to merge two sorted linked lists into one sorted linked list.
 * The result should be a new list that consists of the nodes of the two input lists in sorted order.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;          // Value of the current node
 *     ListNode next;    // Pointer to the next node in the list
 *     ListNode() {}     // Default constructor
 *     ListNode(int val) { this.val = val; }                         // Constructor with node value
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Constructor with value and next node
 * }
 */

class Solution {
    
    // Previous attempt with an additional add() method (Commented Out)
    // This approach used an additional method to append nodes to a new list.
    // The logic involves iterating through both lists and selecting the smaller node 
    // to add to the resulting merged list. 
    // However, this method was less efficient due to the extra add() method call.
    
    // static void add(ListNode head, ListNode newN){
    //     ListNode newNode= new ListNode(newN.val);
    //     ListNode t=head;
    //     if(head==null) head=newNode;
    //     else{
    //         while(t.next != null){
    //             t=t.next;
    //         }
    //         t.next = newNode;
    //     }
    // }

    
    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        
        // Create a dummy node to serve as the starting point of the merged list
        ListNode head = new ListNode(-1);
        ListNode prev = head;

        // Traverse both lists and merge them by comparing values
        while(first != null && second != null) {
            if(first.val < second.val) {
                prev.next = first;
                first = first.next;
            } else {
                prev.next = second;
                second = second.next;
            }
            prev = prev.next;
            // System.out.println("prev " + prev.val + " first = " + first.val + " second = " + second);
        }

        // If there are remaining nodes in the first list, append them
        if(first != null) {
            prev.next = first;
        }

        // If there are remaining nodes in the second list, append them
        if(second != null) {
            prev.next = second;
        }

        // Return the merged list, skipping the dummy node
        return head.next;
        

        // Previous approach using the add() method (Commented Out)
        // The following code was used in an earlier attempt to merge the lists:
        // 
        // ListNode head = new ListNode(-1);
        // 
        // while(first != null && second != null) {
        //     if(first.val < second.val) {
        //         add(head, first);
        //         first = first.next;
        //     } else {
        //         add(head, second);
        //         second = second.next;
        //     }
        // }
        // 
        // while(first != null) {
        //     add(head, first);
        //     first = first.next;
        // }
        // 
        // while(second != null) {
        //     add(head, second);
        //     second = second.next;
        // }
        // 
        // return head.next;
    }
}


// Example lists: 
// 1 -> 2 -> 4 
// 1 -> 3 -> 4

// The merged list should be:
// -1 -> 1 -> 1 -> 2 -> 3 -> 4 -> 4

// The optimized approach involves directly manipulating the pointers
// without the need for an additional add() method, resulting in a more efficient solution.




// ### Explanation:
// - **Problem**:
//   - We need to merge two sorted linked lists into one sorted linked list.
//   - The input lists are singly-linked and sorted in non-decreasing order.

// - **Optimal Approach**:
//   - We use a dummy node (`head`) to start the merged list.
//   - We compare the values of the nodes from the two lists (`first` and `second`) and link the smaller one to the merged list.
//   - This continues until one of the lists is exhausted, after which we link any remaining nodes from the other list.
//   - Finally, we return the merged list, starting from the node after the dummy node.

// - **Previous Approach** (Commented Out):
//   - In the earlier version, we used an additional method (`add`) to append nodes to the merged list.
//   - However, this method was less efficient due to the extra overhead of creating new nodes and method calls.

// This code and explanation reflect both the thought process and the optimization that led to a more efficient solution for merging two sorted linked lists.
