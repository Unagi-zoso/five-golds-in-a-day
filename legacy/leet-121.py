class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        minPrev = prices[0]
        for i in range(1, len(prices)):
            ans = max(ans ,prices[i] - minPrev)
            minPrev = min(minPrev, prices[i])
        return ans
        