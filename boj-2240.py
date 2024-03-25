
t, w = map(int, input().split())
dp = [[0 for _ in range(w+1)] for _ in range(1005)]
plums = [0] + [int(input()) for _ in range(t)]
dp[1][0] = plums[1] % 2 
dp[1][1] = plums[1] // 2

for i in range(2, t+1):
    for j in range(w+1):
        plum = plums[i] % 2 if j % 2 == 0 else plums[i] // 2
        dp[i][j] = max(dp[i-1][:j+1]) + plum

for i in range(1, t+1):
    for j in range(w+1):
        print(dp[i][j], end=' ')
    print()

print(max(dp[t])) 
