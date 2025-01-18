#include <iostream>
#include <algorithm>

using namespace std;

const int MOD = 1'000'000'003;
int n, k;
int dp[1002][1002];

int main() {
    cin >> n >> k;

    for (int i = 0; i < 1002; ++i) {
        dp[i][0] = 1;  // 뽑아야할 게 0이라 함은 이 경우의 수가 옮음을 나타내니 1
        dp[i][1] = i;  // dp의 인덱스 i가 1일 때 초기화됨. 고로 아래 반복문에서 i는 2부터 시작.
    }

    for (int i = 2; i < n; ++i) {  // i는 n이전까지 n까지하면 순환을 고려하지 않은 답이 생깁니다.
        for (int j = 2; j <= k; ++j) {
            dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
        }
    }
    
    int ans = ((dp[n - 3][k - 1] + dp[n - 1][k]) % MOD);
    cout << ans;
}