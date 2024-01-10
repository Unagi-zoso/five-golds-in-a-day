from sys import stdin

n, m = map(int, stdin.readline().split())

board = [list(map(int, stdin.readline().split())) for _ in range(n)]

dp = [[0 for _ in range(m+5)] for _ in range(n+5)]

dir = [[1, 0], [0, 1], [1, 1]]
for i in range(n):
    for j in range(m):
        for k in range(3):
            nr, nc = i + dir[k][0], j + dir[k][1]
            if nr >= n or nc >= m:
                continue
            dp[nr][nc] = max(dp[nr][nc], dp[i][j] + board[i][j])
            
print(dp[n-1][m-1] + board[n-1][m-1])
