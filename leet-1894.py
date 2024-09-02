class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        s = sum(chalk)
        k %= s
        for i in range(len(chalk)):
            k -= chalk[i]
            if k < 0:
                return i
