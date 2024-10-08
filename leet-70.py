class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [0, 1, 2] + [0] * 100
        for i in range(3, n + 1):
            dp[i] += dp[i-1] + dp[i-2]
        return dp[n]
        