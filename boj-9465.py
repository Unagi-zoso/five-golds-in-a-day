for _ in range(int(input())):
    n = int(input())
    f_l = list(map(int, input().split()))
    s_l = list(map(int, input().split()))
    if n == 1:
        print(max(f_l[0], s_l[0]))
    else:    
        dp = [[0 for _ in range(n)], [0 for _ in range(n)]]
        dp[0][0] = f_l[0]
        dp[1][0] = s_l[0]
        dp[0][1] = f_l[1] + s_l[0]
        dp[1][1] = s_l[1] + f_l[0] 
        for i in range(2, n):
            dp[0][i] = max([f_l[i] + dp[1][i-1], f_l[i] + dp[0][i-2], f_l[i] + dp[1][i-2]])
            dp[1][i] = max([s_l[i] + dp[0][i-1], s_l[i] + dp[0][i-2], s_l[i] + dp[1][i-2]])
            
        print(max(dp[0][n-1], dp[1][n-1]))
    