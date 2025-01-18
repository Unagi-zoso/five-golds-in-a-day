from collections import defaultdict

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        d = defaultdict(int)
        for s in strs:
            for i in range(1, len(s) + 1):
                d[s[:i]] += 1
        
        ans = ""
        for k, i in d.items():
            if i == len(strs) and len(ans) < len(k):
                ans = k
        
        return ans
        