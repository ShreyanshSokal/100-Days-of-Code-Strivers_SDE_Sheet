/**
 * Problem: Palindrome Linked List (LeetCode)
 * Link: https://leetcode.com/problems/palindrome-linked-list/ (EASY)
 *
 * This solution checks whether a singly linked list is a palindrome by reversing the second half of the list 
 * and comparing it with the first half.
 *
 * Approach:
 * - **Step 1:** Find the length of the linked list.
 * - **Step 2:** Split the list into two halves. If the length is odd, ignore the middle element.
 * - **Step 3:** Reverse the second half of the list.
 * - **Step 4:** Compare the first half and the reversed second half of the list.
 * - **Step 5:** If all corresponding values match, the list is a palindrome.
 *
 * Time Complexity: O(n) [Two traversals of the list - one for length calculation, one for comparison]
 * Space Complexity: O(1) [In-place operations, no additional space used except for a few pointers]
 */

class Solution {

    // Helper function to reverse a linked list.
    ListNode reverse(ListNode node) {
        ListNode prev = null;
        // Traverse the list and reverse the pointers.
        while (node != null) {
            ListNode next = node.next; // Store the next node.
            node.next = prev;          // Reverse the current node's pointer.
            prev = node;               // Move the prev pointer forward.
            node = next;               // Move the current node to the next node.
        }
        return prev;  // Return the new head of the reversed list.
    }

    // Main function to check if the linked list is a palindrome.
    public boolean isPalindrome(ListNode head) {

        int len = 0;
        ListNode temp = head;

        // Edge cases: if the list is empty or has only one node, it's a palindrome.
        if (head == null || head.next == null) return true;

        // Step 1: Calculate the length of the linked list.
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        ListNode left = head, right = head;
        int it = 0;

        // Step 2: Move `right` to the middle of the list.
        while (it != len / 2) {
            right = right.next;
            it++;
        }

        // Step 3: If the list has an odd length, skip the middle element.
        if (len % 2 != 0) right = right.next;

        // Step 4: Reverse the second half of the list.
        right = reverse(right);

        // Step 5: Compare the first half and the reversed second half.
        while (left != null && right != null) {
            // If the values don't match, it's not a palindrome.
            if (left.val != right.val) return false;

            // Move both pointers forward.
            left = left.next;
            right = right.next;
        }

        return true;  // If all values match, the list is a palindrome.
    }
}
