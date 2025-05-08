from sys import stdin

dp = [[0 for j in range(1005)] for i in range(1005)]

n = int(stdin.readline())

for i in range(10):
    dp[i][0] = 1

for i in range(1, n):
    for j in range(10):
        for k in range(j+1):
            dp[j][i] += dp[k][i-1]


def calculate_result():
    rst = 0
    for i in range(10):
        rst += dp[i][n-1]
    return rst


print(calculate_result())
