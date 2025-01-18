def solution(N):
    if N == 0 or N == 1: return 0

    bi = str(bin(N)[2:])
    ans = 0
    c_l = 0
    for i in range(1, len(bi)):
        if bi[i] == '1':
            ans = max(ans, c_l)
            c_l = 0
        else:
            c_l += 1
    return ans
    pass
