import java.util.Stack;

class Solution {

    // Approach:
    // 1. To reverse the stack, use a recursive function `rev` that pops elements 
    //    and stores them in a temporary variable until the stack is empty.
    // 2. After the stack is empty, use `placeAtEnd` to reinsert the elements in reverse order.
    // 3. `placeAtEnd` recursively places each element at the bottom of the stack.

    // Time Complexity (TC): O(n^2)
    // In the worst case, each of the `n` elements is placed at the bottom, 
    // requiring O(n) operations each time.

    // Space Complexity (SC): O(n)
    // Due to the recursive call stack used by the `rev` and `placeAtEnd` functions.
    // If we ignore the recursive call stack space, we are using O(1) extra space for solving this problem.

    // Function to reverse the stack using recursion
    static void rev(Stack<Integer> s, Integer i) {
        if (s.size() == 0) {  // Base case: if the stack is empty, return
            return;
        }

        Integer cur = s.pop();  // Remove the top element
        rev(s, cur);  // Recur until the stack is empty
        placeAtEnd(s, cur);  // Place each element at the bottom of the stack
    }

    // Helper function to place an element at the bottom of the stack
    static void placeAtEnd(Stack<Integer> s, Integer i) {
        if (s.size() == 0) {  // Base case: if stack is empty, add element to bottom
            s.add(i);
            return;
        }

        Integer cur = s.pop();  // Temporarily remove the top element
        placeAtEnd(s, i);  // Recur to reach the bottom
        s.add(cur);  // Push the temporarily removed element back
    }

    // Main function to initiate the reverse operation
    static void reverse(Stack<Integer> s) {
        rev(s, -1);  // Start reversing the stack from the top
    }
}
