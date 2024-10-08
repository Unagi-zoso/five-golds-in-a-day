class Solution:
    def jump(self, nums: List[int]) -> int:
        INF = float('INF')
        dp = [0] + [INF] * 10000
        for i in range(len(nums)):
            for j in range(0, nums[i] + 1):
                if i + j >= len(nums): break
                dp[i + j] = min(dp[i + j], dp[i] + 1)
        
        return dp[len(nums) - 1]
        
