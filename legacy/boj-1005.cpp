#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

using pii = pair<int, int>;
int visit[1005];
int dp[1005];

int t;

vector<pii> caller[1005];
vector<pii> callee[1005];
int value[1005];

int rec(int w, int prev){
    if (dp[w] != -1) return dp[w];
    bool ischange = false;
    int mx = 0;
    int sum = prev;
    for (auto c : caller[w]){
        if (visit[c.first]) continue;
        ischange = true;
        visit[c.first] = true;
        mx = max(mx, rec(c.first, c.second));
        visit[c.first] = false;
    }
    sum += mx;
    if (!ischange) return dp[w] = prev;
    return dp[w] = sum;
}

int main(){
    cin >> t;
    while (t--){
        int n, k;
        cin >> n >> k;
        for (int i = 0; i <= n; ++i){
            caller[i].clear();
            callee[i].clear();
            dp[i] = -1;
        }
        for (int i = 1; i <= n; ++i) cin >> value[i];
        while (k--){
            int p, q, d;
            cin >> p >> q;
            callee[p].push_back({q, value[q]});
            caller[q].push_back({p, value[p]});
        }
        int w; cin >> w;
        visit[w] = true;
        cout << rec(w, value[w]) << '\n';
        visit[w] = false;
    }
}