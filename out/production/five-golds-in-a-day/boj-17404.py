# RGB거리에는 집이 N개, 거리는 선분으로, 1..N 집 존재. ---1--2---3---4--
# 집은 빨강, 초록, 파랑중 하나의 색으로 칠해야 한다. 각 집을 칠하는 비용이 주어졌을 때, 규칙 만족 모든 집칠하는 비용 최소로 구하자.
# 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
# N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
# i(2<= i <= N-1)번 집의 색은 양 옆집이랑 달라야한다.

# N (2 <= N <= 1000) 2부터 N개 줄에 빨, 초 , 파 칠하는 비용이 한 줄에 주어진다. 그 비용은 1000보다 작거나 같은 자연수

from sys import stdin

N = int(stdin.readline())

cost = []
for _ in range(N):
    cost.append(list(map(int, stdin.readline().split())))

r, g, b = 0, 1, 2
INF = 99999999
ans = INF
for i in range(3):
    dp = [[0, 0, 0] for _ in range(1005)]
    dp[0] = [INF, INF, INF]
    dp[0][i] = cost[0][i]

    for j in range(1, N):
        dp[j][r] = min(dp[j-1][g], dp[j-1][b]) + cost[j][r]
        dp[j][g] = min(dp[j-1][b], dp[j-1][r]) + cost[j][g]
        dp[j][b] = min(dp[j-1][r], dp[j-1][g]) + cost[j][b]
    dp[N-1][i] = INF
    dp[N-1].append(ans)
    ans = min(dp[N-1])
print(ans)