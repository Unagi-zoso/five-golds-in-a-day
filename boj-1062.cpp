#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <tuple>

#define COST(t) get<0>(t)
#define TO(t) get<1>(t)
#define LEFT(t) get<2>(t)

using namespace std;

constexpr long long INF = 50'000'000'001;

using ll = long long;
using edge = tuple<long long, int, int>;

int n, m, k;
vector<edge> gph[10001];
priority_queue<edge, vector<edge>, greater<edge>> pq;

ll dist[10001][21];

void dijkstra(){
    while (!pq.empty()){
        ll cost = COST(pq.top());
        int cur_idx = TO(pq.top());
        int builtable = LEFT(pq.top());
        pq.pop();
        
        if (cost > dist[cur_idx][builtable]) continue;

        for (int i =0; i < gph[cur_idx].size(); ++i){
            int next = TO(gph[cur_idx][i]);
            ll next_cost = COST(gph[cur_idx][i]) + cost;
            if (builtable > 0 && dist[next][builtable - 1] > cost){
                dist[next][builtable - 1] = cost;
                pq.push({ cost, next, builtable-1});
            }
            if (dist[next][builtable] > next_cost){
                dist[next][builtable] = next_cost;
                pq.push({next_cost, next, builtable});
            }
        }
    }
}

int main(){
    cin.tie(0)->sync_with_stdio(0);
    int from, to, cost;
    ll ans = INF;
    cin >> n >> m >> k;
    while (m--){
        cin >> from >> to >> cost;
        gph[from].push_back({cost, to, k});
        gph[to].push_back({cost, from, k});
    }

    for (int i = 1; i <= n; i++){
        for (int j = 0; j <= k; j++){
            dist[i][j] = INF;
        }
    }

    pq.push({0, 1, k});
    dist[1][k] = 0;
    
    dijkstra();

    for (int i = 0; i <= k; i++)
        ans = min(ans, dist[n][i]);
     
    cout << ans;

    return 0;
}