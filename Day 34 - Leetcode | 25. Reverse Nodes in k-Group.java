/**
 * Problem: Reverse Nodes in k-Group
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/ {HARD}
 *
 * Approach:
 * - The function `reverseKGroup` reverses nodes in a linked list in groups of size `k`.
 * - First, we check if the size of the list is less than `k`, in which case we return the head as it is.
 * - The list is then divided into chunks of size `k`, and each chunk is reversed individually.
 * - The `reverse` method is used to reverse a given chunk.
 * - After reversing each chunk, the pointers are adjusted accordingly to maintain the integrity of the list.
 * - The process continues until all chunks of size `k` are reversed.
 * 
 * Helper Methods:
 * - `getKthNode(ListNode head, int k)`: Returns the k-th node in the list, or null if the list has fewer than `k` nodes.
 * - `reverse(ListNode head)`: Reverses the entire list starting from the given head node.
 *
 * Time Complexity (TC): O(n)
 * - Each node is processed a constant number of times, leading to O(n) time complexity where `n` is the number of nodes in the list.
 *
 * Space Complexity (SC): O(1)
 * - The algorithm only uses a constant amount of extra space for pointers.
 */

class Solution {

    // Helper function to get the k-th node from the current node
    ListNode getKthNode(ListNode head, int k) {
        while (k > 1) {
            if (head == null) return null;
            head = head.next;
            k--;
        }
        return head;
    }

    // Helper function to reverse the linked list from the given head
    ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // Function to reverse nodes in k-group
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = new ListNode(-1), cur = head;

        // Check if the list has fewer than k nodes
        if (getKthNode(cur, k) == null) return head;

        // Calculate the length of the list
        cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        // If length is less than k, return the head as is
        if (len < k) return head;

        // Reverse nodes in k-sized groups
        cur = head;
        while (len >= k) {
            ListNode temp = cur;
            ListNode kthNode = getKthNode(cur, k);

            // If starting the first reverse, adjust head to new head (kthNode)
            if (temp == head) head = kthNode;

            // Find the next pointer for the next group
            ListNode next = kthNode.next;
            kthNode.next = null;

            // Reverse the current k-sized group
            reverse(cur);
            prev.next = kthNode;
            temp.next = next;

            // Move pointers to the next group
            prev = temp;
            cur = next;
            len -= k;
        }

        return head;
    }
}
