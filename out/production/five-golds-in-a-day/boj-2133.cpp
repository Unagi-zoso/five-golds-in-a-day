#include <iostream>
#include <algorithm>

using namespace std;
int dp[35] = { 1, 0, 3, };
int n;

int main(){
    cin >> n;
    for (int i = 4; i <= n; i+=2){
        dp[i] += 3*dp[i-2];
        for (int j = i-4; j >= 0; j -= 2){
            dp[i] += 2*dp[j];
        }
    }
    cout << dp[n];          
}