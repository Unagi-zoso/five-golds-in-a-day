from itertools import combinations
from collections import deque
from copy import deepcopy
from sys import stdin

n, m, g, r = map(int, stdin.readline().split())
board = [list(map(int, stdin.readline().split())) for _ in range(n)]

sowable = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            sowable.append((i, j))

ans = 0
dir = ((0, 1), (0, -1), (1, 0), (-1, 0))
for ss in combinations(sowable, g+r):
    for gs in combinations(ss, g):
        gs = list(gs)
        _board = deepcopy(board)
        rs = list(set(ss).difference(gs))
        for y, x in gs:
            _board[y][x] = (5, 'g')
        for y, x in rs:            
            _board[y][x] = (5, 'r')
        
        cnt = 0
        q = deque(gs + rs)
        while q:
            y, x = q.popleft()
            c_time, c_type = _board[y][x]
            for nd in dir:
                ny, nx = y + nd[0], x + nd[1]
                if not (0 <= ny < n and 0 <= nx < m): continue
                if _board[ny][nx] == 0 or c_type == 'f' : continue
                if _board[ny][nx] == 1 or _board[ny][nx] == 2: 
                    _board[ny][nx] = (c_time+1, c_type)
                    q.append((ny, nx))
                else:
                    if c_time+1 == _board[ny][nx][0] and ((c_type == 'g' and _board[ny][nx][1] == 'r') or (c_type == 'r' and _board[ny][nx][1] == 'g')):
                        _board[ny][nx] = (0, 'f')
                        cnt += 1

        ans = max(ans, cnt)
print(ans)    
    