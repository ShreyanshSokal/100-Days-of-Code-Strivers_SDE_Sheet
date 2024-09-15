/**
 * Problem: Sort a Linked List of 0s, 1s, and 2s (Custom)
 * Link: [No specific link] (MEDIUM)
 *
 * This solution sorts a linked list consisting of only 0s, 1s, and 2s. 
 * The list is segregated in-place such that all 0s appear first, followed by 1s, and then all 2s.
 *
 * Approach:
 * - **Step 1:** Create three dummy nodes (`zeroHead`, `oneHead`, `twoHead`) for maintaining separate lists for 0s, 1s, and 2s.
 * - **Step 2:** Traverse the original list and attach nodes to the respective lists based on their values.
 * - **Step 3:** Connect the three lists together by linking the end of the 0s list to the 1s list and the 1s list to the 2s list.
 * - **Step 4:** Cut off the tail of the 2s list by setting `two.next = null` to avoid loops.
 *
 * Time Complexity: O(n) [Single pass to traverse and sort the linked list]
 * Space Complexity: O(1) [Sorting done in-place without using extra memory for sorting]
 */

class Solution {
    
    // Function to sort a linked list of 0s, 1s, and 2s.
    static Node segregate(Node head) {
        
        // Step 1: Create dummy heads for 0s, 1s, and 2s lists.
        Node zeroHead = new Node(-1), oneHead = new Node(-1), twoHead = new Node(-1);
        Node zero = zeroHead, one = oneHead, two = twoHead, temp = head;

        // Step 2: Traverse the list and segregate nodes into their respective lists.
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        // Step 3: Connect the 0s list to the 1s list, and the 1s list to the 2s list.
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;

        // Step 4: Cut off the loop by setting the tail of the 2s list to null.
        two.next = null;

        // Return the sorted list starting from zeroHead's next node.
        return zeroHead.next;
    }
}
