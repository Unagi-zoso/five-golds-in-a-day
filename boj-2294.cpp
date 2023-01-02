#include <iostream>
#include <algorithm>

using namespace std;

int n, k;
int coins[102];
int dp[10002];

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; ++i) 
        cin >> coins[i];

    for (int i = 0 ; i < 10002; ++i) dp[i] = 999999;
    dp[0] = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = coins[i]; j <= k; ++j) {
            dp[j] = min(dp[j], dp[j - coins[i]] + 1);
        }
    }
    if (dp[k] == 999999) cout << -1;
    else cout << dp[k];
}