from sys import stdin
from queue import Queue

R, C = list(map(int, stdin.readline().split()))
board = [list(stdin.readline().strip()) for _ in range(R)]

d_x = [+1, -1, 0, 0]
d_y = [0, 0, -1, 1]

def fall_down(h, cluster):
    for i in range(R-1, -1, -1):
        for j in range(C-1, -1, -1):
            if cluster[i][j] == 1:
                board[i+h][j] = 'x'
                board[i][j] = '.'
    
def get_min_height_to_other_clusters_or_base(cluster):
    this_cluster_q = list()
    for i in range(R):
        for j in range(C):
            if cluster[i][j] == 1:
                this_cluster_q.append((i, j, 0))

    while this_cluster_q:
        mineral = this_cluster_q.pop(0)
        ny = mineral[0] + d_y[3]
        x = mineral[1]
        height = mineral[2]+1

        if ny >= R: continue
        if cluster[ny][x] == 1: continue

        if board[ny][x] == 'x':
            return height - 1
        if ny == R-1:
            return height
        
        
        this_cluster_q.append((ny, x, height))

def get_cluster(m):
    is_stable = False
    cluster = [[0] * (C+2) for _ in range(R+2)]
    this_cluster_q = list()
    
    this_cluster_q.append((m[0], m[1]))
    if m[0] == R-1: is_stable = True

    cluster[m[0]][m[1]] = 1
    while (this_cluster_q):
        ty, tx = this_cluster_q.pop(0)

        for nd in range(4):
            ny = ty + d_y[nd]
            nx = tx + d_x[nd]
            if nx >= C or nx < 0 or ny >= R or ny < 0: continue
            if board[ny][nx] == '.': continue
            if cluster[ny][nx] == 1: continue

            if ny == R-1: is_stable = True
            
            cluster[ny][nx] = 1
            this_cluster_q.append((ny, nx))
    
    return (cluster, is_stable)

def destroy(dir, h):
    h = R-h
    x = (C-1) * dir
    for _ in range(C):
        if board[h][x] == "x":
            board[h][x] = "."
            return (h, x)
        x += d_x[dir]

    return (-1, -1)

def show_board():
    for i in range(R):
        for j in range(C):
            print(board[i][j], end="")
        print()

num_of_turn = stdin.readline() 
turn = 0
for height in list(map(int,stdin.readline().split())):
    destroied_pos = destroy(turn%2, height)
    turn += 1

    if destroied_pos[0] == -1: continue # 제거되지 않은 경우
    
    for d in range(4): # 제거된 이후 영향 받은 4방향의 미네랄 클러스터를 대상으로 확인
        nx = destroied_pos[1] + d_x[d]
        ny = destroied_pos[0] + d_y[d]

        if nx < 0 or nx >= C or ny < 0 or ny >= R: continue
        if board[ny][nx] == '.': continue
    
        cluster, is_stable = get_cluster((ny, nx)) # cluster 구성 미네랄 중 하나라도 R-1에 자리하고 있다면 변화없음, 즉 stable(안정적인)
        
        if is_stable: continue
        min_height = get_min_height_to_other_clusters_or_base(cluster) # 현재 클러스터의 미네랄 중 다른 클러스터나 땅에 닿는 거리(높이)가 가장 짧은 것을 반환한다. 
        fall_down(min_height, cluster) 
show_board()