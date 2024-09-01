/**
 * Problem: Palindrome Linked List
 * Link: https://leetcode.com/problems/palindrome-linked-list/ {EASY}
 *
 * Approach:
 * - The function `isPalindrome` checks whether a given singly linked list is a palindrome.
 * - First, we determine the length of the list.
 * - We then find the middle of the list, and reverse the second half of the list.
 * - Finally, we compare the values from the start of the list and the reversed second half to check if they are identical.
 * - If all values match, the list is a palindrome; otherwise, it is not.
 * 
 * Helper Methods:
 * - `reverse(ListNode node)`: Reverses the linked list starting from the given node and returns the new head.
 *
 * Time Complexity (TC): O(n)
 * - The list is traversed multiple times: once to determine its length, once to find the middle, and once to compare the halves.
 * - All operations are linear with respect to the number of nodes `n`.
 *
 * Space Complexity (SC): O(1)
 * - The algorithm uses a constant amount of extra space for pointers.
 */

class Solution {

    // Helper function to reverse a linked list
    ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode temp = head;

        // Edge cases: if the list is empty or has only one node
        if (head == null || head.next == null) return true;

        // Calculate the length of the linked list
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // Split the list into two halves
        ListNode left = head, right = head;
        int it = 0;
        while (it != len / 2) {
            right = right.next;
            it++;
        }

        // Adjust the right pointer for odd-length lists
        if (len % 2 != 0) right = right.next;

        // Reverse the second half of the list
        right = reverse(right);

        // Compare the two halves
        while (left != null && right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
