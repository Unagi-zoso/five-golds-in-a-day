def fully_check(answer):
    for x, y, _type in answer:
        if _type == 0: # 기둥                          
            if y == 0 or (x, y-1, 0) in answer or (x-1, y, 1) in answer or (x, y, 1) in answer:
                continue
            return False
        else: # 보                
            if (x, y-1, 0) in answer or (x+1, y-1, 0) in answer or ((x-1, y, 1) in answer and (x+1, y, 1) in answer):
                continue
            return False
    return True

        
def solution(n, build_frame):
    answer = []
    for x, y, _type, oper in build_frame: # 1000
        if oper == 0: # 삭제
            answer.remove((x, y, _type))
            if not fully_check(answer):
                answer.append((x, y, _type))
        else: # 설치
            answer.append((x, y, _type))            
            if not fully_check(answer):
                answer.pop()
    return sorted(answer)
