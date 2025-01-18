from sys import stdin

R, C = map(int, stdin.readline().split())
board = [list(stdin.readline()) for _ in range(R)]
ans = -1

for c in range(C):
    for r in range(R):
        for c_s in range(-C- 1, C):
            for r_s in range(-R-1, R):
                s = ""
                y, x = c, r
                if c_s == 0 and r_s == 0: continue
                while 0 <= x < R and 0 <= y < C:
                    s += board[x][y]
                    if int(int(s) ** (1/2)) == (int(s) ** (1/2)):
                        ans = max(ans, int(s))
                    y += c_s
                    x += r_s

print(ans)