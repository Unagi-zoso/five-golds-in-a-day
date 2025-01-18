INF = 99999999
def solution(n, s, a, b, fares):
    matrix = [[INF for _ in range(n)] for _ in range(n)]
    
    for i in range(n):
        matrix[i][i] = 0 
        for c, d, f in fares:
            matrix[c-1][d-1] = f
            matrix[d-1][c-1] = f
    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if matrix[i][k] + matrix[k][j] < matrix[i][j]:
                    matrix[i][j] = matrix[i][k] + matrix[k][j]
    
    return min(matrix[s-1][k] + matrix[k][a-1] + matrix[k][b-1] for k in range(n))
