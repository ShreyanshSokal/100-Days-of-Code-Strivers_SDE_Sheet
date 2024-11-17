/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    /**
     * Intuition:
     * - Preorder traversal follows the order: Root -> Left -> Right.
     * - Use recursion to process the root node, then traverse the left subtree, and finally the right subtree.
     * - A helper function (`pre`) is used to recursively add values to the result list.
     * 
     * Time Complexity:
     * - O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
     * 
     * Space Complexity:
     * - O(n) in the worst case, due to the recursion stack for a skewed tree.
     * - O(log n) in the best case for a balanced binary tree.
     */

    // Helper function for recursive preorder traversal
    static void pre(TreeNode root, List<Integer> ans) {
        if (root == null) return; // Base case: if node is null, return
        
        ans.add(root.val);       // Process the current node
        pre(root.left, ans);     // Recur for the left subtree
        pre(root.right, ans);    // Recur for the right subtree
    }

    // Main function for preorder traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>(); // List to store the result
        pre(root, ans);                         // Call helper function
        return ans;                             // Return the result
    }
}
