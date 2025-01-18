class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        d = dict()
        ans = 0
        cur = 0
        prev = -1
        for i in range(len(s)):
            cur += 1
            if s[i] in d and d[s[i]] > prev:
                prev = d[s[i]]
                cur = (i - d[s[i]])
            else:
                ans = max(ans, cur)
            d[s[i]] = i
        return ans
            