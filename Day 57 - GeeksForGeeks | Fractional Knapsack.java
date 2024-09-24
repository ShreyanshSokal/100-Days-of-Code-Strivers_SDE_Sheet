/**
 * Problem: Fractional Knapsack (MEDIUM)
 * Link: [No specific link]
 *
 * The task is to maximize the total value that can be obtained by placing items in a knapsack of capacity `w`. Each item has a value and a weight, and we can take fractions of items.
 *
 * Approach:
 * - **Step 1:** Sort the items based on their value-to-weight ratio in descending order.
 * - **Step 2:** Traverse through the sorted items and add the full value of the item if its weight is less than or equal to the remaining capacity.
 * - **Step 3:** If the current item cannot be fully added due to the remaining capacity, take the fraction of the item that can fit and add its corresponding value.
 * - **Step 4:** Stop when the knapsack is full and return the total value.
 *
 * Time Complexity: O(n log n) due to sorting, where `n` is the number of items.
 * Space Complexity: O(1).
 */

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Step 1: Sort items by value-to-weight ratio in descending order.
        Arrays.sort(arr, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

        double total = 0.0;  // Step 2: Initialize the total value accumulated.
        
        // Step 3: Traverse through sorted items to maximize total value.
        for (Item i : arr) {
            if (i.weight <= w) {
                // If the entire item can be taken, take it and add its value to the total.
                total += i.value;
                w -= i.weight;  // Reduce the remaining capacity of the knapsack.
            } else {
                // If only a fraction of the item can be taken, add the fraction of its value.
                total += (i.value / (double)i.weight) * w;
                break;  // Stop, as the knapsack is full.
            }
        }

        // Step 4: Return the maximum total value obtained.
        return total;
    }
}
