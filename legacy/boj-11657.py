n, v = map(int, input().split())
INF = float("inf")
edges = []
for _ in range(v):
    s, d, c = map(int, input().split())
    edges.append((s, d, c))

dist = [INF] * (n+1)
dist[1] = 0
for turn in range(n):
    for e in edges:
        s, d, c = e
        if dist[s] == INF or dist[d] <= dist[s] + c: continue
        if turn == n-1:
            print(-1)
            exit()
        dist[d] = dist[s] + c

for i in dist[2:n+1]:
    print(i if i != INF else -1)
    