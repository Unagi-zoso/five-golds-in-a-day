from collections import defaultdict
from math import floor

def solution(enroll, referral, seller, amount):
    answer = []
    mem_amount_h = defaultdict(int)
    mem_ref_h = dict()
    amount = [100 * i for i in amount]
    
    for m_i in range(len(enroll)):
        mem_ref_h[enroll[m_i]] = referral[m_i]
        
    for s in range(len(seller)):
        cur = seller[s]
        money = amount[s]
        
        while True:
            if mem_ref_h[cur] == "-":
                mem_amount_h[cur] += money - floor(10 * (money / 100))
                break
            mem_amount_h[cur] += money - floor(10 * (money / 100))
            money = floor(10 * (money / 100))
            if money <= 0:
                break
            cur = mem_ref_h[cur]
    
    for s in enroll:
        answer.append(mem_amount_h[s])      
        
    return answer
