#include <iostream>
#include <algorithm>

using namespace std;

int dp_1[305];
int dp_2[305];

int arr[305];
int n;

int main(){
    cin >> n;
    for (int i = 1; i <= n; ++i) cin >> arr[i];
    dp_1[1] = arr[1];
    for (int i = 2; i <= n; ++i){
            dp_2[i] = dp_1[i-1] + arr[i];
            dp_1[i] = max(dp_2[i-2], dp_1[i-2]) + arr[i];

    }
    cout << max(dp_1[n], dp_2[n]);
}