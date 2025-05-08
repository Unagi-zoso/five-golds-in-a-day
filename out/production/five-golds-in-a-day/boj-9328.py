from collections import defaultdict, deque

t = int(input())
for _ in range(t):
    r, c = map(int, input().split())
    board = [list(input()) for _ in range(r)]
    keys = [*input()]
    key_flag = defaultdict(lambda : False)
    lock_pos_hash = defaultdict(list)
    visited = [[False for _ in range(105)] for _ in range(105)]
    EMPTY_CHAR = '.'

    for i in range(r):
        board[i].insert(0, EMPTY_CHAR)
        board[i].append(EMPTY_CHAR)
    board.insert(0, [EMPTY_CHAR for _ in range(c+2)])
    board.append([EMPTY_CHAR for _ in range(c+2)])

    dir = ((0, 1), (1, 0), (0, -1), (-1, 0))

    for k in keys:
        key_flag[k] = True

    answer = 0
    q = deque()
    q.append((0, 0))
    visited[0][0] = True
    
    while q:
        c_y, c_x = q.popleft()
        for d in dir:
            n_y, n_x = c_y+d[0], c_x+d[1]
            if not (0 <= n_y < r+2 and 0 <= n_x < c+2): continue
            if board[n_y][n_x] == '*': continue
            if visited[n_y][n_x]: continue
            
            if board[n_y][n_x] == EMPTY_CHAR:
                visited[n_y][n_x] = True
                q.append((n_y, n_x))
            elif 'a' <= board[n_y][n_x] <= 'z':
                visited[n_y][n_x] = True
                key_flag[board[n_y][n_x]] = True
                for y, x in lock_pos_hash[(board[n_y][n_x]).upper()]:
                    q.append((y, x))
                    visited[y][x] = True
                q.append((n_y, n_x))
            elif 'A' <= board[n_y][n_x] <= 'Z':
                lock_pos_hash[(board[n_y][n_x])].append((n_y, n_x))
                if key_flag[board[n_y][n_x].lower()] == True:
                    for y, x in lock_pos_hash[(board[n_y][n_x])]:
                        q.append((y, x))
                        visited[y][x] = True
            elif board[n_y][n_x] == '$':
                visited[n_y][n_x] = True
                answer += 1
                q.append((n_y, n_x))               
    print(answer)
