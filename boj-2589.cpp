#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

using pos = pair<int, int>;


char map[55][55];
pos land[3000];
int land_cnt;
int dist[55][55];
int n, m;
int ans;

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

void clear_dist(){
    for (int i = 0; i < n; ++i){
        for (int j = 0; j < m; ++j){
            dist[i][j] = -1;
        }
    }
}

int main(){
    cin.tie(0)->sync_with_stdio(0);
    cin >> n >> m;
    for (int i = 0; i < n; ++i){
        for (int j = 0; j < m; ++j){
            cin >> map[i][j];
            if (map[i][j] == 'L'){
                land[land_cnt++] = {i, j};
            } 
        }
    }

    for (int i = 0; i < land_cnt; ++i){
        clear_dist();
        queue<pos> q;
        q.push(land[i]);
        dist[land[i].first][land[i].second] = 0;
        while (!q.empty()){
            pos cur = q.front(); q.pop();
            for (int j = 0; j < 4; ++j){
                int n_x = cur.first + dx[j];
                int n_y = cur.second + dy[j];

                if (n_x < 0 || n_x >= n || n_y < 0 || n_y >= m) continue;
                if (map[n_x][n_y] == 'W') continue;
                if (dist[n_x][n_y] != -1) continue;
                dist[n_x][n_y] = dist[cur.first][cur.second] + 1;
                ans = max(ans, dist[n_x][n_y]);
                q.push({n_x, n_y});
            }
        }
    }
    cout << ans;
}