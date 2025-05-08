# n 빌딩 층수, k 자리로 표리, led p 개 반전, 현재 엘베 층 x
# led바꿔서 1< N 로 만들어. 반전시킬 LED 를 고를 수 있는 경우의 수.

ch = [[True, True, True, False, True, True, True],
      [False, False, True, False, False, True, False],
      [True, False, True, True, True, False, True],
      [True, False, True, True, False, True, True],
      [False, True, True, True, False, True, False],
      [True, True, False, True, False, True, True],
      [True, True, False, True, True, True, True],
      [True, False, True, False, False, True, False],
      [True, True, True, True, True, True, True],
      [True, True, True, True, False, True, True],]

n, k, p, x = map(int, input().split())
ans = 0

for i in range(1, n+1):
    if i == x:
        continue
    origin = str(x).rjust(k, '0')
    target = str(i).rjust(k, '0')
    cnt = 0
    for j in range(k):
        for kk in range(7):
            if ch[int(origin[j])][kk] != ch[int(target[j])][kk]: cnt+= 1
    if cnt <= p:
        ans += 1

print(ans)
