from sys import stdin
from heapq import heappush, heappop

n, m = map(int, stdin.readline().split())

edges = [[] for _ in range(n+1)]

for _ in range(m):
    f1, f2, cost = map(int, stdin.readline().split())
    edges[f1].append((f2, cost))
    edges[f2].append((f1, cost))

dist = [500000000 for _ in range(n+1)]
pq = [(0,1)]
while pq:
    cur_cost, cur_id = heappop(pq)
    if dist[cur_id] < cur_cost: continue
    for next_id, next_cost in edges[cur_id]:
        if dist[next_id] <= cur_cost + next_cost: continue
        dist[next_id] = cur_cost + next_cost
        heappush(pq, (cur_cost + next_cost,  next_id))

print(dist[n])
