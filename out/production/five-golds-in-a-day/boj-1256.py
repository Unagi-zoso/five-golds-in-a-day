from math import comb as c

n, m, k = map(int, input().split())

if k > c(n+m,n):
    print(-1)
else:
    dp = [[0] * 105 for _ in range(105)]
    for i in range(1, 105):
        dp[i][0] = 1
        dp[0][i] = 1
    for i in range(1,n+3):
        for j in range(1, m+3):
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
    
    for i in range(5):
        for j in range(5):
            print(dp[i][j], end=" ")
        print()
        
    ans = ""
    while n > 0 and m > 0:
        if k <= dp[n-1][m]: # a일 때
            ans += 'a'
            n -= 1
            
        else:
            ans += 'z'
            k -= dp[n-1][m]
            m -= 1
            
    print(ans + n*"a" + m*"z")
