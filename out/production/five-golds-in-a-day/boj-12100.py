from itertools import product
import copy

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]

def move_left(board):
    is_merged = [[False for _ in range(n+2)] for _ in range(n+2)]
    for i in range(n):
        for j in range(1, n):
            if board[i][j] == 0:
                continue
            for k in range(1, j+1):
                if board[i][j-k] == board[i][j] and not is_merged[i][j-k]:
                    board[i][j-k] += board[i][j]
                    is_merged[i][j-k] = True
                    board[i][j] = 0
                    break
                elif board[i][j-k] != 0:
                    board[i][j-k+1] = board[i][j]
                    if k != 1:
                        board[i][j] = 0
                    break
                if j-k == 0:
                    board[i][j-k] = board[i][j]
                    board[i][j] = 0

def move_right(board):
    is_merged = [[False for _ in range(n+2)] for _ in range(n+2)]
    for i in range(n):
        for j in range(n-2, -1, -1):
            if board[i][j] == 0:
                continue
            for k in range(1, n-j):
                if board[i][j+k] == board[i][j] and not is_merged[i][j+k]:
                    board[i][j+k] += board[i][j]
                    is_merged[i][j+k] = True
                    board[i][j] = 0
                    break
                elif board[i][j+k] != 0:
                    board[i][j+k-1] = board[i][j]
                    if k != 1:
                        board[i][j] = 0
                    break
                if j+k == n-1:
                    board[i][j+k] = board[i][j]
                    board[i][j] = 0
                
def move_up(board):
    is_merged = [[False for _ in range(n+2)] for _ in range(n+2)]
    for j in range(n):
        for i in range(1, n):
            if board[i][j] == 0:
                continue
            for k in range(1, i+1):
                if board[i-k][j] == board[i][j] and not is_merged[i-k][j]:
                    board[i-k][j] += board[i][j]
                    is_merged[i-k][j] = True
                    board[i][j] = 0
                    break
                elif board[i-k][j] != 0:
                    board[i-k+1][j] = board[i][j]
                    if k != 1:
                        board[i][j] = 0
                    break
                if i-k == 0:
                    board[i-k][j] = board[i][j]
                    board[i][j] = 0

def move_down(board):
    is_merged = [[False for _ in range(n+2)] for _ in range(n+2)]
    for j in range(n):
        for i in range(n-2, -1, -1):
            if board[i][j] == 0:
                continue
            for k in range(1, n-i):
                if board[i+k][j] == board[i][j] and not is_merged[i+k][j]:
                    board[i+k][j] += board[i][j]
                    is_merged[i+k][j] = True
                    board[i][j] = 0
                    break
                elif board[i+k][j] != 0:
                    board[i+k-1][j] = board[i][j]
                    if k != 1:
                        board[i][j] = 0
                    break
                if i+k == n-1:
                    board[i+k][j] = board[i][j]
                    board[i][j] = 0

def find_max_elem(board):
    max_v = -1
    for i in board:
        for j in i:
            max_v = max(max_v, j)
    return max_v


LEFT, RIGHT, UP, DOWN = 0, 1, 2, 3
ans = -1
for dir in product([LEFT, RIGHT, UP, DOWN], repeat=5):
    copied_board = copy.deepcopy(board)
    for i in range(len(dir)):
        if dir[i] == LEFT:
            move_left(copied_board)
        elif dir[i] == RIGHT:
            move_right(copied_board)
        elif dir[i] == UP:
            move_up(copied_board)
        elif dir[i] == DOWN:
            move_down(copied_board)    
    ans = max(ans, find_max_elem(copied_board))
    
print(ans)

