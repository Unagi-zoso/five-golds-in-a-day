import math
a, b, c = map(int, input().split())

if a == b:
    print(-1)
    exit()

if a > b:
    t = a
    a = b
    b = t

x = a * c / (b - a)
r1 = x * x + a * a
r2 = b * b + (c+x) * (c+x)

print((r2 - r1) * math.pi)
