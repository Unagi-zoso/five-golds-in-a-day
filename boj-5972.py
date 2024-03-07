from sys import stdin
from collections import defaultdict, deque
from heapq import heapify, heappush, heappop

n, m = map(int, stdin.readline().split())

edges = defaultdict(lambda: defaultdict(lambda :500000000))

for _ in range(m):
    f1, f2, cost = map(int, stdin.readline().split())
    edges[f1][f2] = min(edges[f1][f2], cost)
    edges[f2][f1] = min(edges[f2][f1], cost)

visited = [False for _ in range(n+1)]

dist = [500000000 for _ in range(n+1)]
pq = [(0,1)]
while pq:
    cur_cost, cur_id = heappop(pq)
    while visited[cur_id]:
        cur_cost, cur_id = heappop(pq)
    dist[cur_id] = cur_cost
    if cur_id == n:
        print(dist[n])
        exit()
    visited[cur_id] = True
    for next_id, next_cost in edges[cur_id].items():
        if visited[next_id]: continue
        heappush(pq, (cur_cost + next_cost,  next_id))

