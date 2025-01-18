# 양팔 저울과 몇 개의 추 이용해 입력으로 주어진 구슬의 무게를 확인할 수 있는지.. 완탐인가
# 구슬은 반드시 들어가고 구슬과 추 조합을 통해서 평행을 만들어내라.

# 첫 줄 추의 개수 <= 30
# 둘 째 줄에는 가변운 것 부터 차례로 주어진다.
# 추의 무게는 500이하
# 셋 째 줄에는 확인하려는 구슬 개수 < 7
# 넷 째 줄에는 확인하고자 하는 구슬의 무게가 나타남. <= 40000 

from sys import stdin

n = int(input())
weights = list(map(int, input().split())) + [0 for _ in range(30)]
m = int(input())
balls = list(map(int, input().split()))

dp = [[False for _ in range(15005)] for _ in range(35)]

def rec(idx, weight):
    if idx > n:
        return
    if dp[idx][weight]:
        return

    dp[idx][weight] = True

    rec(idx+1, weight+weights[idx])
    rec(idx+1, abs(weight-weights[idx]))
    rec(idx+1, weight)

rec(0, 0)
for i in range(m):
    if balls[i] > 15000:
        print("N ", end='')
        continue
    if dp[n][balls[i]]:
        print("Y ", end='')
    else:
        print("N ", end='')
print()
