#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

using info = pair<int, int>;

vector<info> adjc[1005];
vector<bool> vis(1005);

int rec(int parent, int parent_cost, vector<bool> &vis){
    int child_sum = 0;
    bool pass = true;
    for (auto child : adjc[parent]){
        if (vis[child.first]) continue;
        pass = false;
        vis[child.first] = true;
        child_sum += rec(child.first, child.second, vis);
        vis[child.first] = false;
    }
    
    if (pass) return parent_cost;
    return min(parent_cost, child_sum);
}

int t, n, m;
int main(){
    cin >> t;
    while(t--){
        for (int i = 0; i < 1005; i++) adjc[i].clear();
        vis.clear();
        cin >> n >> m;
        if (n == 1) cout << 0 << '\n';
        else{
            for (int i = 0; i < m; i++){
                int from, to, cost;
                cin >> from >> to >> cost;
                adjc[from].push_back({to, cost});
                adjc[to].push_back({from, cost});

            }
            vis[1] = true;
            cout << rec(1, 50000, vis) << '\n';
        }
    }
}