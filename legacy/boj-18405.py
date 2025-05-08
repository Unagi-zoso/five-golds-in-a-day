from collections import deque
n, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

s, ans_x, ans_y = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

cur_q = deque()
for i in range(n):
    for j in range(n):
        if board[i][j] != 0:
            cur_q.append((board[i][j], i, j))

cur_q = deque(sorted(cur_q, key=lambda x: x[0]))

for _ in range(s):
    next_q = deque()
    while cur_q:
        virus, x, y = cur_q.popleft()
        for j in range(4):
            nx, ny = x + dx[j], y + dy[j]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if board[nx][ny] == 0:
                board[nx][ny] = virus
                next_q.append((virus, nx, ny))
    cur_q = next_q

print(board[ans_x-1][ans_y-1])
    