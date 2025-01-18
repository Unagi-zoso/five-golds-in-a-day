from sys import stdin

G = int(stdin.readline())
P = int(stdin.readline())
union_li = [i for i in range(G+1)]
plane_li = [int(stdin.readline()) for _ in range(P)]

def find(v):
    if v == union_li[v]:
        return v
    union_li[v] = find(union_li[v])
    
    return union_li[v]

ans = 0
for g in plane_li:
    docked_gate_num = find(g)
    if 0 == docked_gate_num: break
    union_li[docked_gate_num] = union_li[docked_gate_num - 1]
    ans += 1

print(ans)