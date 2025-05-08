from itertools import combinations as comb

def spread(virus, spreaded_pos, N, M):
    dir = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    q = []
    for v in virus:
        q.append(v)
        while q:
            p = q.pop()
            for d in dir:
                n_y = p[0] + d[0]
                n_x = p[1] + d[1]
                if n_y < 0 or n_y >= N or n_x < 0 or n_x >= M:
                    continue
                if board[n_y][n_x] != 0:
                    continue
                board[n_y][n_x] = 5
                spreaded_pos.append((n_y, n_x))
                q.append((n_y, n_x))

def recover(spreaded_pos):
    while spreaded_pos:
        p = spreaded_pos.pop()
        board[p[0]][p[1]] = 0

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

wall_count = 3
virus = []
for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            wall_count += 1
        if board[i][j] == 2:
            virus.append((i,j))

spreaded_pos = []
cand = [(i,j) for j in range(M) for i in range(N)]

max_safety = 0
for i in comb(cand, 3):
    c1, c2, c3 = i
    if board[c1[0]][c1[1]] != 0 or board[c2[0]][c2[1]] != 0 or board[c3[0]][c3[1]] != 0:
        continue
    board[c1[0]][c1[1]], board[c2[0]][c2[1]], board[c3[0]][c3[1]] = 1, 1, 1
    spread(virus, spreaded_pos, N, M)
    max_safety = max(max_safety, N * M - len(spreaded_pos) - len(virus) - wall_count)
    recover(spreaded_pos)
    board[c1[0]][c1[1]], board[c2[0]][c2[1]], board[c3[0]][c3[1]] = 0, 0, 0

print(max_safety)
