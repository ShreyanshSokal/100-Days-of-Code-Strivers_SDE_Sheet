import java.util.*;

public class Main {

    // Approach:
    // 1. Given a value V and an array of coin denominations, the goal is to minimize the number of coins required to make the value V.
    // 2. Start with the largest denomination and subtract it from V until the value becomes less than the denomination.
    // 3. Move to the next smaller denomination and repeat the process until V becomes 0.
    // 4. Store the selected coins in a list.

    // Time Complexity (TC): O(V)
    // In the worst case, we may need to subtract the smallest coin from V many times, so the time complexity depends on the value V.

    // Space Complexity (SC): O(V)
    // We are using an ArrayList to store the coins used, which can take up to V space in the worst case.

    public static void main(String[] args) {

        int V = 49;  // Value to make change for
        ArrayList<Integer> ans = new ArrayList<>();
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};  // Denominations of coins
        int n = coins.length;

        // Step 1: Iterate from the largest denomination down to the smallest
        for (int i = n - 1; i >= 0; i--) {
            // Step 2: Add coins to the result as long as the value is larger than or equal to the current coin
            while (V >= coins[i]) {
                V -= coins[i];
                ans.add(coins[i]);
            }
        }

        // Output the results
        System.out.println("The minimum number of coins is " + ans.size());
        System.out.println("The coins are:");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(" " + ans.get(i));
        }
    }
}
