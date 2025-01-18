EMPTY_VAL = "EMPTY"
mx_r, mx_c = 51, 51
union_t = [[(r, c) for c in range(mx_c)] for r in range(mx_r)]
value_t = [[EMPTY_VAL for _ in range(mx_c)] for _ in range(mx_r)]
answer = []

def check(pos1, pos2):
    return pos1[0] == pos2[0] and pos1[1] == pos2[1]

def find(idx):
    if check(union_t[idx[0]][idx[1]], idx):
        return idx
    return find(union_t[idx[0]][idx[1]])

def update_r_c_val(r, c, val):
    idx = find((r,c))
    value_t[idx[0]][idx[1]] = val

def update_val_val(v1, v2):
    for i in range(mx_r):
        for j in range(mx_c):
            if not check(idx := find((i,j)), (i,j)) or value_t[idx[0]][idx[1]] != v1:
                continue
            value_t[idx[0]][idx[1]] = v2

def merge(r1, c1, r2, c2):
    dest1 = find((r1,c1))
    dest2 = find((r2,c2))
    if check(dest1, dest2): return
    if value_t[dest1[0]][dest1[1]] == EMPTY_VAL:    
        union_t[dest1[0]][dest1[1]] = find((r2,c2))
        value_t[dest1[0]][dest1[1]] = value_t[r2][c2]
    else:        
        union_t[dest2[0]][dest2[1]] = find((r1,c1))
        value_t[dest2[0]][dest2[1]] = value_t[r1][c1]

def unmerge(r1, c1):
    q = []
    ori = find((r1, c1))   
    ori_val = value_t[ori[0]][ori[1]]
    for i in range(mx_r):
        for j in range(mx_c):
            if check(find((i,j)), ori):
                q.append((i,j))

    while q:
        i, j = q.pop()
        union_t[i][j] = (i,j)
        value_t[i][j] = EMPTY_VAL

    value_t[r1][c1] = ori_val


def _print(r, c):
    idx = find((r,c))
    answer.append(value_t[idx[0]][idx[1]])
    
def solution(commands):
    for cmd in commands:
        tkn = cmd.split()
        if tkn[0] == "UPDATE":
            if len(tkn) == 4:
                update_r_c_val(int(tkn[1]), int(tkn[2]), tkn[3])
            elif len(tkn) == 3:
                update_val_val(tkn[1], tkn[2])
        elif tkn[0] == "MERGE":
            merge(int(tkn[1]), int(tkn[2]), int(tkn[3]), int(tkn[4]))
        elif tkn[0] == "UNMERGE":
            unmerge(int(tkn[1]), int(tkn[2]))
        elif tkn[0] == "PRINT":
            _print(int(tkn[1]), int(tkn[2]))

    return answer
