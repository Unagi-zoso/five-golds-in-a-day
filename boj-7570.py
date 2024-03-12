n = int(input())
m = list(map(int, input().split()))
lookup = [0] * (n+1)
for i in range(n):
    lookup[m[i]] = i

cnt = 1
mx_v = 0
for i in range(1, n):
    if lookup[i] < lookup[i+1]:
        cnt += 1
        if mx_v < cnt:
            mx_v = cnt
    else:
        cnt = 1

print(n-mx_v)
