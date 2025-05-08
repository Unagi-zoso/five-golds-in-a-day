t = int(input())

for _ in range(t):
    h, w, n = map(int, input().split())
    room = str(((n - 1) // h) + 1)
    if len(room) < 2:
        room = '0' + room
    print(str(((n - 1) % h) + 1) + room)

# 1부터 시작하는 순화문제는 1을 빼 0 베이스로 만든 후 결과에 1을 더하자.
