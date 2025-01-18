class Solution:

    def nthUglyNumber(self, n: int) -> int:
        ptr2, ptr3, ptr5 = 0, 0, 0
        dp = [1] + [0] * (n - 1)
        for i in range(1, n):
            dp[i] = min(dp[ptr2]*2, dp[ptr3]*3, dp[ptr5]*5)
            if dp[i] == dp[ptr2]*2:
                ptr2 += 1
            if dp[i] == dp[ptr3]*3:
                ptr3 += 1
            if dp[i] == dp[ptr5]*5:
                ptr5 += 1
        return dp[n-1]
        
# 다른 사람의 접근법인데 DP 를 사용하네.. 난 DP 인줄도 모르겠던데
# 힌트가 되는 부분이 있다면 2, 3, 5 으로 만들 수있는 매 순간의 가장 작은 최대값들을 구할 수 있다는 부분이다.
# 조금 신경 쓰이는 부분은 ptr2, ptr3 이 초반에 서로 6을 만들 수 있는 상황에서
# ptr 을 어떻게 관리해줘야하냐인데 둘을 다 증가시켜줌으로 해결이 가능하다. 이게 귀납적으로 따지면
# 애써 납득이 되는데 직관적으로 와닿진 않아서 힘들다.. 똑똑한 사람들이 참 많군..
