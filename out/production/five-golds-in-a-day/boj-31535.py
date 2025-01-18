from heapq import heappush, heappop

w, h = map(int, input().split())
n, d = map(int, input().split())
lanes = list(map(int, input().split()))
costs = list(map(int, input().split()))

start = (0, 0)
target = (d, w)
board = [[0 for _ in range(w+1)] for _ in range(h+1)]
st = 0
for i in range(n):    
    for j in range(st, lanes[i]+1):
        for k in range(w+1):
            board[j][k] = costs[i]
    st = lanes[i]

INF = float('INF')
dist = [[INF for _ in range(w+1)] for _ in range(h+1)]
pq = [(0, start)]
dist[0][0] = 0
dir = ((0, 1), (0, -1), (1, 0), (-1, 0))
while True:
        
    cost, pos = heappop(pq)
    y, x = pos
    if dist[y][x] < cost:
        continue
    if (y, x) == target:
        print(cost)
        exit()
    for dy, dx in dir:
        ny, nx = y + dy, x + dx
        if not (0 <= ny <= h and 0 <= nx <= w): continue
        ncost = cost + board[ny][nx] if board[ny][nx] > board[y][x] else cost + board[y][x]
        if dist[ny][nx] <= ncost: continue
        dist[ny][nx] = ncost
        heappush(pq, (ncost, (ny, nx)))


