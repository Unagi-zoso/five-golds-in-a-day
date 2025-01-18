#include <iostream>

using namespace std;

unsigned long long dp[35][35] = { { 0,  }, };

int main() {
    for (int i = 0 ; i < 31; i++) {
        dp[0][i] = 1;
    }

    for (int i = 1 ; i < 31; i++) {
        for (int j = 0 ; j < 31; j++) {
            if (j == 0) dp[i][j] = dp[i-1][j+1];
            else dp[i][j] = dp[i-1][j+1] + dp[i][j-1];
        }
    }

    while (1) {
        int n; 
        cin >> n;
        if (n == 0) return 0;
        cout << dp[n][0] << '\n';
    }
}