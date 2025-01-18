#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

constexpr int INF = 0x5f5f5f5f;

int n, m;

int board[103];
int dist[103];

queue<int> q;

int main() {
    cin >> n >> m;

    fill(dist, dist + 102, INF);
    fill(board, board + 102, -1);

    for (int i = 0; i < n + m; ++i) {
        int st, ed;
        cin >> st >> ed;
        board[st] = ed;
    }

    q.push(1);
    dist[1] = 0;
    while (!q.empty()){
        int cur = q.front(); q.pop();
        for (int i = 1; i <= 6; ++i){
            int next = cur+i;
            if (next > 100) continue;
            if (board[next] != -1){
                while (board[next] != -1){
                    next = board[next];
                }
            }
            if (dist[next] != INF) continue;
            dist[next] = dist[cur] + 1;
            if (next == 100) {
                cout << dist[next]; return 0;
            }
            q.push(next);
        }
    }

    for (int i = 1; i <= 100; ++i) cout << dist[i] << ' ';

}