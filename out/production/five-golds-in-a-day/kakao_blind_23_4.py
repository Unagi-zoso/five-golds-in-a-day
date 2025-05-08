def solution(numbers):
    def rec(idx, s):
        if answer[idx] == 0 or (rt_idx := len(s)//2) == 0:
            return
        
        if s[rt_idx] == '0' and ('1' in s):
            answer[idx] = 0
        else:
            rec(idx, s[:rt_idx]), rec(idx, s[rt_idx+1:])
            
    answer = [1 for _ in range(len(numbers))]
    for idx, n in enumerate(numbers):
        t_b = bin(n)[2:]
        l_b, i = len(t_b), 1
        while l_b >= i:
            i *= 2
        t_b = t_b.rjust(i-1, '0')
        rec(idx, t_b)
    return answer


