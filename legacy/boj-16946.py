from sys import stdin

block_cnt_each_clusters = [0 for _ in range(1005*1005)]

r, c = map(int, stdin.readline().split())

board = [list(map(int, stdin.readline().rstrip())) for _ in range(r)]
cluster_id = 1
cluster = [[0 for _ in range(c)] for _ in range(r)]
dir = ((0, 1), (0, -1), (1, 0), (-1, 0))
walls = []

for i in range(r):
    for j in range(c):
        if board[i][j] == 1:
            walls.append((i, j))
            continue
        if board[i][j] == 1 or cluster[i][j] != 0:
            continue
        q = [(i, j)]
        cluster[i][j] = cluster_id
        block_cnt_each_clusters[cluster_id] += 1
        while q:
            cy, cx = q.pop()
            for d in range(4):
                ny, nx = cy + dir[d][0], cx + dir[d][1]
                if ny < 0 or ny >= r or nx < 0 or nx >= c:
                    continue
                if board[ny][nx] == 1 or cluster[ny][nx] != 0:
                    continue
                cluster[ny][nx] = cluster_id
                q.append((ny, nx))
                block_cnt_each_clusters[cluster_id] += 1
        cluster_id += 1

answer = [[0 for _ in range(c)] for _ in range(r)]
while walls:
    duple_check = set()
    cy, cx = walls.pop()
    for d in range(4):
        ny, nx = cy + dir[d][0], cx + dir[d][1]
        if ny < 0 or ny >= r or nx < 0 or nx >= c:
            continue
        if board[ny][nx] == 1:
            continue
        duple_check.add(cluster[ny][nx])
    answer[cy][cx] = 1 + sum(block_cnt_each_clusters[i] for i in duple_check)

for i in range(r):
    for j in range(c):
        print(answer[i][j], end='')
    print()
    