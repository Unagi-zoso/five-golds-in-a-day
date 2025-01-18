n = int(input())
MAX_N = 1000005
MAX_VALUE = 99999999999
constructors = [MAX_VALUE for _ in range(MAX_N)]

for i in range(1, MAX_N):
    place_list = []
    place_list.append(i)
    j = i
    while i > 10:
        place_list.append(int(i%10))
        i = int(i/10)
    place_list.append(i)
    sum_value = sum(place_list)
    if  sum_value >= MAX_N: 
        continue
    constructors[sum_value] = min(constructors[sum_value], j)

print(constructors[n] if constructors[n] != MAX_VALUE else 0)
