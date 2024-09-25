from sys import stdin

ROOT = 0
nextId = 1
MX = 10000 * 10 + 5
terminal = [-1] * MX
children = [[-1] * 26 for _ in range(MX)]
first = [-1] * MX
strings = []

def toNum(ch):
    return ord(ch) - ord('A')

def insert(sid):
    global ROOT, nextId, terminal, children, first, strings
    cur = ROOT
    for c in strings[sid]:        
        if children[cur][toNum(c)] == -1:
            children[cur][toNum(c)] = nextId
            first[nextId] = sid
            nextId += 1
        cur = children[cur][toNum(c)]
    terminal[cur] = sid

def find(s):
    global ROOT, nextId, terminal, children, first, strings
    cur = ROOT
    ret = 0
    for c in s:
        childId = children[cur][toNum(c)]
        if childId == -1:
            return len(s)
        ret += 1
        if terminal[childId] != -1 and strings[terminal[childId]] == s:
            return len(s)
        if strings[first[childId]] == s:
            return ret + 1
        cur = childId
    return len(s)

for _ in range(int(stdin.readline())):
    ROOT = 0
    nextId = 1
    MX = 10000 * 10 + 5
    terminal = [-1] * MX
    children = [[-1] * 26 for _ in range(MX)]
    first = [-1] * MX
    strings = []

    n, m = map(int, stdin.readline().split())

    for _ in range(n):
        s, fr = stdin.readline().split()
        fr = int(fr)

        strings.append((fr, s))
    
    strings.sort(key=lambda x: (-x[0], x[1]))

    strings = list(map(lambda x: x[1], strings))

    for sid in range(len(strings)):
        insert(sid)
    
    origin = stdin.readline()
    whspc = len(origin.split()) - 1
    ans = whspc
    for c in origin.split():
        ans += find(c)
    print(ans)
