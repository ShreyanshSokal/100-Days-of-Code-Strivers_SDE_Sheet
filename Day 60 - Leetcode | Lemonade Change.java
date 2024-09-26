/**
 * Problem: Lemonade Change (EASY)
 * Link: [No specific link]
 *
 * The task is to determine if it's possible to provide the correct change to each customer given the bills they use to pay.
 *
 * Approach:
 * - **Step 1:** Use three variables (`five`, `ten`, `twenty`) to track the number of $5, $10, and $20 bills collected.
 * - **Step 2:** Iterate over the array of bills:
 *     - If the bill is $5, increment the count of `five` bills.
 *     - If the bill is $10, decrement `five` (since $5 is returned as change) and increment `ten`.
 *     - If the bill is $20, first try to return a $10 and a $5 as change (if available); otherwise, return three $5 bills. If neither option is possible, return `false`.
 * - **Step 3:** If it's possible to return the correct change for all customers, return `true`.
 *
 * Time Complexity: O(n), where `n` is the number of bills.
 * Space Complexity: O(1).
 */

class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Step 1: Initialize variables to track the number of $5, $10, and $20 bills.
        int five = 0, ten = 0;

        // Step 2: Iterate over each bill in the array.
        for (int bill : bills) {
            // Case 1: If the bill is $5, simply collect it (no change required).
            if (bill == 5) {
                five++;
            }
            // Case 2: If the bill is $10, return $5 as change if possible.
            else if (bill == 10) {
                if (five > 0) {
                    five--; // Use one $5 bill as change.
                    ten++;  // Collect the $10 bill.
                } else {
                    return false; // Not enough $5 bills to provide change.
                }
            }
            // Case 3: If the bill is $20, attempt to return $15 as change.
            else {
                // First, try to return one $10 and one $5 bill.
                if (ten > 0 && five > 0) {
                    ten--; // Use one $10 bill.
                    five--; // Use one $5 bill.
                }
                // Otherwise, try to return three $5 bills as change.
                else if (five >= 3) {
                    five -= 3; // Use three $5 bills.
                }
                // If neither option is possible, return false.
                else {
                    return false;
                }
            }
        }

        // Step 3: If all customers received the correct change, return true.
        return true;
    }
}

/**
 * Example:
 * Input: [5, 5, 10, 10, 20]
 * Output: false
 *
 * Explanation:
 * - The first two customers pay with $5, so we don't need to return any change.
 * - The next two customers pay with $10, and we return $5 each time.
 * - The last customer pays with $20, but we only have two $5 bills, so we can't provide $15 in change.
 */
