class Solution {
    boolean[] visited = new boolean[205];
    int[][] isConn;
    int ans = 0;
    public int findCircleNum(int[][] isConnected) {
        isConn = isConnected;
        for (int i = 0; i < isConn.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            rec(i);
            ans++;
        }
        return ans;
    }
    public void rec(int node) {
        for (int i = 0; i < isConn.length; i++) {
            if (isConn[node][i] == 0 || visited[i]) continue;
            visited[i] = true;
            rec(i);
        }
    }
}