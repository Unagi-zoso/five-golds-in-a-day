for _ in range(int(input())):
    n, s = input().split()
    n = int(n)

    ans = ""
    for c in s:
        ans += n*c
    
    print(ans)