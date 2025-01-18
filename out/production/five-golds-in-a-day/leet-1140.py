# rec TLE
class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        if not piles : return 0

        suffixSum = [piles[-1]]
        for i in reversed(piles[:-1]):
            suffixSum.append(i + suffixSum[-1])
        suffixSum.reverse()

        def helper(i, m):
            if i + 2 * m >= len(suffixSum):
                return suffixSum[i]
            return suffixSum[i] - min(helper(i + x, max(m, x)) for x in range(1, 2 * m + 1))
        return helper(0, 1)
        
# DP
class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        if not piles : return 0

        suffixSum = [piles[-1]]
        for i in reversed(piles[:-1]):
            suffixSum.append(i + suffixSum[-1])
        suffixSum.reverse()

        cache = {}
        def helper(i, m):
            if (i, m) in cache:
                return cache[(i, m)]
            if i + 2 * m >= len(suffixSum):
                return suffixSum[i]
            cache[(i, m)] = suffixSum[i] - min(helper(i + x, max(m, x)) for x in range(1, 2 * m + 1))
            return cache[(i, m)]
        return helper(0, 1)
        

'''
문제해석 자체가 넘 어렵네.. 뭔 말이여..
재귀형식의 일반 구현만 해내면 DP 적용은 간단한 편인데
일반 구현 조차 이해를 못하니 어렵더라..
suffix sum 개념도 알아야한다.
내가 취할 수 있는 모든 x 에 대해 상대방의 결과를 바탕으로 답을 구해내는데
일반 구현도 쉽지 않다.. 기초부터 다시공부해야지..
'''