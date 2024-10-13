import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    // Approach:
    // 1. First, create a copy of the original array and sort it to determine the ranks.
    // 2. Use a HashMap to store the rank of each unique number in the sorted array.
    // 3. Iterate over the original array, and for each element, assign its corresponding rank from the HashMap.
    // 4. Return the updated array with ranks.

    // Time Complexity (TC): O(n log n)
    // Sorting the array takes O(n log n), and iterating over the array to assign ranks is O(n), so the overall complexity is dominated by O(n log n).

    // Space Complexity (SC): O(n)
    // We use extra space for a copy of the array and a HashMap to store ranks, so the space complexity is O(n).

    public int[] arrayRankTransform(int[] narr) {
        int[] arr = new int[narr.length];

        // Step 1: Copy the original array to a new array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = narr[i];
        }

        // Step 2: Sort the copied array
        Arrays.sort(arr);

        // Step 3: Use a HashMap to assign ranks to unique elements
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, rank++);
            }
        }

        // Step 4: Assign ranks to the original array elements
        for (int i = 0; i < narr.length; i++) {
            narr[i] = map.get(narr[i]);
        }

        // Step 5: Return the ranked array
        return narr;
    }
}
