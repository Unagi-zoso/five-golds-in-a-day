from collections import defaultdict, deque
from sys import stdin

n, m = map(int, stdin.readline().split())

edges = defaultdict(list)
visited_f = [-1 for _ in range(n+5)]
visited_j = [-1 for _ in range(n+5)]

for _ in range(m):
    i, j = map(int, stdin.readline().split())
    edges[i].append(j)
    edges[j].append(i)


def bfs(visited, i, let):
    q = deque()
    q.append((i, let))
    visited[i] = let
    cnt_j = 1 if let == 'J' else 0
    while q:
        c_i, c_let = q.popleft()
        n_let = 'F' if c_let == 'J' else 'J'
        for n_i in edges[c_i]:
            if visited[n_i] != -1:
                if visited[n_i] == c_let:
                    return -1
                continue
            q.append((n_i, n_let))
            visited[n_i] = n_let
            if n_let == 'J':
                cnt_j += 1
    return cnt_j


ans = 0
for i in range(1, n+1):
    if visited_f[i] != -1:
        continue
    visited_f[i] = 'F'
    visited_j[i] = 'J'
    cnt_j_1 = bfs(visited_f, i, 'F')
    cnt_j_2 = bfs(visited_j, i, 'J')
    if cnt_j_1 == -1 and cnt_j_2 == -1:
        print(-1)
        exit()
    elif cnt_j_1 > cnt_j_2:
        ans += cnt_j_1
    else:
        ans += cnt_j_2

print(ans)
