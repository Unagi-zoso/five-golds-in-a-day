from itertools import product

def solution(n, info):
    ans = [-1]
    max_diff = 0
    info.reverse()
    for case in product((True, False), repeat=11):
        arrow_cnt = sum(info[i]+1 for i in range(11) if case[i])
        if arrow_cnt > n:
            continue
        ape_score = sum(i for i in range(11) if not case[i] and info[i])
        ly_score = sum(i for i in range(11) if case[i])
        diff = ly_score - ape_score
        if diff > max_diff:
            max_diff = diff
            ans = [info[i]+1 if case[i] else 0 for i in range(11)]
            ans[0] += n - arrow_cnt
    ans.reverse()
    return ans
