class Solution {
    public int maxProfit(int[] stocks) {

        int n = stocks.length, maxProfit = 0;

        int min = stocks[0];

        for(int i=1;i<n;i++)
        {
            if(stocks[i] - min > maxProfit)maxProfit = stocks[i] - min;
            min = Math.min(min, stocks[i]);
        }
        return maxProfit;
    }
}
