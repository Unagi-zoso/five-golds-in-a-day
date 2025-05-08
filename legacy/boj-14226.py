from collections import deque

s = int(input())

INF = float('inf')
dist = [[INF for _ in range(2005)] for _ in range(2005)]

q = deque()
q.append((1, 1, 1))
dist[1][1] = 0

# 클립에 의해 최적의 값이 나온다면?
while q:
    node, clip, cost = q.popleft()
    if node+clip < 2005 and cost+1 < dist[node+clip][clip]: 
        dist[node+clip][clip] = cost+1
        q.append((node+clip, clip, cost+1))
    if node != clip and cost+1 < dist[node][node]:
        dist[node][node] = cost+1 
        q.append((node, node, cost+1))
    if node-1 > 1 and cost+1 < dist[node-1][clip]: 
        dist[node-1][clip] = cost+1
        q.append((node-1, clip, cost+1))

print(min(dist[s]))
