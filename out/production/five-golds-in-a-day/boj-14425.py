'''
# Hash
d = dict()
n, i = map(int, input().split())

for _ in range(n):
    d[input()] = True

ans = 0
for _ in range(i):
    if input() in d:
        ans += 1

print(ans)
'''

# Trie 메모리를 좀 더 효율적으로 쓸 수 있다. 탐색은 매번 찾아야해. 최대 500글자에 10,000번
# 시간성능은 Hash 가 O(n) 으로 나을 수 있는데 글자의 길이가 500글자로 작으니 Trie 가 나을지도
from sys import stdin

n, p = map(int, stdin.readline().split())

ROOT = 0
unused = 1
mx = 500 * 10000 + 5
chk = [0] * (mx)
mem = [[-1] * 26 for _ in range(mx)]

def insert(s):
    global ROOT, unused, chk, mem
    cur = ROOT
    for c in s:
        cidx = ord(c) - ord('a')
        if mem[cur][cidx] == -1:
            mem[cur][cidx] = unused
            unused += 1
        cur = mem[cur][cidx]
    chk[cur] +=  1

def find(s):
    global ROOT, unused, chk, mem
    cur = ROOT
    for c in s:
        cidx = ord(c) - ord('a')
        if mem[cur][cidx] == -1:
            return 0
        cur = mem[cur][cidx]
    if chk[cur] > 0: return 1
    return 0

for _ in range(n):
    s = stdin.readline()
    insert(s)
    
ans = 0
for _ in range(p):
    s = stdin.readline()
    ans += find(s)
    
print(ans)
