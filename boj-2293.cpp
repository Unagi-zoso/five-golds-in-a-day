#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int n, k;
int coins[102];
int dp[10002];

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; ++i) 
        cin >> coins[i];

    dp[0] = 1;
    for (int i = 0; i < n; ++i) {
        for (int j = coins[i]; j <= k; ++j) {
            dp[j] += dp[j - coins[i]];
        }
    }

    cout << dp[k];
}