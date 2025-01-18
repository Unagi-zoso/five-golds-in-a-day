import sys  # lcs 사용, 0번대 인덱스에 0패딩을 줘서 인덱스 계산이 어려워요
        
def find_lcs_and_make_new_word(x, y, s, l_t_s, r_t_s): # x, y 최장 공통 부분수열을 찾기 위한 시작 좌표
    global lcs                                       # s는 새로 만들어질 단어

    if lcs[y][x] == 0: 
        s = rhs[0:y] + s
        s = lhs[0:x] + s
        return s

    if lcs[y][x-1] == lcs[y][x]:
        
        l_t_s = lhs[x-1] + l_t_s
        return find_lcs_and_make_new_word(x-1, y, s, l_t_s, r_t_s)
    elif lcs[y-1][x] == lcs[y][x]:
        
        r_t_s = rhs[y-1] + r_t_s
        return find_lcs_and_make_new_word(x, y-1, s, l_t_s, r_t_s)
    else:
        
        s = r_t_s + s
        s = l_t_s + s
        s = lhs[x-1] + s     
        return find_lcs_and_make_new_word(x-1, y-1, s, "", "")

while True:
    lcs = [[0 for _ in range(105)] for _ in range(105)]

    try:
        lhs, rhs  = sys.stdin.readline().split()

    except:
        break

    for i in range(1, len(rhs)+1):
        for j in range(1, len(lhs)+1):
            if rhs[i-1] == lhs[j-1]:
                lcs[i][j] = lcs[i-1][j-1] + 1
            else:
                lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])
    
    ans = find_lcs_and_make_new_word(len(lhs), len(rhs), "", "", "")
    print(ans)
