import java.util.*;

class Solution {

    // Approach - 2:
    // 1. We use a mathematical approach to directly find the K-th permutation.
    // 2. We calculate the partition size, which is (n-1)!.
    // 3. Using this partition size, we determine the range in which the K-th permutation falls.
    // 4. We pick the corresponding element from the list of available numbers and reduce the problem size.
    // 5. This process is repeated until we find the complete permutation.

    // Time Complexity (TC): O(n^2) 
    // We reduce the size of the number list in each iteration, but removing an element from the list is an O(n) operation.

    // Space Complexity (SC): O(n) 
    // We store the numbers in a list and build the solution string, both of which require O(n) space.

    public String getPermutation(int n, int k) {

        List<Character> numbers = new ArrayList<>();
        String solution = "";

        int partition = 1; // (n-1)!
        char c = '1';

        // Initialize the list of numbers from '1' to 'n' and calculate (n-1)!
        for (int i = 1; i < n; i++) {
            numbers.add(c++);
            partition *= i;
        }
        numbers.add(c);

        k--; // Convert to 0-based indexing

        while (true) {
            // Add the element that corresponds to the current partition
            solution += numbers.get(k / partition);
            // Remove the used element from the list
            numbers.remove(k / partition);

            if (numbers.size() == 0) break; // All numbers are used

            // Update k to represent the new index for the next partition
            k = k % partition;

            // Recalculate partition for the remaining numbers
            partition = partition / numbers.size();
        }

        return solution;
    }
}
