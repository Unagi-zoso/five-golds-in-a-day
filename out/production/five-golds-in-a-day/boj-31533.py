a = int(input())
n, m = map(int, input().split())

mn = min(n, m)
mx = max(n, m)

print(2*mn/a if 2*mn/a < mx else mx)