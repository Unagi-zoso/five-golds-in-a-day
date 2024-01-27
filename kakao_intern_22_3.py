INF = 999999
def solution(alp, cop, problems):
    max_alg = 0
    max_cop = 0
    for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
        max_alg = max(max_alg, alp_req)
        max_cop = max(max_cop, cop_req)
        
    dp = [[INF for _ in range(max_cop+1)] for _ in range(max_alg+1)]
    alp = min(alp, max_alg)
    cop = min(cop, max_cop)
    dp[alp][cop] = 0
    
        
    for i in range(alp, max_alg+1):
        for j in range(cop, max_cop+1):
            n_i, n_j = i+1, j+1
            if n_i > max_alg:
                n_i = max_alg
            if n_j > max_cop:
                n_j = max_cop
            
            dp[i][n_j] = min(dp[i][n_j], dp[i][j]+1)
            dp[n_i][j] = min(dp[n_i][j], dp[i][j]+1)

            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if i < alp_req or j < cop_req:
                    continue
                next_alp,next_cop = min(max_alg,i + alp_rwd), min(max_cop,j + cop_rwd)
                dp[next_alp][next_cop] = min(dp[next_alp][next_cop],dp[i][j] + cost)
    return dp[max_alg][max_cop]
