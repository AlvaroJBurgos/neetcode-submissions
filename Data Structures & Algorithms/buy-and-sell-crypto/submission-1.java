class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyDay = 0;
        int buyValue = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if ((prices[i] - buyValue) > profit) {
                profit = (prices[i] - buyValue);
            }
            if (prices[i] < buyValue) {
                buyValue = prices[i];
            }
        }
        return profit;
    }
}