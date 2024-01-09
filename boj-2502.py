# 크레이지 호랑이가 어제 받은 떡, 그저께 받은 떡 받아야 할머니 목숨 보장 크레이지한 녀석이다.
# 할머니가 넘어온 D째 날 준 떡이 K개 일 때. 처음 날 준 떡과 다음 날 떡 계산. 
# 1 <= A <= B
# a b a+b a+2b 2a+3b 3a+5b
import sys

d, k = map(int, sys.stdin.readline().split())
dp = [[0,0] for _ in range(35)]

dp[1] = [1, 0]
dp[2] = [0, 1]

for i in range(3, 35):
    dp[i][0] = dp[i-1][0] + dp[i-2][0]
    dp[i][1] = dp[i-1][1] + dp[i-2][1]

for i in range(1, k + 1):
    if (int((k-dp[d][0]*i)%dp[d][1]) == 0):
        print(i, int((k-dp[d][0]*i)/dp[d][1]), sep='\n')
        break
