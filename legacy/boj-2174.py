import sys

A, B = map(int, sys.stdin.readline().split())
N, M = map(int, sys.stdin.readline().split())
board = [[0 for _ in range(105)] for _ in range(105)] # 로봇들이 움직이는 2차원 배열 평면 (로봇 존재 시 로봇의 번호, 없을 시 0)
robot_info = [[0, 0, ''] for _ in range(105)] # 로봇 번호가 인덱스로 x, y, 방향을 값으로 가짐

dir_x = {
    'N' : 0,
    'S' : 0,
    'E' : 1,
    'W' : -1
}

dir_y = {
    'N' : 1,
    'S' : -1,
    'E' : 0,
    'W' : 0
}

def rotate_robot_left(target_robot):
    c_d = robot_info[target_robot][2]

    if c_d == 'N':
        c_d = 'W'
    elif c_d == 'W':
        c_d = 'S'
    elif c_d == 'E':
        c_d = 'N'
    else:
        c_d = 'E'
    
    robot_info[target_robot][2] = c_d

def rotate_robot_right(target_robot):
    c_d = robot_info[target_robot][2]

    if c_d == 'N':
        c_d = 'E'
    elif c_d == 'W':
        c_d = 'N'
    elif c_d == 'E':
        c_d = 'S'
    else:
        c_d = 'W'
    
    robot_info[target_robot][2] = c_d

def execute_operation(target_robot, type_oper, times):
    if type_oper == 'L':
        for _ in range(times):
            rotate_robot_left(target_robot)
    elif type_oper == 'R':
        for _ in range(times):
            rotate_robot_right(target_robot)
    else:
        for _ in range(times):
            c_d = robot_info[target_robot][2]
            c_x = robot_info[target_robot][0]
            c_y = robot_info[target_robot][1]

            n_x = c_x + dir_x[c_d]
            n_y = c_y + dir_y[c_d]

            if n_x < 1 or n_x > A or n_y < 1 or n_y > B:
                return (False, 'w', target_robot)
            if board[n_y][n_x] != 0:
                return (False, 'r', target_robot, board[n_y][n_x])
            
            board[n_y][n_x] = target_robot
            board[c_y][c_x] = 0
            robot_info[target_robot] = [n_x, n_y, c_d]  
    return [True]  

# 로봇 입력
for i in range(1, N+1):
    robot_input = list(sys.stdin.readline().split())
    x = int(robot_input[0])
    y = int(robot_input[1])
    d = robot_input[2]

    board[y][x] = i
    robot_info[i] = [x, y, d]

# 명령 처리
for _ in range(M):
    oper_info = list(sys.stdin.readline().split())
    target_robot = int(oper_info[0])
    type_oper = oper_info[1]
    times = int(oper_info[2])

    result_oper = execute_operation(target_robot, type_oper, times)
    
    # 명령어 결과 판단, 문제 발생 시 result_oper[0] == False
    if False == result_oper[0]: 
        if 'w' == result_oper[1]: # 벽에 충돌한 경우
            print("Robot", result_oper[2], "crashes into the wall")
        else: # 로봇과 충돌
            print("Robot", result_oper[2], "crashes into robot", result_oper[3])
        exit()

# 정상 종료
print("OK")