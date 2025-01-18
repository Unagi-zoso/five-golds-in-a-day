def solution(n, tops):
    target = 2*n+1
    MOD = 10007
    dp = [[0, 0, 0, 0] for _ in range(target + 3)]
    dp[0][0] = 1
    dir = [-1, -2, -2, -1]
    for i in range(1, target+1):
        for d in range(4):
            prev_state = i + dir[d]
            if d == 0:
                dp[i][d] = (dp[prev_state][0] + dp[prev_state][1] + dp[prev_state][2] + dp[prev_state][3]) % MOD
            if d == 1:
                if i % 2 != 0 or prev_state < 0:
                    continue
                dp[i][d] = (dp[prev_state][0] + dp[prev_state][1] + dp[prev_state][3]) % MOD
            if d == 2:
                if i % 2 == 0 or prev_state < 0:
                    continue
                dp[i][d] = (dp[prev_state][0] + dp[prev_state][2]) % MOD
            if d == 3:
                if i % 2 != 0 or tops[int(i/2)-1] == 0:
                    continue
                dp[i][d] = (dp[prev_state][0] + dp[prev_state][2]) % MOD

    answer = (dp[target][0] + dp[target][1] + dp[target][2] + dp[target][3]) % MOD
    return answer
