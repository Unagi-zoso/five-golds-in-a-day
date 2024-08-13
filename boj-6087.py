w, h = map(int, input().split())
board = list(input().rstrip() for _ in range(h))
visited = [[False for _ in range(w)] for _ in range(h)]

c_list = []
for y in range(h):
    for x in range(w):
        if board[y][x] == 'C':
            c_list.append((y, x))

dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
loc = ['U', 'D', 'R', 'L']

ans = float('inf')
def dfs(y, x, d, cnt):
    global ans
    global board
    global w, h
    global visited, dir, loc

    if y == c_list[1][0] and x == c_list[1][1]:
        ans = min(ans, cnt)
        return
    
    for i in range(4):
        ny = y + dir[i][0]
        nx = x + dir[i][1]

        if (ny < 0 or ny >= h or nx < 0 or nx >= w) or \
            visited[ny][nx] or board[ny][nx] == '*':
            continue
        
        visited[ny][nx] = True
        if d == loc[i]:
            dfs(ny, nx, loc[i], cnt)
        else:
            dfs(ny, nx, loc[i], cnt + 1)
        visited[ny][nx] = False
    
dfs(c_list[0][0], c_list[0][1], 'init', -1)
print(ans)