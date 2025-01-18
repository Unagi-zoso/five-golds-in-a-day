n = int(input())
m = int(input())
INF = float('inf')
board = [[(INF, INF, None) for _ in range(n+1)] for _ in range(n+1)]

for _ in range(m):
    f, t, c = map(int, input().split())
    if board[f][t][0] > c:
        path = []
        path.append(f)
        path.append(t)
        board[f][t] = (c, 2, path)
for i in range(n+1):
    board[i][i] = (0, 1, [i])
for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if board[i][j][0] > board[i][k][0] + board[k][j][0]:
                board[i][j] = (board[i][k][0] + board[k][j][0], board[i][k][1] + board[k][j][1] - 1, board[i][k][2][:-1] + board[k][j][2])
                if board[i][j][0] == 7: print("**** ", k, i, j)

for i in range(1, n+1):
    for j in range(1, n+1):
        if board[i][j][0] == 0 or board[i][j][0] == INF:
            print(0, end=' ')
        else:
            print(board[i][j][0], end=' ')
    print()

for i in range(1, n+1):
    for j in range(1, n+1):
        cost, len, path = board[i][j]
        if cost == 0 or cost == INF:
            print(0)
        else:
            print(len, ' '.join(list(map(str, path))))
            
        