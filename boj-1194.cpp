#include <iostream>
#include <queue>
#include <vector>
#include <string>

#define POS first
#define X first
#define Y second
#define UTIL second
#define STATE first 
#define LENGTH second

using namespace std;

using pii = pair<pair<int, int>, pair<int, int>>;

int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };

int n, m;
char board[55][55];
bool vis[1 << 6][55][55];
queue<pii> q;

int main(){
    cin >> n >> m;
    for (int i = 0; i < n; ++i){
        string s;
        cin >> s;
        for (int j = 0; j < m; ++j){
            board[i][j] = s[j];
            if (board[i][j] == '0'){
                q.push({{i, j}, {0, 0}});
                vis[0][i][j] = true;
            }
        }
    }
    while (!q.empty()){
        pii cur = q.front(); q.pop();
        for (int i = 0; i < 4; ++i){
            int n_x = cur.first.X + dx[i];
            int n_y = cur.first.Y + dy[i];

            if (n_x < 0 || n_x >= n || n_y < 0 || n_y >= m) continue;
            if (board[n_x][n_y] == '#') continue;
            if ('A' <= board[n_x][n_y] && board[n_x][n_y] <= 'F'){
                if ((cur.UTIL.STATE & (1 << board[n_x][n_y] - 'A')) == 0) continue;
            }  
            
            if ('a' <= board[n_x][n_y] && board[n_x][n_y] <= 'f'){
                if (vis[cur.UTIL.STATE | (1 << (board[n_x][n_y] - 'a'))][n_x][n_y]) continue;
                vis[cur.UTIL.STATE | (1 << (board[n_x][n_y] - 'a'))][n_x][n_y] = true;
                q.push({{n_x, n_y}, {cur.UTIL.STATE | (1 << board[n_x][n_y] - 'a'), cur.UTIL.LENGTH+1}});  
            }  
            
            if (board[n_x][n_y] == '1'){
                cout << cur.UTIL.LENGTH+1; return 0;
            }

            if (vis[cur.UTIL.STATE][n_x][n_y]) continue;
            vis[cur.UTIL.STATE][n_x][n_y] = true;
            q.push({{n_x, n_y}, {cur.UTIL.STATE, cur.UTIL.LENGTH+1}});
        }
    }
    cout << -1;
}