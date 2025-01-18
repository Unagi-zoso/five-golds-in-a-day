from sys import stdin 

N = int(stdin.readline())
li = list(map(int, stdin.readline().split()))
ans = 0

for _ in range(N-1):
    idx = li.index(max(li))
    target_idx = 0
    if (idx - 1 < 0): target_idx = idx + 1
    elif (idx + 1 > len(li) - 1): target_idx = idx - 1
    elif(li[idx] - li[idx - 1] < li[idx] - li[idx + 1]): target_idx = idx - 1
    else: target_idx = idx + 1

    print(idx, target_idx)
    ans += li[idx] - li[target_idx]

    li.remove(li[idx])

print(ans)