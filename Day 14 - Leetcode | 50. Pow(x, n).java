class Solution {
    /**
     * Problem Description:
     * You are given a base `x` and an exponent `n`. The task is to calculate 
     * the power `x^n`, which means multiplying `x` by itself `n` times. 
     * However, the challenge is to implement this efficiently, especially 
     * when `n` is large or negative.
     * 
     * Intuition:
     * The problem can be solved efficiently using a recursive approach 
     * known as "Exponentiation by Squaring". This approach reduces the 
     * number of multiplications required by dividing the problem into 
     * smaller subproblems. If the exponent `n` is even, the power can be 
     * calculated by squaring the result of `x^(n/2)`. If `n` is odd, the 
     * power can be calculated as `x * x^(n-1)`, which again can be broken 
     * down using the even case.
     * 
     * Approach:
     * 1. Base Cases:
     *    - If `y` (the exponent) is 0, the result is 1 (as any number 
     *      raised to the power of 0 is 1).
     * 
     * 2. Recursive Calculation:
     *    - If `y` is even:
     *      - Calculate `dp = power(x, y/2)`.
     *      - Return `dp * dp` because `x^y` is equivalent to `(x^(y/2))^2`.
     *    - If `y` is odd:
     *      - Calculate `dp = power(x, y/2)`.
     *      - Return `x * dp * dp` because `x^y` is equivalent to `x * (x^(y/2))^2`.
     *    - This method reduces the exponent by half at each step, making the 
     *      algorithm logarithmic in terms of time complexity.
     * 
     * 3. Handling Negative Exponent:
     *    - If `n` is negative, calculate `x^|n|` and then take the reciprocal of 
     *      the result.
     * 
     * Time Complexity:
     * - The time complexity is O(log n) because the exponent is halved in each 
     *   recursive call.
     * 
     * Space Complexity:
     * - The space complexity is O(log n) due to the recursive call stack.
     */
    
    double power(double x, int y) {
        // if even - 2^4 = 2^2 * 2^2;
        // if odd  - 2^5 = 2 * 2^2 * 2^2;
        // We calculate 2^2 (dp) in advance to avoid redundant calculations.

        if (y == 0)
            return 1;

        double dp = power(x, y / 2);

        if (y % 2 == 0)
            return dp * dp;
        else
            return x * dp * dp;
    }

    public double myPow(double x, int n) {
        int sign = n < 0 ? -1 : 1;

        double ans = power(x, Math.abs(n));
        return sign < 0 ? 1 / ans : ans;
    }
}

//This implementation efficiently calculates `x^n` by using the "Exponentiation by Squaring" method, reducing the time complexity to logarithmic time. 
//This makes it highly efficient even for large values of `n`. The code also correctly handles negative exponents by taking the reciprocal of the result.
