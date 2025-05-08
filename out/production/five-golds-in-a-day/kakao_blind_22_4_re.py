def solution(n, info):
    def cmp(l, r):
        for i in range(10, -1, -1):
            if l[i] > r[i]:
                return True
            elif l[i] < r[i]:
                return False
            
    answer = [0]*11
    max_diff = 0
    for i in range(1<<10 + 1):
        lion_score = 0
        arrow_cnt = 0
        arrow_info = [0]*11
        apeach_score = 0
        for j in range (11):
            if i & (1<<j):
                lion_score += 10-j
                arrow_cnt += info[j] + 1
                arrow_info[j] = info[j] + 1
            else:
                if info[j] > 0:
                    apeach_score += 10-j
        if arrow_cnt > n:
            continue
        arrow_info[10] = n - arrow_cnt
        cur_diff = lion_score - apeach_score
        if lion_score > apeach_score:
            if cur_diff > max_diff:
                max_diff = cur_diff
                answer = arrow_info     
            elif cur_diff == max_diff and cmp(arrow_info, answer):
                answer = arrow_info     
    
    return answer if answer != [0]*11 else [-1]
