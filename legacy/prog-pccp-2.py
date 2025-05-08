from collections import deque

def solution(land):
    answer = 0
    id = 2
    candi = {}
    visited = [[False for _ in range(505)] for _ in range(505)]
    n, m = len(land), len(land[0])
    for i in range(n):
        for j in range(m):
            if visited[i][j] or land[i][j] != 1: continue
            visited[i][j] = True
            land[i][j] = id
            candi[id] = 0
            q = deque([[i, j]])
            while q:
                cy, cx = q.popleft()
                candi[id] += 1
                for dy, dx in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                    ny = cy + dy
                    nx = cx + dx
                    
                    if not (0 <= ny < n) or not (0 <= nx < m): continue
                    if visited[ny][nx] or land[ny][nx] == 0: continue
                    visited[ny][nx] = True
                    land[ny][nx] = id                    
                    q.append([ny, nx])
            id += 1
    
    
    for i in range(m):
        _sum = 0
        s = set()
        s.add(0)
        for j in range(n):
            if land[j][i] not in s:
                _sum += candi[land[j][i]]
            s.add(land[j][i])
        answer = max(answer, _sum)            
    
    return answer
