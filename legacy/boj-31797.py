from heapq import heappush, heappop

h = []
n, m = map(int, input().split())
for i in range(1,m+1):
    h1, h2 = map(int, input().split())
    heappush(h, (h1, i))
    heappush(h, (h2, i))

for _ in range(n-1):
    c_f = heappop(h)
    heappush(h, (c_f[0] + 100000, c_f[1]))

print(heappop(h)[1])
