import sys

N = int(sys.stdin.readline())
l_l = list(map(int, sys.stdin.readline().split()))

l_l.sort()

near_0_sum = sys.maxsize
ans = [0, 0]

l, r = 0, N-1

while l < r:
    if abs(l_l[l] + l_l[r]) < near_0_sum:
        near_0_sum = abs(l_l[l] + l_l[r])
        ans[0], ans[1] = l_l[l], l_l[r]

    if l_l[l] + l_l[r] > 0:
        r -= 1
    else:
        l += 1

print(ans[0], ans[1])

