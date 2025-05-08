def solution(board, skill):
    mx_r = len(board)
    mx_c = len(board[0])
    total_degree = [[0 for _ in range(mx_c+1)] for _ in range(mx_r+1)]
    
    type_assign = [999, -1, 1]
    for type, r1, c1, r2, c2, degree in skill:
        total_degree[r1][c1] += (type_assign[type] * degree)
        total_degree[r1][c2+1] += (type_assign[type] * -degree)
        total_degree[r2+1][c1] += (type_assign[type] * -degree)
        total_degree[r2+1][c2+1] += (type_assign[type] * degree) # r1,c2+1 케이스와 r2+1,c1 케이스에서 두 번 degree를 뺴버려 한 번 복구
    
    for r in range(mx_r):
        for c in range(mx_c):
            total_degree[r+1][c] += total_degree[r][c]
            total_degree[r][c+1] += total_degree[r][c]
            total_degree[r+1][c+1] -= total_degree[r][c]

    answer = 0
    for r in range(mx_r):
        for c in range(mx_c):
            if board[r][c] + total_degree[r][c] >= 1:
                answer += 1
    return answer
