n = int(input())
m = int(input())
sensors = sorted(set(list(map(int, input().split()))))

candi = []
for i in range(1, len(sensors)):
    candi.append(sensors[i]-sensors[i-1])

candi.sort()

for _ in range(m-1):
    if candi: candi.pop()

print(sum(candi))
