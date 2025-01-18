#include <iostream>
#include <algorithm>

using namespace std;

int n;
int chu[1005];
int ans;

int main(){
    cin >> n;
    for (int i = 0; i < n; ++i){
        cin >> chu[i];
    }
    sort(chu, chu+n);

    ans = 1;
    for (int i = 0; i < n; i++){
        if (chu[i] > ans) break;
        ans += chu[i];       
    }
    cout << ans;
}