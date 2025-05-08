from itertools import product
from bisect import bisect_right

n, ks = map(int, input().split())
ns = len(str(n))
k = sorted(list(map(int, input().split())))

def t2n(t):
    ret = 0
    t = reversed(t)
    for i in t:
        ret *= 10
        ret += i
    return ret

candi = []
for rep in range(1, ns+1):
    for i in product(k, repeat=rep):
        candi.append(t2n(i))

candi = sorted(candi)
ans_idx = bisect_right(candi, n, 0, len(candi))-1
print(candi[ans_idx])
