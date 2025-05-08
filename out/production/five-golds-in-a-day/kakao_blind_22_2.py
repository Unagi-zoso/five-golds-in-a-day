import math

def solution(n, k):
    answer = 0
    
    def cal_system_num(n, k):
        ret = ""
        
        while n >= k:
            ret = str(int(n%k)) + ret
            n = int(n/k)
        if not n == 0:
            ret = str(n) + ret
        return ret
    
    def check_prime(p):
        if p == 1:
            return False
        for i in range(2, int(math.sqrt(p))+1):
            if p % i == 0:
                return False
        return True
    
    system_num = cal_system_num(n, k)
    
    for candi in system_num.split('0'):
        if candi == "":
            continue
        if check_prime(int(candi)):
            answer += 1
    return answer
