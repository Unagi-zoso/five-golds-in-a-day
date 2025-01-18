# nxn 집 있고 파이프 하나 옮기자 두 칸 차지하는 크기


from sys import stdin

n = int(stdin.readline())
board = [list(map(int, stdin.readline().split())) for _ in range(n)]
dp = [[[0 for _ in range(3)] for _ in range(n+5)] for _ in range(n+5)]
dp[0][1][0] = 1
dir = [[0,1], [1,0], [1,1]]

for i in range(0, n):
    for j in range(1, n):
        if dp[i][j][0] > 0:
            if j+1 < n and board[i][j+1] == 0:
                dp[i][j+1][0] += dp[i][j][0]
            if i+1 < n and j+1 < n and board[i][j+1] == 0 and board[i+1][j] == 0 and board[i+1][j+1] == 0:
                dp[i+1][j+1][2] += dp[i][j][0]
        if dp[i][j][1] > 0:
            if i+1 < n and board[i+1][j] == 0:
                dp[i+1][j][1] += dp[i][j][1]
            if i+1 < n and j+1 < n and board[i][j+1] == 0 and board[i+1][j] == 0 and board[i+1][j+1] == 0:
                dp[i+1][j+1][2] += dp[i][j][1]
        if dp[i][j][2] > 0:
            if j+1 < n and board[i][j+1] == 0:
                dp[i][j+1][0] += dp[i][j][2]
            if i+1 < n and board[i+1][j] == 0:
                dp[i+1][j][1] += dp[i][j][2]
            if i+1 < n and j+1 < n and board[i][j+1] == 0 and board[i+1][j] == 0 and board[i+1][j+1] == 0:
                dp[i+1][j+1][2] += dp[i][j][2]
                
print(sum(dp[n-1][n-1]))
