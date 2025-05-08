import heapq
from collections import defaultdict

def solution(n, paths, gates, summits):
    answer = []
    adjcent = [[] for i in range(n+1)]
    for i, j, c in paths:
        adjcent[i].append((j,c))
        adjcent[j].append((i,c))
    
    dp = [999999999 for _ in range(n+1)]
    hq = []
    state = [0 for _ in range(n+1)]
    for g in gates:
        state[g] = 1
        dp[g] = 0
        heapq.heappush(hq, (0, g))

    for s in summits:
        state[s] = 2
    
    while hq:
        c_c, c_n = heapq.heappop(hq)
        if state[c_n] == 2 or c_c > dp[c_n]:
            continue
        for n_n, n_c in adjcent[c_n]:
            det_n_c = max(dp[c_n], n_c)
            if det_n_c < dp[n_n]:
                dp[n_n] = det_n_c
                heapq.heappush(hq, (det_n_c, n_n))

    ans = []
    for s in summits:
        ans.append([s,dp[s]])
    ans.sort(key = lambda x: (x[1], x[0]))
    return ans[0]
