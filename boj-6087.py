from heapq import heappop, heappush

INF = float('inf')

w, h = map(int, input().split())
board = list(input().rstrip() for _ in range(h))
visited = [[[ INF for _ in range(w)] for _ in range(h)] for _ in range(4)]
c_list = []
for y in range(h):
    for x in range(w):
        if board[y][x] == 'C':
            c_list.append((y, x))
dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
q = []
ans = INF

for i in range(4):
    visited[i][c_list[0][0]][c_list[0][1]] = 0

for i in range(4):
    ny = c_list[0][0]+ dir[i][0]
    nx = c_list[0][1] + dir[i][1]
    if (ny < 0 or ny >= h or nx < 0 or nx >= w) or \
    board[ny][nx] == '*':
        continue
    visited[i][ny][nx] = 0
    heappush(q, (0, ny, nx, i))

while q:
    cost, y, x, d = heappop(q)
    if y == c_list[1][0] and x == c_list[1][1]:
        ans = visited[d][y][x]
        break

    while(True):
        ny = y + dir[d][0]
        nx = x + dir[d][1]

        if (ny < 0 or ny >= h or nx < 0 or nx >= w) or \
            board[ny][nx] == '*' or \
            cost >= visited[d][ny][nx]:
            break
        visited[d][ny][nx] = cost
        heappush(q, (cost, ny, nx, d))
        
    for i in range(4):
        if i == d: continue
        ny = y + dir[i][0]
        nx = x + dir[i][1]
        if (ny < 0 or ny >= h or nx < 0 or nx >= w) or \
        board[ny][nx] == '*' or \
        cost >= visited[i][ny][nx]:
            continue
        visited[i][ny][nx] = cost + 1
        heappush(q, (cost + 1, ny, nx, i))

print(ans)