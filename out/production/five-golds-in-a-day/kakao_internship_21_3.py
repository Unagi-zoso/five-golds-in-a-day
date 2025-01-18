def solution(n, k, cmd):
    class Node:
        def __init__(self, left = None, right = None) -> None:
            self.left = left
            self.right = right
            self.remove_flag = False
            
    answer = ''
    ll = [Node(left=i-1, right=i+1) for i in range(n)]
    ll[0].left = None
    ll[n-1].right = None
    removed_stk = []

    for c in cmd:
        c = c.split()
        if c[0] == 'U':
            for _ in range(int(c[1])):
                k = ll[k].left
        elif c[0] == 'D':
            for _ in range(int(c[1])):
                k = ll[k].right
        elif c[0] == 'C':
            ll[k].remove_flag = True
            l, r = ll[k].left, ll[k].right
            removed_stk.append(k)
            if l:
                ll[l].right = r
            if r:
                ll[r].left = l

            if r:
                k = r
            else:
                k = l
                
        elif c[0] == 'Z':
            rollback_idx = removed_stk.pop()
            ll[rollback_idx].remove_flag = False
            l, r = ll[rollback_idx].left, ll[rollback_idx].right

            if l:
                ll[l].right = rollback_idx
            if r:
                ll[r].left = rollback_idx

    for i in range(n):
        if ll[i].remove_flag:
            answer += "X"
        else:
            answer += "O"

    return answer
