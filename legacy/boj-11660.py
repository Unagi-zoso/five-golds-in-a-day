n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dp = [[0 for _ in range(1050)] for _ in range(1050)]

dp[0][0] = board[0][0]
for i in range(1, n):
    dp[0][i] = dp[0][i-1] + board[0][i]
    dp[i][0] = board[i][0] + dp[i-1][0]

for i in range(1, n):
    curRowSum = board[i][0]
    for j in range(1, n):
        curRowSum += board[i][j]
        dp[i][j] += curRowSum + dp[i-1][j]

for i in range(n):
    dp[i].insert(0, 0)
dp.insert(0, [0 for _ in range(n+5)])

li = []
for _ in range(m):
    r1, c1, r2, c2 = map(int, input().split())
    print(dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1])
