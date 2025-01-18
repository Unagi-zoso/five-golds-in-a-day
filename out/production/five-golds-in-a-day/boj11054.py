from sys import stdin

inc_list = [0 for _ in range(1005)]
dec_list = [0 for _ in range(1005)]

n = int(stdin.readline())
li = list(map(int, stdin.readline().split()))

for i in range(n):
    max_inc_size = 0
    for j in range(i):
        if li[i] > li[j]:
            if inc_list[j] > max_inc_size:
                max_inc_size = inc_list[j]
                max_dec_size = dec_list[j]
    inc_list[i] = max_inc_size + 1

for i in range(n-1, -1, -1):
    max_dec_size = 0
    for j in range(i+1, n):
        if li[i] > li[j]:
            if dec_list[j] > max_dec_size:
                max_dec_size = dec_list[j]
    dec_list[i] = max_dec_size + 1

maximum_idx = 0
for i in range(n):
    if inc_list[i] + dec_list[i] > inc_list[maximum_idx] + dec_list[maximum_idx]:
        maximum_idx = i


ans = inc_list[maximum_idx] + dec_list[maximum_idx] - 1
print(ans)
