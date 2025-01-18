from itertools import combinations
from bisect import bisect_left


def calculate_sum(depth, dice_list, dice_idx_list, t_sum, sum_list):
    if depth == int(len(dice_idx_list)):
        sum_list.append(t_sum)
        return
    i = dice_idx_list[depth]
    for j in range(6):
        calculate_sum(depth+1, dice_list, dice_idx_list, t_sum+dice_list[i][j], sum_list)

            
def solution(dice):
    size = int(len(dice))
    x = [i for i in range(size)]
    
    ans = 0
    max_v = 0
    for i in combinations(x, int(len(dice)/2)):
        y = list(set(x).difference(i))
        sum_resultA = []
        sum_resultB = []
        
        calculate_sum(0, dice, i, 0, sum_resultA)
        calculate_sum(0, dice, y, 0, sum_resultB)

        sum_resultA = sorted(sum_resultA)
        sum_resultB = sorted(sum_resultB)
        c_max = 0
        for j in sum_resultA:
            left = bisect_left(sum_resultB,j,0,len(sum_resultB))
            c_max += left
    
        print(c_max)
        if c_max > max_v:
            max_v = c_max
            ans = i
            
    answer = []
    for i in ans:
        answer.append(i+1)    
    return answer

# 보이는 예시를 그대로 따를 필요 없다.
# 시간 복잡도 정확히 계산해라
