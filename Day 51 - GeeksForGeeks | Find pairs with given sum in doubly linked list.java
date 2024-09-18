/**
 * Problem: Find Pairs with a Given Sum in a Doubly Linked List
 * Link: [No specific link] (MEDIUM)
 *
 * This solution finds all unique pairs of nodes in a doubly linked list where the sum of their values equals a given target.
 * The approach uses two pointers, `left` starting from the head and `right` starting from the tail, to efficiently find the pairs.
 *
 * Approach:
 * - **Step 1:** Use two pointers: `left` initialized to the head and `right` initialized to the last node in the list.
 * - **Step 2:** Compute the sum of the values at `left` and `right`:
 *     - If the sum equals the target, store the pair, and move both pointers (`left` forward and `right` backward).
 *     - If the sum is greater than the target, move the `right` pointer backward to reduce the sum.
 *     - If the sum is less than the target, move the `left` pointer forward to increase the sum.
 * - **Step 3:** Continue this process until the `left` pointer meets or crosses the `right` pointer.
 * - **Step 4:** Return the list of pairs.
 *
 * Time Complexity: O(n) [Single traversal using two pointers]
 * Space Complexity: O(1) [Constant space excluding the result]
 */

class Solution {
    
    // Function to find all pairs with a given sum in the doubly linked list.
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // If the list has only one node, no pairs can be formed.
        if (head.next == null) return new ArrayList<ArrayList<Integer>>();
        
        // List to store the pairs.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        // Initialize two pointers: left starting from the head, and right from the tail.
        Node left = head, right = head;
        
        // Move `right` to the last node in the list.
        while (right.next != null) {
            right = right.next;
        }
        
        // Use two pointers to find pairs with the given sum.
        while (left != right) {
            // Calculate the sum of the values at the left and right pointers.
            int sum = left.data + right.data;
            
            // If the sum equals the target, store the pair and move both pointers.
            if (sum == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(left.data);  // Add left node's value.
                temp.add(right.data);  // Add right node's value.
                
                ans.add(temp);  // Add the pair to the result list.
                
                // If the left and right pointers are adjacent, break the loop.
                if (left.next == right) break;
                
                // Move `left` forward and `right` backward.
                left = left.next;
                right = right.prev;
            }
            // If the sum is greater than the target, move `right` backward.
            else if (sum > target) right = right.prev;
            
            // If the sum is less than the target, move `left` forward.
            else left = left.next;
        }
        
        // Return the list of pairs with the given sum.
        return ans;
    }
}
