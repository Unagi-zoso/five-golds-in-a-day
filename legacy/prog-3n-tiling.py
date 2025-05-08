def solution(n):
    answer = 0
    dp = [0] * 5005
    dp[2] = 3
    dp[4] = 11
    for i in range(6, 5005, 2):
        dp[i] += ((dp[i - 2] * 4) % 1_000_000_007 - (dp[i - 4]) % 1_000_000_007) % 1_000_000_007
    
    return dp[n]
