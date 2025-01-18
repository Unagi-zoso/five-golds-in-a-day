n, m = map(int, input().split())
costs = [tuple(map(int, input().split())) for _ in range(n)]

dist = [[-1 for _ in range(505)] for _ in range(505)]

for i in range(n):
    for j in range(n):
        dist[i+1][j+1] = abs(costs[i][0] - costs[j][0]) + abs(costs[i][1] - costs[j][1])

INF = float('inf')
dp = [[INF for _ in range(505)] for _ in range(505)]

def rec(dest, cntIgnored):
    global dp, INF, dist
    if dest == 1:
        return 0
    if dp[dest][cntIgnored] != INF:
        return dp[dest][cntIgnored]
    for i in range(cntIgnored+1):
        if dest - 1 - i < 1: break
        print(dest, cntIgnored, dest - 1 - i, cntIgnored - i)
        dp[dest][cntIgnored] = min(dp[dest][cntIgnored], rec(dest - 1 - i, cntIgnored - i) + dist[dest - 1 - i][dest])
    return dp[dest][cntIgnored]

print(rec(n, m))
