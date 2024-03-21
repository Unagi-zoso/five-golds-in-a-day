n = int(input())

INF = float('inf')
dp = [INF] * 5005

dp[3] = 1
dp[5] = 1

for i in range(6, 5005):
    dp[i] = min(dp[i], dp[i-5] + 1, dp[i-3] + 1)

print(dp[n])
