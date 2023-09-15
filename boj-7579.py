from sys import stdin

N, M = list(map(int, stdin.readline().split()))

m_li = list(map(int, stdin.readline().split()))
c_li = list(map(int, stdin.readline().split()))
dp = [[0] + [0] * sum(c_li) for _ in range(N)]

ret = sum(c_li)
for i in range(N):
    for j in range(1, sum(c_li)+1):
        if j < c_li[i]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(m_li[i] + dp[i-1][j-c_li[i]], dp[i-1][j])
        if dp[i][j] >= M:
            ret = min(ret, j)
print(ret)