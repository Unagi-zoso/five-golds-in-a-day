class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        ar = []
        for k, v in Counter(arr).items():
            ar.append((v, k))
        
        ar.sort(reverse=True)

        n = len(arr) // 2
        ans = 0
        for k, v in ar:
            ans += 1
            n -= k
            if n <= 0:
                return ans
        
        