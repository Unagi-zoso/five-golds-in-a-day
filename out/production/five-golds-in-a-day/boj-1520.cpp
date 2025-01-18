#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

using v = vector<vector<bool>>;

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

int n, m, ans;
vector<vector<int>> origin(505, vector<int>(505));
vector<vector<int>> dp(505, vector<int>(505));

int dfs(int x, int y){
    if (x == n-1 && y == m-1)  return 1; 
    if (dp[x][y] != -1) return dp[x][y];
    int sum = 0;
    for (int i = 0; i < 4; ++i){
        if (x+dx[i] >= 0 && y+dy[i] >= 0 && x+dx[i] < n && y+dy[i] < m){
            if (origin[x+dx[i]][y+dy[i]] < origin[x][y]){
                sum += dfs(x+dx[i], y+dy[i]);
            }
        }
    }
    return dp[x][y] = sum;
}

int main(){
    cin.tie(0)->sync_with_stdio(0);
    cin >> n >> m;
    for (int i = 0; i < n; ++i){
        fill(dp[i].begin(), dp[i].end(), -1);
        for (int j = 0; j < m; ++j)
            cin >> origin[i][j];
    }
    
    cout << dfs(0, 0);
}