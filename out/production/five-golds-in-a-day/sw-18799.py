from itertools import combinations
 
T =  int(input())
 
for c_t in range(1, T+1):
    set_size = int(input())
    cur_set = list(map(int, input().split()))
     
    sum_of_avgs = 0
    for i in range(1, set_size + 1): # 기본 집합에서 몇 개를 뽑을지 정함 (최소 1개 ~ 최대 set_size)
        for s in combinations(cur_set, i): # 현재 집합에서 i개 뽑아 만들 수 있는 모든 경우를 list로 반환받는다.
            sum_of_avgs += sum(s) / i # 모든 부분 집합의 평균을 더한다. 
    print("#" + str(c_t)+ " " + str(round(sum_of_avgs / (pow(2, set_size) - 1), 20))) # 모든 부분 집합 경우의 수 = 2^set_size - 1