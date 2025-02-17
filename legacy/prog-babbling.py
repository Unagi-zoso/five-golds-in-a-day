# 시간복잡도 O(N * |S|)
def solution(babbling):
    def 유한상태머신(string):
        state = 0
        for ch in string:
            if state == 0:
                if ch == 'a':
                    state = 10
                    continue
                if ch == 'y':
                    state = 11
                    continue
                if ch == 'w':
                    state = 12
                    continue
                if ch == 'm':
                    state = 13
                    continue
                    
            if state == 10 and ch == 'y':
                state = 20
                continue
            if state == 11 and ch == 'e':
                state = 0
                continue    
            if state == 12 and ch == 'o':
                state = 22
                continue
            if state == 13 and ch == 'a':
                state = 0
                continue
            
            if state == 20 and ch == 'a':
                state = 0
                continue
            if state == 22 and ch == 'o':
                state = 0
                continue
            
            return False
        return state == 0
    
    answer = 0
    for 옹알옹알 in babbling:
        if 유한상태머신(옹알옹알):
            answer += 1
    return answer


# 시간복잡도 O(4 * 4! + N)
from itertools import permutations

def solution(babbling):
    d = {}
    for i in range(1, 5):
        for p in permutations(['aya', 'ye', 'woo', 'ma'], i):
            s = ""
            for c in p:
                s += c
            d[s] = True
            
    answer = 0
    for 옹알옹알 in babbling:
        if 옹알옹알 in d:
            answer += 1
    return answer
