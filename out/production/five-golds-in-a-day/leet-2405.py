class Solution:
    def partitionString(self, s: str) -> int:
        ans= 1
        ls = set()
        for i in s:
            if i in ls:
                ls = set()
                ans += 1
            ls.add(i)
        return ans
    