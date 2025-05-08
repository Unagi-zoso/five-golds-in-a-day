# 이번 달 선물 주고 받은 기록으로 다음달 누가 선물을 많이 받을 지 예측
# 두 사람 사이 선물을 주고 받았으면 이번 달에 더 많이 받은 사람이 다음달에 선물을 받는 다
# 주고 받은 기록이 없거나 같을 시, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받는다.
# 선물지수는 이번 달까지 자신이 친구들에게 주 ㄴ선물의 수에서 받은 선물의 수를 뺀 값
# 두 사람 간 선물 지수도 같으면 다음달 선물 주고 받지 않음

# friends 친구의 수 <= 50 알파벳 소문자, 중복 없음
# gifts 선물 주고 받은 기록, (선물을 준 친구, 선물을 받은 친구)

def solution(friends, gifts):
    answer = 0
    friend_index_h = {}
    for f in range(len(friends)):
        friend_index_h[friends[f]] = f
        
    direct_present = [[0 for _ in range(50)] for _ in range(50)]
    present_metrics = [0 for _ in range(50)]
    
    for g in gifts:
        giver, taker = g.split(' ')
        g_idx = friend_index_h[giver]
        t_idx = friend_index_h[taker]
        direct_present[g_idx][t_idx] += 1
        present_metrics[g_idx] += 1
        present_metrics[t_idx] -= 1
        
    prediction = [0 for _ in range(50)]
    for f1_idx in range(len(friends)):
        for f2_idx in range(len(friends)):
            if f1_idx == f2_idx:
                continue
            if direct_present[f1_idx][f2_idx] > direct_present[f2_idx][f1_idx]:
                prediction[f1_idx] += 1
            elif direct_present[f1_idx][f2_idx] == direct_present[f2_idx][f1_idx]:
                if present_metrics[f1_idx] > present_metrics[f2_idx]:
                    prediction[f1_idx] += 1
                    
    answer = max(prediction)
    return answer
