def solution(targets):
    answer = 0
    targets.sort(key=lambda x: x[1])
    
    i = 0
    while i < len(targets):
        answer += 1
        tEnd = targets[i][1]
        while i < len(targets) and targets[i][0] < tEnd:
            i += 1
    return answer
