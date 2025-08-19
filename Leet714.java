class Solution {
    public int maxProfit(int[] prices, int fee) {

        int ans = 0;
        int len = prices.length;
        int target = - prices[0];
        for (int i = 1; i < len; i++) {
            target = Integer.max(target, ans - prices[i]);
            ans = Math.max(ans, target + prices[i] - fee);
        }
        return ans;
    }
}