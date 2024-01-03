class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minVal = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int gap = prices[i] - minVal;
            if (result < gap) result = gap;
            if (minVal > prices[i]) minVal = prices[i];
        }
        return result;
    }
}