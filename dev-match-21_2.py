def solution(rows, columns, queries):
    answer = []
    board = [[(columns * j) + i for i in range(1, columns+1)] for j in range(rows)]
    
    for x1, y1, x2, y2 in queries:
        x1, y1, x2, y2 = x1-1, y1-1, x2-1, y2-1        
        _set = set()
        corners = [board[x1][y1], board[x1][y2], board[x2][y2], board[x2][y1]]
        for i in reversed(range(y1+1, y2)):            
            board[x1][i+1] = board[x1][i]
            _set.add(board[x1][i+1])
        for i in reversed(range(x1+1, x2)):            
            board[i+1][y2] = board[i][y2]
            _set.add(board[i+1][y2])
        for i in range(y1+1, y2):            
            board[x2][i-1] = board[x2][i]
            _set.add(board[x2][i-1])
        for i in range(x1+1, x2):            
            board[i-1][y1] = board[i][y1]
            _set.add(board[i-1][y1])
        board[x1][y1+1] = corners[0]
        board[x1+1][y2] = corners[1]
        board[x2][y2-1] = corners[2]
        board[x2-1][y1] = corners[3]
        for i in corners:
            _set.add(i)
        answer.append(min(_set))
    return answer
