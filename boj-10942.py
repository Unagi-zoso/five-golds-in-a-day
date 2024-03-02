n = int(input())
nums = [0]+list(map(int, input().split()))
m = int(input())

dp = [[-1 for _ in range(2005)] for _ in range(2005)]

for i in range(n):
    for j in range(1, n):
        if j+i > n:
            break
        if j == j+i:
            dp[j][j+i] = True
        elif j+1 == j+i:
            dp[j][j+i] = nums[j] == nums[j+i]
        else:
            dp[j][j+i] = nums[j] == nums[j+i] and dp[j+1][j+i-1]
    
for _ in range(m):
    i, j = map(int, input().split())
    print(1 if dp[i][j] else 0)