def solution(p):
    def extract_balanced(w):
        num_of_left = 0
        num_of_right = 0
        for idx in range(len(w)):
            if w[idx] == '(':
                num_of_left += 1
            else:
                num_of_right += 1
            if num_of_left == num_of_right:
                break
        return w[:idx+1], w[idx+1:]
    
    
    def check_perfect(li):
        stk = []
        for el in li:
            if el == '(':
                stk.append('(')
            else:
                if len(stk) == 0:
                    return False
                stk.pop()
        if len(stk) > 0:
            return False
        return True
    
    
    def dir_reverse(w):
        ret = ""
        for c in w:
            if c == '(':
                ret += ')'
            else:
                ret += '('
        return ret
    
            
    def solve(p):
        if p == "":
            return "";
        
        u, v = extract_balanced(p)
        
        if check_perfect(u):
            return "".join(u) + solve(v)
        else:
            return "(" + solve(v) + ")" + dir_reverse(u[1:len(u)-1])
            
            
        #print(solve(p))
    
    return solve(p)
