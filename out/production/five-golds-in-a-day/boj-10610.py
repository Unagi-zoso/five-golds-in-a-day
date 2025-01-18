s = sorted(list(map(int,[*input()])))
if s[0] == 0 and sum(s) % 3 == 0:
    print(''.join(map(str,reversed(s))))
else:
    print(-1)
