from collections import deque

def find_tail(board, c_p):
    c_pos = [c_p[0], c_p[1]]
    c_num = c_p[2]
    dir = [(0, -1), (-1, 0), (0, 1), (1, 0)]
    for d in dir:    
        n_y, n_x = c_pos[0]+d[0], c_pos[1]+d[1]
        if not (0 <= n_y < n and 0 <= n_x < n): continue
        if board[n_y][n_x] == c_num + 1:
            return (n_y, n_x, c_num + 1)

board = [[-1 for _ in range(105)] for _ in range(105)]
board[0][0] = 0
n = int(input())
k = int(input())
for _ in range(k):
    y, x = map(int, input().split())
    board[y-1][x-1] = -2
l = int(input())
schedule = deque()
for _ in range(l):
    schedule.append(list(input().split()))

LEFT, UP, RIGHT, DOWN = 0, 1, 2, 3
dir = [(0, -1), (-1, 0), (0, 1), (1, 0)]

cur_d = RIGHT

time = 0
c_pos = (0, 0)
c_tail = (0, 0, 0)
while True:
    time += 1
    n_y, n_x = c_pos[0]+dir[cur_d][0], c_pos[1]+dir[cur_d][1]
    if not (0 <= n_y < n and 0 <= n_x < n): break
    if board[n_y][n_x] >= 0: break
    c_pos = (n_y, n_x)
    n_item = board[n_y][n_x]
    board[n_y][n_x] = time
    if n_item != -2:
        board[c_tail[0]][c_tail[1]] = -1
        c_tail = find_tail(board, c_tail)
    if schedule and time == int(schedule[0][0]):
        if schedule[0][1] == 'D':
            cur_d = (cur_d+1)%4
        else:
            cur_d = (cur_d+3)%4
        schedule.popleft()

print(time)