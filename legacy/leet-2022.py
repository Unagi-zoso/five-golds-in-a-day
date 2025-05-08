class Solution:
    def construct2DArray(self, original: List[int], m: int, n: int) -> List[List[int]]:
        if m*n != len(original): return []
        ans = []
        ans.append(original[: n])
        for i in range(1, m):
            ans.append(original[i*n: i*n + n])
        return ans
