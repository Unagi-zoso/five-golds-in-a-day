n = int(input())
m = int(input())
vips = dict() 
for _ in range(m):
    vips[int(input())] = True

dp = [0] * 400

dp[0] = 1
dp[1] = 1
def rec(i):
    global vips
    if i == 1:
        return 1
    if dp[i] != 0: return dp[i]
    if vips.get(i) == None and vips.get(i-1) == None:
        dp[i] = rec(i-1) + rec(i-2)
    else:
        dp[i] = rec(i-1)
    return dp[i]

print(rec(n))
