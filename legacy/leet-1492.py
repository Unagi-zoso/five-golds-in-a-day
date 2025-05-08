class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        ls = []
        rs = []
        for i in range(1, int(sqrt(n)) + 1):
            if n % i != 0: continue
            ls.append(i)
            rs.append(n // i)
        if ls[-1] == rs[-1]: ls.pop()
        rs.reverse()
        ls.extend(rs)
        return ls[k - 1] if len(ls) >= k else -1
