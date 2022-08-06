#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

using pos = pair<int, int>;
using info = pair<pair<int, int>, int>;

int n, m;
int board[53][53];
int dist[53][53];
pos chicken[15];
int c_cnt = 0;
int h_cnt = 0;
bool comb[15];
queue<info> q;
int mn = 0x5F5F5F5F;


int main(){
    cin >> n >> m;
    for (int i = 0; i < n; ++i){
        for (int j = 0; j < n; ++j){
            cin >> board[i][j];
            if (board[i][j] == 2){
                chicken[c_cnt] = {i, j};
                c_cnt++;
            }
            else if (board[i][j] == 1) h_cnt++;
        }
    }

    for (int i = 0; i < m; ++i) comb[i] = true;

    do{
        while (!q.empty()) q.pop();
        for (int i = 0; i < c_cnt; ++i)
            if (comb[i] == true) {q.push({chicken[i], 0});}
        
        for (int i = 0 ; i < n; ++i)
            fill(dist[i], dist[i]+n, 0);

        int cur_cnt = 0;
        int cur_dist = 0;
        bool flag = false;

        while (!q.empty()){
            info cur = q.front(); q.pop();
            for (int i = 0; i < 4; ++i){
                int n_x = cur.first.first + dx[i];
                int n_y = cur.first.second + dy[i];

                if (n_x < 0 || n_x >= n || n_y < 0 || n_y >= n) continue;
                if (dist[n_x][n_y] != 0) continue;
                dist[n_x][n_y] = cur.second+1;
                
                if (board[n_x][n_y] == 1){
                    cur_cnt++;
                    cur_dist += dist[n_x][n_y];
                }
                if (cur_cnt == h_cnt){
                    mn = min(mn, cur_dist);
                    flag = true;
                    break;
        
                }
                q.push({{n_x, n_y}, dist[n_x][n_y]});
            }
            if (flag == true) break;
        }
        
       
    }while(prev_permutation(comb, comb+c_cnt));
    cout << mn;
}
