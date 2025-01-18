from sys import stdin

for _ in range(int(input())):
    k = int(input())
    li = [0] + list(map(int, stdin.readline().split()))

    dp = [[0] * (k+1) for _ in range(k+1)]
    
    sum_li = [0] * (k+1)
    sum_li[1] = li[1]
    for s_idx in range(2, k+1):
        sum_li[s_idx] = sum_li[s_idx-1] + li[s_idx]

    for len in range(2, k+1):
        for i in range(1, k-len+2):
            dp[i][i+len-1] = min(dp[i][j] + dp[j+1][i+len-1] for j in range(i, i+len-1)) + sum_li[i+len-1] - sum_li[i-1]

    print(dp[1][k])

