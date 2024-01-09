from sys import stdin
from collections import deque

N = int(stdin.readline())

dp = [-1 for _ in range(505)]
graph = [[] for _ in range(505)]
degree = [0 for _ in range(505)]
costs = [0 for _ in range(505)]
for i in range(1, N+1):
    data = list(map(int, stdin.readline().split()))[:-1]
    costs[i] = data[0]    
    for j in data[1:]:
        graph[j].append(i)
        degree[i] += 1

q = deque()

for i in range(1, N+1):
    if degree[i] == 0:
        q.append(i)
        dp[i] = costs[i]

while q:
    i = q.popleft()    
        
    for j in graph[i]:
        degree[j] -= 1
        dp[j] = max(dp[j], dp[i] + costs[j])
        if degree[j] == 0:
            q.append(j)

for i in range(1, N+1):
    print(dp[i])       
    
