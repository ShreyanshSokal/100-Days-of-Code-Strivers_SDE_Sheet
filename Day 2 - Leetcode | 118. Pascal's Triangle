class Solution {

    long getCombination(int n, int r) // TC - O(r)
    {
        long result = 1;

        for (int i = 0; i < r; i++) {
            // result * (n-i)
            result = result * (n - i);
            // result / (i+1)
            result = result / (i + 1);
        }

        return result;
    }

    /*
    Example for n=5, r=3:
    result = 5*4*3 / 1*2*3
    */

    List<Integer> generateCombinationRow(int n) // TC - O(n)
    {
        int value = 1;

        List<Integer> combinationRow = new ArrayList<>();
        combinationRow.add(value);

        for (int i = 1; i < n; i++) {
            value = value * (n - i);
            value = value / i;
            combinationRow.add(value);
        }

        return combinationRow;
    }

    /* 
    Example for n=5:
    1 * 5/1 * 4/2 * 3/3 * 2/4 * 1/5
    
    Output: 1, 5, 10, 10, 5, 1
    */

    public List<List<Integer>> generate(int numRows) { // TC - O(numRows^2)
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> currentRow = generateCombinationRow(i);
            result.add(currentRow);
        }

        return result;
    }
}

/*
for loop from i=1 to numRows
*/
