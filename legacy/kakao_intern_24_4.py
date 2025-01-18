from collections import deque

def solution(coin, cards):
    lookup = [0 for _ in range(1005)]
    np1 = len(cards)+1
    st = int(len(cards)/3)
    on_hand = [cards[i] for i in range(st)]
    candi = []
    possi = deque()
    
    for i in range(st):
        lookup[cards[i]] = 1
        if lookup[np1 - cards[i]] == 1:
            lookup[cards[i]] = 5
            lookup[np1 - cards[i]] = 5
            possi.append((cards[i],np1-cards[i]))
    
    answer = 1
    for i in range(st, len(cards), 2):
        candi.append(cards[i])
        candi.append(cards[i+1])
        lookup[cards[i]] = 2
        lookup[cards[i+1]] = 2
        
        if len(possi) != 0:
            a = possi.popleft()
            answer += 1
            continue
        f1 = False
        for c in candi:
            if lookup[np1-c] == 1:
                lookup[c] = 5
                lookup[np1-c] = 5
                
                if coin-1 < 0:
                    break
                coin -= 1
                answer += 1
                f1 = True
                break
        if f1 == True:
            continue
        f2 = False
        for c in candi:
            if lookup[np1-c] == 2:
                lookup[c] = 5
                lookup[np1-c] = 5
                
                if coin-2 < 0:
                    break
                coin -= 2
                answer += 1
                f2 = True
                break
        if f2 == True:
            continue
        break
    return answer
