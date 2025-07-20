class Solution {
    public int orangesRotting(int[][] grid) {
        int numOfFresh = 0;
        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            int[] gg = grid[i];
            for (int j = 0; j < gg.length; j++) {
                int g = gg[j];
                if (g == 1) numOfFresh++;
                if (g == 2) q.offer(new int[] {i, j});
            }
        }
        if (numOfFresh == 0) return 0;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        while (!q.isEmpty()) {
            if (numOfFresh == 0) return ans;
            ans++;
            LinkedList<int[]> nQ = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] c = q.poll();
                for (int[] d : dir) {
                    int ny = c[0] + d[0];
                    int nx = c[1] + d[1];
                    if (ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length) continue;
                    if (grid[ny][nx] != 1) continue;
                    if (grid[ny][nx] == 1) {
                        numOfFresh--;
                        grid[ny][nx] = 2;
                    }
                    nQ.offer(new int[] {ny, nx});
                }
            }
            q = nQ;
        }
        return -1;

    }
}