from math import ceil

n = int(input())
parti = list(map(int, input().split()))
b, c = map(int, input().split())

ans = 0

for p in range(len(parti)):
    parti[p] -= b
    ans += 1
    if parti[p] <= 0:
        continue
    ans += ceil(parti[p] / c)

print(ans)