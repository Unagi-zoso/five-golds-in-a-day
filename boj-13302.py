import sys
INF = 0x3F3F3F3F
N, M = map(int, sys.stdin.readline().split())
d = [False for _ in range(103)]
p = [[0 for _ in range(106)] for _ in range(106)]
for idx in list(map(int, sys.stdin.readline().split())):
  d[idx] = True

def dp(cur_day, ticket):
  if (cur_day < 1): return 0
  if (d[cur_day]): return dp(cur_day - 1, ticket)
  cur_price = p[cur_day][ticket]
  if (cur_price != 0): return cur_price
  
  ret = min(dp(cur_day - 1, ticket) + 10000, dp(cur_day - 3, ticket + 1) + 25000, dp(cur_day - 5, ticket + 2) + 37000)
  if (ticket >= 3): ret = min(dp(cur_day - 1, ticket - 3), ret)
  p[cur_day][ticket] = ret
  return ret

print(dp(N, 0))