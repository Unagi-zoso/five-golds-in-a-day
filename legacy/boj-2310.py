import sys

# dfs
def rec(cur_money, cur_num):
    type = board[cur_num][0]
    cost = board[cur_num][1]

    next_money = cur_money

    # 선 연산처리
    if 'L' == type:
        if cur_money <= cost:
            next_money = cost
    elif 'T' == type:
        next_money -= cost
    
    # 후 결과처리
    if 0 > next_money:
        return False
    if n == cur_num:
        return True

    # 이동가능한 방으로 dfs 재귀호출
    res = False
    is_visited[cur_num] = True
    for next_num in board[cur_num][2]:
        if True == is_visited[next_num]: continue
        if rec(next_money, next_num): res = True
    is_visited[cur_num] = False    

    return res

# 외부에서 입력 받아 board 초기화
def initialize_board_from_input():
    for i in range(1, n+1):
        room_info_list = list(sys.stdin.readline().split())
        
        to = []
        for to_num in range(2, len(room_info_list)-1):
            to.append(int(room_info_list[to_num]))

        type = room_info_list[0]
        cost = int(room_info_list[1])

        board[i] = (type, cost, to)

# solve
while(True):
    n = int(sys.stdin.readline())
    
    if 0 == n: break

    board = [0 for _ in range(1004)]
    is_visited = [False for _ in range(1004)]

    initialize_board_from_input()
    
    is_visited[1] = True
    result_flag = rec(0, 1)

    print("Yes") if result_flag else print("No")