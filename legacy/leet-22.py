'''
구현
from copy import copy

def rec(src, s, cur, n, target, curr):
    if cur == n:
        if target == curr:
            _s = ""
            for c in s:
                _s += c
            src.append(_s)
        return
    ns1 = copy(s)
    ns1[cur] = ')'
    rec(src, ns1, cur + 1, n, target, curr + 1)
    rec(src,   s, cur + 1, n, target, curr)

def generate(n):
    ret = []
    s = ['('] * (2 * n)
    rec(ret, s, 0, 2 * n, n, 0)
    return ret

def check(s):
    stk = []
    for c in s:
        if c == '(':
            stk.append('(')
        if c == ')':
            if len(stk) == 0:
                return False
            else:
                if stk[-1] == '(':
                    stk.pop()
                else:
                    return False
    return len(stk) == 0
                
                
class Solution:

    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        li = generate(n)
        for s in li:
            if check(s):
                ans.append(s)
        return ans
'''