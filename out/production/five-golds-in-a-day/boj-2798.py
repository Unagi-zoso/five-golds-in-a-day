from itertools import combinations

n, m = map(int, input().split())
cards = list(map(int, input().split()))

ans = -1
for i, j, k in combinations(cards, 3):
    total = i+j+k
    if m >= total and total > ans:
        ans = total

print(ans)