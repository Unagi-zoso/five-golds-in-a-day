from sys import stdin

N = int(stdin.readline())
dice = list(map(int, stdin.readline().split()))

def solve():
    if N == 1:
        print(sum(dice) - max(dice))
        return

    three = 4
    two = 4*(2*N - 3)
    one = 2*(N**2) + (N-2)*(2*N + N-2)  - three - two

    min_one = min_two = min_three = 999999999999

    for i in range(6):
        min_one = min(min_one, dice[i])
        for j in range(i + 1, 6):
            if i + j == 5: continue
            min_two = min(min_two, dice[i] + dice[j])
            for k in range(j + 1, 6):
                if i + k == 5 or j + k == 5: continue
                min_three = min(min_three, dice[i] + dice[j] + dice[k])

    print(one * min_one + two * min_two + three * min_three)

solve()