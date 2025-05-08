dp = [1 for _ in range(1000005)]
hist = [1 for _ in range(1000005)]

n = int(input())

dp[1] = 0

for i in range(2, 1000005):
    cur_min = dp[i-1]
    cur_hist = i-1
    if i % 3 == 0 and cur_min > dp[int(i/3)]:
        cur_min = dp[int(i/3)]
        cur_hist = int(i/3)
    if i % 2 == 0 and cur_min > dp[int(i/2)]:
        cur_min = dp[int(i/2)]
        cur_hist = int(i/2)
    dp[i] += cur_min
    hist[i] = cur_hist

print(dp[n])
c = n
while c != 1:
    print(c, end=" ")
    c = hist[c]
print(c)  
