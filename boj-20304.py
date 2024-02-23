from collections import deque

n = int(input())
m = int(input())
attacker_pwd = list(map(int, input().split()))
MAX_PWD = n

visited = [False for _ in range(MAX_PWD+1)]

q = deque()

answer = 0
for a_pwd in attacker_pwd:
    q.append((a_pwd, 0))
    visited[a_pwd] = True

while q:
    c_pwd, c_dist = q.popleft()
    for i in range(20):
        n_pwd = c_pwd ^ (1 << i)
        if n_pwd > MAX_PWD or visited[n_pwd]:
            continue
        visited[n_pwd] = True
        q.append((n_pwd, c_dist+1))
        answer = max(answer, c_dist+1)

print(answer)
