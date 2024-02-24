a, b, c, d, e, f = map(int, input().split())

x = int((e*c - b*f) / (a*e - d*b))
y = int((d*c - a*f) / (d*b - a*e))

print(x, y)
