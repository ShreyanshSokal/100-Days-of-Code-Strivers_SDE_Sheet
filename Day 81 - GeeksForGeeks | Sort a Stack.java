class GfG {
    
    // Approach:
    // 1. Use an auxiliary stack (s1) to help sort the main stack (s).
    // 2. For each element in the main stack (s):
    //    - Pop the top element from s and temporarily store it.
    //    - Move all elements from s1 back to s that are smaller than the current element to maintain order.
    //    - Push the current element into s1.
    // 3. Finally, transfer all elements from s1 back to s, resulting in a sorted stack in ascending order.
    
    // Time Complexity (TC): O(n^2)
    // Due to the nested loop where, in the worst case, each element may have to be moved between stacks multiple times.

    // Space Complexity (SC): O(n)
    // An additional stack (s1) is used, which can hold all elements from the original stack.

    public Stack<Integer> sort(Stack<Integer> s) {
        
        Stack<Integer> s1 = new Stack<>();  // Auxiliary stack for sorting
        
        int x = 0;  // Temporary variable to hold elements from the main stack
        
        while (!s.isEmpty()) {
            // Step 1: Pop the top element from s
            x = s.pop();
            
            // Step 2: Move elements from s1 back to s until we find a greater element or s1 is empty
            while (!s1.isEmpty() && x > s1.peek()) {
                s.push(s1.pop());
            }
            
            // Step 3: Push the current element into s1
            s1.push(x);
        }
        
        // Step 4: Move sorted elements from s1 back to s
        while (!s1.isEmpty()) {
            s.push(s1.pop());
        }
        
        return s;  // Return the sorted stack
    }
}
