class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        if (nums.length==1) return dp[0];
        dp[1] = nums[1];
        if (nums.length==2) return Math.max(dp[0], dp[1]);
        dp[2] = nums[2] + nums[0];
        if (nums.length==3) return Math.max(dp[0], Math.max(dp[1], dp[2]));
        int ans = Math.max(dp[0], Math.max(dp[1], dp[2]));
        for (int i = 3; i < dp.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// 5 0 0 5 0
// 5