def solution(places):
    answer = []
    def check1(p, y, x):
        dir = ((0, 1), (0, -1), (-1, 0), (1, 0))
        for d in dir:
            n_y = y + d[0]
            n_x = x + d[1]
            if n_y < 0 or n_y >= 5 or n_x < 0 or n_x >= 5:
                continue
            if p[n_y][n_x] == 'P':
                return False
        return True
    
    def check2(p, y, x):
        dir = ((1, 1), (-1, -1), (-1, 1), (-1, 1))
        partition = (((0, 1), (1, 0)), ((0, -1), (-1, 0)), ((0, 1), (-1, 0)), ((-1, 0), (0, 1)))

        for d in range(len(dir)):
            n_y = y + dir[d][0]
            n_x = x + dir[d][1]
            n_p1_y, n_p1_x = y + partition[d][0][0], x + partition[d][0][1]
            n_p2_y, n_p2_x = y + partition[d][1][0], x + partition[d][1][1] 
            if n_y < 0 or n_y >= 5 or n_x < 0 or n_x >= 5:
                continue
            if p[n_y][n_x] == 'P' and not (p[n_p1_y][n_p1_x] == 'X' and p[n_p2_y][n_p2_x] == 'X'):
                return False
        return True
    
    def check3(p, y, x):
        dir = ((0, 2), (0, -2), (-2, 0), (2, 0))
        partition = ((0, 1), (0, -1), (-1, 0), (1, 0))

        for d in range(len(dir)):
            n_y = y + dir[d][0]
            n_x = x + dir[d][1]
            n_p1_y, n_p1_x = y + partition[d][0], x + partition[d][1]
            if n_y < 0 or n_y >= 5 or n_x < 0 or n_x >= 5:
                continue
            if p[n_y][n_x] == 'P' and not p[n_p1_y][n_p1_x] == 'X':
                return False
        return True
    
    for p in places:
        flag = True
        for r in range(len(p)):
            for c in range(len(p[r])):
                if not p[r][c] == 'P':
                    continue
                if not (check1(p, r, c) and check2(p, r, c) and check3(p, r, c)):
                    flag = False
                    break
            if flag == False:
                break                
        if flag:
            answer.append(1)
        else:
            answer.append(0)
    return answer
