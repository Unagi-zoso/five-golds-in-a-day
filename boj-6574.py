import sys  # lcs 사용 0번대 인덱스에 0패딩을 줘서 인덱스 계산이 어려워요
        
def search_and_destroy(x, y, i, j, s, l, r):
    global lcs

    if lcs[x][y] == 0: 
        s = rhs[0:x] + s
        s = lhs[0:y] + s
        return s

    if lcs[x-1][y] == lcs[x][y]:
        
        l = rhs[x-1] + l
        return search_and_destroy(x-1, y, i, j, s, l, r)
    elif lcs[x][y-1] == lcs[x][y]:
        
        r = lhs[y-1] + r
        return search_and_destroy(x, y-1, i, j, s, l, r)
    else:
        
        s = l + s
        s = r + s
        s = rhs[x-1] + s     
        return search_and_destroy(x-1, y-1, x, y, s, "", "")

while True:
    lcs = [[0 for _ in range(105)] for _ in range(105)]
    alpha = [0 for _ in range(35)]

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
    
    ans = ""
    ans = search_and_destroy(len(rhs), len(lhs), len(rhs), len(lhs), ans, "", "")
    print(ans)
