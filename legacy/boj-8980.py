n, c = map(int, input().split())
m = int(input())
orders = []
for _ in range(m):
    orders.append(tuple(list(map(int, input().split()))))

orders.sort(key=lambda x: x[1])

ans = 0
trucks = [0] * (n+1)
for f, t, o_c in orders:
    mx_v = max(trucks[f:t])
    inc = o_c if mx_v + o_c <= c else c - mx_v
    ans += inc
    
    for i in range(f, t):
        trucks[i] += inc
print(ans)