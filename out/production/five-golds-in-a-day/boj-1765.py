u_info = [i for i in range(1005)]
e_info = [set() for _ in range(1005)]
n = int(input())
m = int(input())

def find(i):
    global u_info
    if i == u_info[i]:
        return i
    return find(u_info[i])

def union(i, j):
    root_i = find(i)
    root_j = find(j)
    u_info[root_i] = root_j

for _ in range(m):
    t, lhs, rhs = input().split()
    lhs = int(lhs)
    rhs = int(rhs)

    if t == 'F':
        union(lhs, rhs)
    elif t == 'E':
        for f in e_info[rhs]:
            union(lhs, f)
        for f in e_info[lhs]:
            union(rhs, f)
        e_info[lhs].add(rhs)
        e_info[rhs].add(lhs)

ans = 0
for i in range(1, n+1):
    if i == u_info[i]: ans+=1

print(ans)
    