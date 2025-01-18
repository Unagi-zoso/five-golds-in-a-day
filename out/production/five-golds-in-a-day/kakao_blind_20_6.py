from itertools import permutations
import math

def solution(n, weak, dist):
    answer = math.inf
    for start in range(len(weak)):        
        for i in permutations(range(len(dist))): # 10000 직원 고르는 모든 경우의 수
            pos = start
            cnt = 1
            solved = 1
            for j in i: # 100 # 
                for k in range(1, len(weak)): # 8
                    next_pos = math.floor((pos + k) % len(weak))
                    diff = weak[next_pos] - weak[pos]
                    if diff < 0:
                        diff += n                    
                    if diff > dist[j]: # 다음 직원 써야함
                        cnt += 1
                        if cnt > len(dist):
                            break
                        solved += 1
                        pos = next_pos
                        if solved >= len(weak):
                            answer = min(answer, cnt)
                        break                    
                    solved += 1
                    if solved >= len(weak):
                        answer = min(answer, cnt)
                        break
                if solved >= len(weak):
                    break
                    
    if math.inf == answer:
        return -1
        
    return answer
