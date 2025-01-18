# modular로 싸이클 구현
# sliding window로 진행

import sys

# 현재 윈도우 안의 각 초밥 수량  
sushi_flag_list = [0 for _ in range(3005)] 

# 입력받는 테이블의 초밥들
sushi_list = [0 for _ in range(30005)]
ans = -1
cnt = 0

N, d, k, c = map(int, sys.stdin.readline().split())

sushi_flag_list[c] = 999999 # sliding window에서 제외되어도 0이 되질 않을 만큼 큰 수
cnt += 1

for i in range(N):
    sushi_list[i] = int(sys.stdin.readline())

# sliding window 전 첫 번째 엣지 케이스 시행 
for i in range(k):
    isTaken = sushi_flag_list[sushi_list[i]]
    if 0 == isTaken:
        cnt += 1    
    sushi_flag_list[sushi_list[i]] += 1

# sliding window 시행 k 크기의 윈도우 중 가장 일찍 들어온 값을 제외하고 새값을 추가한다.
for i in range(k, N + k):
    l_s = sushi_list[(i - k) % N]
    sushi_flag_list[l_s] -= 1
    if 0 == sushi_flag_list[l_s]: 
        cnt -= 1
    
    n_s = sushi_list[i % N]
    isTaken = sushi_flag_list[n_s]
    if 0 == isTaken:
        cnt += 1
    sushi_flag_list[n_s] += 1
    ans = max(ans, cnt)

print(ans)
