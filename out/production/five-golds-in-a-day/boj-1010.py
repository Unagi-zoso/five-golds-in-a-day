dp = [[0] * 31 for _ in range(31)]
for i in range(1, 31):
    dp[1][i] = i

for i in range(1, 31):
    for j in range(i, 31):
        for k in range(1, 31):
            if j-k < i-1: break 
            dp[i][j] += dp[i-1][j-k]

for _ in range(int(input())):
    n, m = map(int, input().split())
    print(dp[n][m])
    