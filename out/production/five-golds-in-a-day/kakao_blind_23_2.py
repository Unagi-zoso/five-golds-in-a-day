def solution(cap, n, deliveries, pickups):
    d_q = []
    p_q = []
    ans = 0
    for i in range(len(deliveries)):
        if deliveries[i] != 0:
            d_q.append((i+1, deliveries[i]))
        if pickups[i] != 0:
            p_q.append((i+1, pickups[i]))
        
    while d_q or p_q:
        dest = -1
        d_l = len(d_q)
        p_l = len(p_q)
        if d_l == 0 and p_l == 0:
            break
        if d_l == 0:
            dest = p_q[p_l-1][0]
        if p_l == 0:
            dest = d_q[d_l-1][0]
        if d_l != 0 and p_l != 0:
            dest = max(p_q[p_l-1][0], d_q[d_l-1][0])
        ans += dest
        c_d = 0
        while len(d_q) != 0:
            dd = d_q.pop()

            c_d += dd[1]
            if c_d > cap:
                d_q.append((dd[0], c_d - cap))
                break

        c_p = 0
        while len(p_q) != 0:
            pp = p_q.pop()

            c_p += pp[1]
            if c_p > cap:
                p_q.append((pp[0], c_p - cap))
                break
        
    return 2*ans
