#include <iostream>
#include <algorithm>

using namespace std;

const int MOD = 1'000'000'000;

int dp[202][202];
int n, k;

int main() {
    cin >> n >> k;

    for (int i = 0 ; i <= 201; ++i) {
        dp[0][i] = 1;
    }

    for (int i = 1 ; i <= 201; ++i) {
        for (int j = 1 ; j <= 201; ++j) {
            for (int m = 0; m <= i; ++m) {
                dp[i][j] = (dp[i][j] + dp[m][j-1]) % MOD; 
            }
        }
    }

    cout << dp[n][k];
}