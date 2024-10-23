class Solution {

    // Approach:
    // 1. The task is to calculate the number of "good numbers" of length n, where:
    //    - Even indices must have even digits (0, 2, 4, 6, 8) — 5 choices.
    //    - Odd indices must have prime digits (2, 3, 5, 7) — 4 choices.
    // 2. We count how many even-indexed and odd-indexed positions there are, then calculate 5^even and 4^odd.
    // 3. To handle large powers, we use modular exponentiation, which ensures the result stays within a given mod.

    // Time Complexity (TC): O(log(n))
    // The time complexity comes from the modular exponentiation function, which runs in O(log(n)) for both 5^even and 4^odd.

    // Space Complexity (SC): O(1)
    // We only use a few variables for calculations, so the space complexity is constant.

    public int countGoodNumbers(long n) {
        
        int mod = 1000000007;

        // Calculate the count of even and odd positions
        long even = (n / 2) + (n % 2);  // Number of even-indexed positions (including the first position)
        long odd = n / 2;  // Number of odd-indexed positions

        // Efficiently compute 5^even % mod and 4^odd % mod using modular exponentiation
        long first = modExp(5, even, mod);
        long second = modExp(4, odd, mod);

        // Return the result of (first * second) % mod
        return (int)((first * second) % mod);
    }

    // Function for modular exponentiation: (base^exp) % mod
    private long modExp(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {  // If exp is odd, multiply the result with base
                result = (result * base) % mod;
            }
            base = (base * base) % mod;  // Square the base
            exp /= 2;  // Divide exp by 2
        }
        return result;
    }
}
