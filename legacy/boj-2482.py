# 이웃한거 없이 n,k 게다가 순환이다
# 5, 1 = 5개 가능
# 5, 2 = 10개 가능? 1 3, 1 4, 2 4, 2 5, 3 5 3 1, 4 1, 4 2, 5 2, 5 3 ( 순열에서는 10개 순서 상관없는 조합으로 따져야겠지 )
# 5, 2 = 1 3, 1 4, 2 4, 2 5, 3 5
# 5, 3 = 1 3 5 # 불가 과반 이상을 가지려했다.
# 4, 2 = 1 3, 2 4

# 고를 때 마다 산하로 새로운 분기? 5 1 4 1 곱? 
n = int(input())
k = int(input())
visit = [False] * 1005
nums = [i for i in range(1, n+1)]

def get_nei(i):
    global n
    l = i-1 if i-1 >= 1 else n
    r = i+1 if i+1 <= n else 1
    return l, r
x = 0
ans = 0
def sol(ff, ck, st):
    global n, k, visit, nums, ans, x    
    if ck == k:
        ans+=1
        print(st)
        return
    nei = []
    x += 1
    #print(x)
    for i in range(ff, n):
        sel = nums[i]
        if visit[sel]: continue
        visit[sel] = True
        nei.append(sel)
        l, r = get_nei(sel)
        if visit[l] == False:
            visit[l] = True
            nei.append(l)
        if visit[r] == False:
            visit[r] = True
            nei.append(r)
        sol(i+1, ck+1, st+" "+str(sel))
        while nei:
            visit[nei.pop()] = False

sol(0,0, "")

print(ans)
        
    


    