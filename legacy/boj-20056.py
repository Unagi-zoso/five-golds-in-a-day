# 사이클
# turn
# 겹쳤을때 대처
from math import floor

N, M, K = map(int, input().split())

board = [[[] for _ in range(N)] for _ in range(N)]

f_stk = []
for _ in range(M): # m: 질량 d: 방향 s: 속력
    r, c, m, s, d = map(int, input().split())
    board[r-1][c-1].append((m, d, s))
    f_stk.append((r-1, c-1))

dir = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
for t in range(K):
    next_stk = []
    n_board = [[0 for _ in range(N)] for _ in range(N)]
    colli = []
    while f_stk:
        f_r, f_c = f_stk.pop()
        while board[f_r][f_c]:
            m, d, s = board[f_r][f_c].pop()
            n_r, n_c = f_r + (dir[d][0] * s), f_c + (dir[d][1] * s)
            if n_r < 0:
                x = int((-n_r)/N)
                if (-n_r)%N != 0:
                    x += 1
                n_r = N * x + n_r
            elif n_r >= N:
                n_r %= N
            if n_c < 0:
                x = int((-n_c)/N)
                if (-n_c)%N != 0:
                    x += 1
                n_c = N * x + n_c
            elif n_c >= N:
                n_c %= N

        
            if n_board[n_r][n_c] == 0:
                n_board[n_r][n_c] = (False, True, m, d, s, 1) # 충돌있는지, 짝수, 홀수 지속인지
                colli.append((n_r, n_c))
            else:
                rst = n_board[n_r][n_c][1] and n_board[n_r][n_c][3] % 2 == d % 2 
                n_board[n_r][n_c] = (True, rst, n_board[n_r][n_c][2]+m, d, n_board[n_r][n_c][4]+s, n_board[n_r][n_c][5]+1)
    new_board = [[[] for _ in range(N)] for _ in range(N)]
    for n_r, n_c in colli:
        col_f, cor_f, m, d, s, ans = n_board[n_r][n_c]
        if col_f:
            n_m = floor(m/5)
            if n_m == 0:
                continue
            n_s = floor(s/ans)
            if cor_f:
                for n_d in range(0, 7, 2):
                    new_board[n_r][n_c].append((n_m, n_d, n_s))
            else:
                for n_d in range(1, 8, 2):
                    new_board[n_r][n_c].append((n_m, n_d, n_s))
        else:
            new_board[n_r][n_c].append((m,d,s))
    f_stk = colli
    board = new_board

ans = 0
for i in range(N):
    for j in range(N):
        if board[i][j] != []:
            for m,d,s in board[i][j]:
                ans += m

print(ans)




        
        
