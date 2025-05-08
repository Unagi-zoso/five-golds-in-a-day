# 현재 N개의 앱이 활성화 되어 있다. 이들 앱은 각각 m바이트만큼의 메모리를 사용
# A를 비활성화하고 다시 실행할 때 드는 비용이 c
# 사용자가 새로운 앱 실행 시 추가로 M바이트 필요할 수 있따. 활성화된 앱 중 몇 개를 비활성화해야한다.
# 비화설화했을 경우의 비용 c의 합을 최소화하여 필요 메모리 M 바이트 확보 방법 찾자

# N M
# N개... (활성화된 앱이 사용 중인 바이트 수)
# N개... (비활성화할 때의 비용)

# 1 <= N <= 100, 1 <= M <= 10^9, 1 <= m.. <= 10^9, 0 <= c <= 100, M <= m1 + ... mN

# 비용이 적은 애를 뺄까, 메모리가 큰 애를 뺼까? 우선순위 정하기 힘들어 DP로 접근하자
# 코스트 적게 해서 M을 맞춰라 하는 문제네

from sys import stdin

N, M = map(int, stdin.readline().split())
memories = list(map(int, stdin.readline().split()))
costs = list(map(int, stdin.readline().split()))

dp = [[0 for _ in range(10005)] for _ in range(105)]

ans = 9999999999
for i in range(1, 105):
    for j in range(0, 10005):
        if i > N or costs[i-1] > j:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-costs[i-1]] + memories[i-1])
        if dp[i][j] >= M and j < ans:
            ans = j

print(ans)