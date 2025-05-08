# 1. 격자의 바깥으로는 나갈 수 없습니다. (예외)
# 2. (x, y)에서 (r, c)까지 이동하는 거리가 총 k여야 합니다. 이때, (x, y)와 (r, c)격자를 포함해, 같은 격자를 두 번 이상 방문해도 됩니다. (중복 가능)
# 3. 미로에서 탈출한 경로를 문자열로 나타냈을 때, 문자열이 사전 순으로 가장 빠른 경로로 탈출해야 합니다. (dfs)

from collections import deque

def solution(n, m, x, y, r, c, k):
    dir = [(1, 0, 'd'), (0, -1, 'l'), (0, 1, 'r'), (-1, 0, 'u')]
    q = deque()
    q.append((x, y, "", 0))
    while q:
        c_y, c_x, c_s, c_d = q.popleft()
        if (c_y, c_x) == (r, c) and (k - c_d) % 2 == 1:            
            return "impossible"
        if c_y == r and c_x == c and c_d == k:
                return n_s
        for i in range(4):
            n_y = c_y + dir[i][0]
            n_x = c_x + dir[i][1]
            n_s = c_s + dir[i][2]
            n_d = c_d + 1
            if n_y < 1 or n_y > n or n_x < 1 or n_x > m:
                continue
            if n_d + abs(r-n_y) + abs(c-n_x) > k:
                continue
            
            q.append((n_y, n_x, n_s, n_d))
            break
            
    return "impossible"