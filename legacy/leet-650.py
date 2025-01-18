class Solution:
    def rec(self, cur):
        if cur == 1:
            return 0

        minVal = float('inf')
        for i in range(1, cur):
            if (cur % i) != 0: continue
            minVal = min(minVal, self.rec(i) + (cur // i))
        return minVal

    def minSteps(self, n: int) -> int:
        return self.rec(n)        
# 복사를 최대한 많이 돌리는게 이득이 될 수 있다. 복사를 base 를 얼마나 빨리
# 얻을 수 있느냐가 중요. 이 base 도 기초값에서 복사를 통해 얻을 수 있으니
# subproblem 으로 볼 수 있다.
