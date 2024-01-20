M = 28


def sepa_units(str):
    return list(map(int, str.split('.')))


def calcu_gap(today, created):
    Y = 12
    global M
    ret = 0

    carry_days = 0
    if today[2] - created[2] < 0:
        carry_days = 1
        today[2] += M
    ret += today[2] - created[2]
    
    carry_month = 0
    if today[1] - created[1] - carry_days < 0:
        carry_month = 1
        today[1] += Y
    ret += M * (today[1] - created[1] - carry_days)
    
    ret += Y * M * (today[0] - created[0] - carry_month)
    
    return ret
    

def solution(today, terms, privacies):    
    answer = []
    t_h = dict()
    for t in terms:
        in_t = t.split()
        t_h[in_t[0]] = int(in_t[1])
    
    for p in range(1, len(privacies)+1):
        in_p = privacies[p-1].split()
        gap = calcu_gap(sepa_units(today), sepa_units(in_p[0]))
        if gap >= t_h[in_p[1]] * M:
            answer.append(p)
    return answer
