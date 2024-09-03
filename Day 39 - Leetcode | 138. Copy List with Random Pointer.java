/**
 * Problem: Copy List with Random Pointer (LeetCode)
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/ (MEDIUM)
 *
 * This code creates a deep copy of a linked list where each node contains an additional random pointer,
 * pointing to any random node within the list or null. 
 *
 * Approach:
 * 1. Create a map to hold the mapping between the original nodes and their copies.
 * 2. Iterate through the original list, create a copy of each node, and store it in the map.
 * 3. Iterate through the list again to set the `next` and `random` pointers for the copied nodes using the map.
 * 4. Return the head of the copied list, which is obtained from the map.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) [for the map to store node mappings]
 */

class Solution {
    public Node copyRandomList(Node head) {
        // Step 1: Create a map to hold the mapping of original nodes to their copies.
        Node node = head;
        Map<Node, Node> map = new HashMap<>();

        // Step 2: Create new nodes and store them in the map.
        while (node != null) {
            Node temp = new Node(node.val);
            map.put(node, temp);
            node = node.next;
        }

        // Step 3: Iterate through the list again to set the next and random pointers.
        node = head;
        while (node != null) {
            Node temp = map.get(node);
            temp.next = map.get(node.next);
            temp.random = map.getOrDefault(node.random, null);
            node = node.next;
        }

        // Step 4: Return the head of the copied list.
        return map.get(head);
    }
}
