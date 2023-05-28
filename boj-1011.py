from sys import stdin

T = int(stdin.readline())

for _ in range(T) :
    s, dest = list(map(int, stdin.readline().split()))
    dist = dest - s

    n = int((-1 + (1**2 + 4*dist)**(1/2)) / 2*1)

    remainder = dist - n*(n+1)

    if remainder == 0:
        ans = 2*n 
    elif remainder <= n + 1:
        ans = 2*n + 1
    else:
        ans = 2*n + 2

    print(ans)