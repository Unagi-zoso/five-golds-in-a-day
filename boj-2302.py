n = int(input())
m = int(input())
vips = dict() 
for _ in range(m):
    vips[int(input())] = True

dp = [0] * 400

dp[0] = 1
dp[1] = 1

for i in range(2, n+1):
    if vips.get(i) == None:
        if vips.get(i-1) == None:
            dp[i] += dp[i-1] + dp[i-2]
        else:
            dp[i] = dp[i-1]
    else:
        dp[i] = dp[i-1]

    
print(dp[n])
