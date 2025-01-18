#include <iostream>   // ugly queen
#include <vector>     // 시간초과

using namespace std;

int N;
int ans;

vector<bool> is_used_d(45);
vector<bool> is_used_dl(45);
vector<bool> is_used_dr(45);

void bt(int cur){
    if (cur > N) { ans++; return; }

    for (int i = 1; i <= N; ++i){
        if (is_used_d[i] || is_used_dl[i+cur] || is_used_dr[cur-i+N-1]) continue;
        is_used_d[i] = 1;
        is_used_dl[i+cur] = 1;
        is_used_dr[cur-i+N-1] = 1;
        bt(cur+1);
        is_used_d[i] = 0;
        is_used_dl[i+cur] = 0;
        is_used_dr[cur-i+N-1] = 0;
    }
}


int main(){
    cin.tie(0)->sync_with_stdio(0);
    cin >> N;   
    bt(1);
    cout << ans;
}