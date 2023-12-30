from sys import stdin

for _ in range(int(stdin.readline())):
    n, l = map(int, stdin.readline().split())
    cost_li = list(map(int, stdin.readline().split()))

    ans = 99999999999
    for i in range(l, n+1):
        cur_sum = 0
        for k in range(0, i):
            cur_sum += cost_li[k]
        ans = min(ans, cur_sum / i)

        for j in range(i, n):
            cur_sum -= cost_li[j-i]
            cur_sum += cost_li[j]
            ans = min(ans, cur_sum / i)

    print("{:.11f}".format(ans))
