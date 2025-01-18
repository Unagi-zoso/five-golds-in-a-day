c, n = map(int, input().split())
info = [list(map(int, input().split())) for _ in range(n)]
cost, reward = 0, 1
dp = [0  for _ in range(100005)]

for i in range(n):
    for j in range(100001):
        if j - info[i][cost] < 0:
            continue
        dp[j] = max(dp[j], dp[j-info[i][cost]]+info[i][reward])

for i in range(100001):
    if dp[i] >= c:
        print(i)
        break
