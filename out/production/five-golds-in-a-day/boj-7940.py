t = int(input())

def addSpaceBetweenNums(str):
    n_s = str[0]
    for i in range(len(str)-1):
        if str[i] != '+' and str[i] != '-' and str[i+1] != '+' and str[i+1] != '-':
            n_s += (' ' + str[i+1])
        else:
            n_s += str[i+1]
    return n_s

def rec(cur_num, cur_str):
    if n == cur_num:
        if 0 == eval(cur_str):
            print(addSpaceBetweenNums(cur_str))
        return
    
    rec(cur_num + 1, cur_str+str(cur_num + 1))
    rec(cur_num + 1, cur_str+'+'+str(cur_num + 1))
    rec(cur_num + 1, cur_str+'-'+str(cur_num + 1))
    
for _ in range(t):
    n = int(input())

    rec(1, '1')
    print()

