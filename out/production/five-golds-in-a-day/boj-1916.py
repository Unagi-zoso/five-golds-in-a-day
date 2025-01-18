from sys import stdin
from heapq import heappush, heappop

n = int(stdin.readline())
m = int(stdin.readline())

edges = [[] for _ in range(n+1)]

for _ in range(m):
    f1, f2, cost = map(int, stdin.readline().split())
    edges[f1].append((f2, cost))

st, dst = map(int, stdin.readline().split())

dist = [500000000 for _ in range(n+1)]
pq = [(0,st)]
while pq:
    cur_cost, cur_id = heappop(pq)
    if dist[cur_id] < cur_cost: continue
    for next_id, next_cost in edges[cur_id]:
        if dist[next_id] <= cur_cost + next_cost: continue # 비용 0일 시 순환 방지.
        dist[next_id] = cur_cost + next_cost
        heappush(pq, (cur_cost + next_cost,  next_id))

print(dist[dst])
