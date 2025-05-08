class Solution:
    def maxArea(self, height: List[int]) -> int:
        j = len(height) - 1
        i = 0
        ans = 0
        while i <= j:
            hi, hj = height[i], height[j]
            ans = max(ans, (j - i) * min(hi, hj))
            if hi >= hj:
                j -= 1
            else:
                i += 1
        
        return ans
