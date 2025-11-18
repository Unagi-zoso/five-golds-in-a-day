class Solution {
    public int maxProfit(int[] prices) {
        int curMax = prices[prices.length-1];
        int ans = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            ans = Math.max(ans, curMax-prices[i]);
            curMax = Math.max(curMax, prices[i]);
        }

        return ans;
    }
}