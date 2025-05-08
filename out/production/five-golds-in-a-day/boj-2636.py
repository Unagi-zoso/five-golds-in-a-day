import queue

board = [[0 for _ in range(105)] for _ in range(105)]
is_visit = [[0 for _ in range(105)] for _ in range(105)]
edge_q = queue.Queue()
bfs_q = queue.Queue()
num_of_cheese = 0

R, C = map(int, input().split())

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def print_board_debug():
    for i in range(R):
        for j in range(C):
            print(board[i][j], end=' ')
        print()   
    print(num_of_cheese)

def check_edge():
    erased_cheese_in_this_turn = 0
    while (True):
        if bfs_q.empty(): break
        pos = bfs_q.get()
        c_x, c_y = pos[0], pos[1]
        for nxt in range(4):
            n_x = c_x + dx[nxt]
            n_y = c_y + dy[nxt]

            if n_x < 0 or n_x >= C or n_y < 0 or n_y >= R:
                continue
            if is_visit[n_y][n_x] == 0 and board[n_y][n_x] == 1:
                edge_q.put((n_x, n_y))
                is_visit[n_y][n_x] = 1
                erased_cheese_in_this_turn += 1
                continue
            if is_visit[n_y][n_x] == 0 and board[n_y][n_x] == 0:
                bfs_q.put([n_x, n_y])
                is_visit[n_y][n_x] = 1
    return erased_cheese_in_this_turn

for i in range(R):
    snippet = list(map(int, input().split()))
    for j in range(len(snippet)):
        if snippet[j] == 1: 
            num_of_cheese += 1
        board[i][j] = snippet[j]

time = 0
while (True):
    time += 1
    bfs_q.put([0,0])
    is_visit = [[0 for _ in range(105)] for _ in range(105)]

    erased_cheese = check_edge()

    if num_of_cheese - erased_cheese == 0:
        print(time)
        print(erased_cheese)
        break
    
    num_of_cheese -= erased_cheese

    while not edge_q.empty():
        e_q = edge_q.get()
        board[e_q[1]][e_q[0]] = 0



        