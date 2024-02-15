# key = M, lock = N, M <= N

def rotate_right_90_degree(matrix):
    return list(zip(*matrix[::-1]))
    
    
def solution(key, lock):
    def check():
        for ori_lock_x in range(N):
            for ori_lock_y in range(N):
                if expanded_lock[N+ori_lock_y][N+ori_lock_x] != 1:
                    return False
        return True
    
    
    M = len(key)
    N = len(lock)
    
    expanded_lock = [[0 for _ in range(N*3)] for _ in range(N*3)]
    for i in range(N):
        for j in range(N):
            expanded_lock[N+i][N+j] = lock[i][j]
    
    for _rotate in range(4):
        key = rotate_right_90_degree(key)
        
        for x_key_start_point in range(N*2):
            for y_key_start_point in range(N*2):
                for x_key in range(M):
                    for y_key in range(M):
                        expanded_lock[y_key_start_point + y_key][x_key_start_point + x_key] += key[y_key][x_key]
                        
                if check():
                    return True
                
                for x_key in range(M):
                    for y_key in range(M):
                        expanded_lock[y_key_start_point + y_key][x_key_start_point + x_key] -= key[y_key][x_key]
    
    return False
