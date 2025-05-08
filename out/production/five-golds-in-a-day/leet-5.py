class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[0] * (n + 1) for _ in range(n + 1)]

        ans = ""
        val = -1
        for i in range(n, 0, -1):
            dp[i][i] = 1
            for j in range(i + 1, n + 1):
                if s[i - 1] == s[j - 1]:
                    if j - i >= 2:
                        if dp[i + 1][j - 1] != 0:
                            dp[i][j] = dp[i + 1][j - 1] + 2
                    else: 
                        dp[i][j] = 2

                if dp[i][j] >= val:
                    ans = s[i - 1:j]
                    val = dp[i][j]

        return ans

# DP 문제를 순환적으로 생각하면 해결하기가 힘들다.
# DAG 로 변형해서 순서를 정해줘버려

class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False] * (n) for _ in range(n)]

        ans = s[-1]
        val = 0
        for i in range(n):
            dp[i][i] = True
            for j in range(i):
                if s[j] == s[i] and (i - j <= 2 or dp[j + 1][i - 1]):
                    dp[j][i] = True
                    if i - j + 1 >= val:
                        ans = s[j:i + 1]
                        val = i - j + 1

        return ans


# 맨 첨엔 방향성을 주고 out-degree 가 없는 녀석부터 dp 값을 채웠는데
# 밑에선 사실 상 첫 방식을 reverse 한 느낌인가..