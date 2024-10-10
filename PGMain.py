n = 50
gain = [0] * (n + 1)
heights = [i % 10 for i in range(n)]
st = 1
st -= 1
time = 0
target = 5
answer = 0
for oper in ['L', 'L', 'S', 'R', 'R', 'S']:
    time += 1
    if oper == 'L':
        st = (n + st - 1) % n
    elif oper == 'R':
        st = (st + 1) % n
    
    if heights[st] - gain[st] + time > target:
        rst = heights[st] - gain[st] + time - target
        gain[st] += rst
        answer += rst

