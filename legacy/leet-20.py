class Solution:
    def isValid(self, s: str) -> bool:
        stk = []
        for ch in s:
            if ch == ')':
                if stk and stk[-1] == '(':
                    stk.pop()
                else:
                    return False
            elif ch == '}':
                if stk and stk[-1] == '{':
                    stk.pop()
                else:
                    return False
            elif ch == ']':
                if stk and stk[-1] == '[':
                    stk.pop()
                else:
                    return False
            else:
                stk.append(ch)
        
        return len(stk) == 0

        