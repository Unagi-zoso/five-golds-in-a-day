def strategy1(name, nonACnt):
    ret = 0
    if name[0] != 'A': ret += 1
    
    nonALeftCnt = 0
    nonARightCnt = 0
    
    lName = name[1:][::-1]
    rName = name[1:]
    
    for i in range(len(lName)):
        if lName[i] != 'A':
            nonALeftCnt = i + 1
            ret += 1
            if ret == nonACnt:
                return nonALeftCnt + 2 * nonARightCnt
               
        if rName[i] != 'A':
            nonARightCnt = i + 1
            ret += 1
            if ret == nonACnt:
                return 2 * nonALeftCnt + nonARightCnt
    print("Impossible..") 
    return -1
        
def strategy2(name, nonACnt):
    lName = name[1:][::-1]
    rName = name[1:]
    
    lCnt, rCnt = 0, 0
    if name[0] != 'A':
        lCnt += 1
        rCnt += 1
    
    for i in range(len(lName)):
        if lName[i] != 'A':
            lCnt += 1
            if lCnt == nonACnt:
                return i + 1
        if rName[i] != 'A':
            rCnt += 1
            if rCnt == nonACnt:
                return i + 1
    print("Impossible..2") 
    return -2

def getOptAlpha(c):
    return min(ord(c) - ord('A'), ord('Z') - ord(c) + 1)

def solution(name):
    nonACnt = 0
    for c in name:
        if c != 'A':
            nonACnt += 1
    
    if nonACnt == 0: return 0
    if nonACnt == 1 and name[0] != 'A':
        return getOptAlpha(name[0])    
                
    answer = 0
    answer += min(strategy1(name, nonACnt), strategy2(name, nonACnt))
    
    for c in name:
        answer += getOptAlpha(c)
                  
    return answer
