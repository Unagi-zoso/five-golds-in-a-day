from collections import deque
from copy import deepcopy

class Gear:
    def __init__(self, li):
        self.id = 0
        self.q = deque(li)
        self.l = 0
        self.r = 0
    def get_l(self):
        return self.l
    def get_r(self):
        return self.r
    def rotate_l(self):
        t = self.q.popleft()
        self.q.append(t)
    def rotate_r(self):
        t = self.q.pop()
        self.q.appendleft(t)

gears = [Gear([*input()]) for _ in range(4)]
gears.insert(0, 0)
for i in range(1, 5):
    gears[i].id = i
def rotate(i, t):
    global gears
    l = i-1
    r = i+1
    l_f = gears[l].get_r() != gears[i].get_l() if l >= 1 else False
    r_f = gears[i].get_r() != gears[r].get_l() if r <= 4 else False
    
    if t == 1:
        gears[i].rotate_r()
    else:
        gears[i].rotate_l()
    if l >= 1 and l_f:
        if t == 1:
            rotate_l(l, 'l')
        else:
            rotate_r(l, 'l')
    if r <= 4 and r_f:
        if t == 1:
            rotate_l(r, 'r')
        else:
            rotate_r(r, 'r')
def rotate_l(i, d):
    global gears
    l = i-1
    r = i+1
    l_f = gears[l].get_r() != gears[i].get_l() if l >= 1 else False
    r_f = gears[i].get_r() != gears[r].get_l() if r <= 4 else False
    gears[i].rotate_l()
    if d == 'l' and l >= 1 and l_f:
        rotate_r(l, 'l')
    if d == 'r' and r <= 4 and r_f:
        rotate_r(r, 'r')
def rotate_r(i, d):
    global gears
    l = i-1
    r = i+1
    l_f = gears[l].get_r() != gears[i].get_l() if l >= 1 else False
    r_f = gears[i].get_r() != gears[r].get_l() if r <= 4 else False
    gears[i].rotate_r()
    if d == 'l' and l >= 1 and l_f:
        rotate_l(l, 'l')
    if d == 'r' and r <= 4 and r_f:
        rotate_l(r, 'r')

for _ in range(int(input())):
    idx, type = map(int, input().split())
    for i in range(1, 5):
        gears[i].l = deepcopy(gears[i].q[6])
        gears[i].r = deepcopy(gears[i].q[2])
    rotate(idx, type)

ans = 0
if gears[1].q[0] == '1': ans += 1
if gears[2].q[0] == '1': ans += 2
if gears[3].q[0] == '1': ans += 4
if gears[4].q[0] == '1': ans += 8

print(ans)
