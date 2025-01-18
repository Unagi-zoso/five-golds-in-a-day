#include <iostream>
#include <algorithm>

using namespace std;

int dp[202];
int origin[202]; 

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) 
        cin >> origin[i];

    int ans = -1;
    for (int i = 0; i < n; ++i) {
        dp[i] = 1;
        for (int j = i - 1; j >= 0; --j) 
            if (origin[i] > origin[j] && ((dp[j]+1) > dp[i])) 
                dp[i] = dp[j]+1;
        
        ans = max(ans, dp[i]);
    }

    cout << n - ans;
}