def helper(i, st, dest):
    if i == 1:
        print(st, dest)
        return 1
    
    res = 0
    res += helper(i - 1, st, 6 - dest - st)
    res += 1
    print(st, dest)
    res += helper(i - 1, 6 - dest - st, dest)
    return res

def helperWithSkip(i):
    if i == 1:
        return 1
    
    res = 2 * helperWithSkip(i - 1) + 1
    return res

n = int(input())
print(helperWithSkip(n))
if n <= 20:    
    helper(n, 1, 3)
