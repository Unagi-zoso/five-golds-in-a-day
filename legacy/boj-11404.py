from sys import stdin

n = int(stdin.readline())
m = int(stdin.readline())

INF = 987654321
matrix =[[INF] * 103 for _ in range(103)]

for _ in range(m):
    frm, to, cost = list(map(int, stdin.readline().split()))
    matrix[frm][to] = min(matrix[frm][to], cost)

for i in range(n, 0, -1):
    for j in range(1, n+1):
        for k in range(1, n+1):
            if j == k: continue
            matrix[j][k] = min(matrix[j][k], matrix[j][i] + matrix[i][k])

for i in range(1, n+1):
    for j in range(1, n+1):
        print(matrix[i][j]%INF, end=" ")
    print()