from collections import deque

indegrees = [[] for _ in range(1000005)]
outdegrees = [[] for _ in range(1000005)]
visited = [0 for _ in range(1000005)]
q = deque()

# visited 체크하면서 모든 루트 다 찾아봐
# 4가지 타입 존재
# 1. 돌다가 회귀하며 소실
# 2. 회귀하지 않고 소실
# 3. 하나라도 두 가지로 뻗어나감
# 4. 2개 이상 나가는거만 있음
def check_type(st):
    q.append(st)
    visited[st] = 1
    while q:
        n = q.pop()
        if len(outdegrees[n]) >= 2:
            return 3
        for n_n in outdegrees[n]:            
            if visited[n_n] == 1:
                return 1
            visited[n_n] = 1
            q.append(n_n)
    return 2


def solution(edges):    
    mn_n, mx_n = 1000005, -1
    for e in edges:
        frm, to = e
        indegrees[to].append(frm)
        outdegrees[frm].append(to)
        mn_n = min(mn_n, frm, to)
        mx_n = max(mx_n, frm, to)
        
    st = -1
    for n in range(mn_n, mx_n+1):
        if len(indegrees[n]) == 0 and len(outdegrees[n]) >= 2:
            st = n
    
    visited[st] = 1
    
    answer = [0 for _ in range(4)]
    for i in outdegrees[st]:
        answer[check_type(i)] += 1    

    answer[0] = st    
    
    return answer
