class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] vis = new int[maze.length][maze[0].length];
        for (int i = 0; i < vis.length; i++) {
            Arrays.fill(vis[i], -1);
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == '+') continue;
            maze[i][0] = 'x';
        }
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][maze[0].length-1] == '+') continue;
            maze[i][maze[0].length-1] = 'x';
        }
        for (int i = 0; i < maze[0].length; i++) {
            if (maze[0][i] == '+') continue;
            maze[0][i] = 'x';
        }
        for (int i = 0; i < maze[0].length; i++) {
            if (maze[maze.length-1][i] == '+') continue;
            maze[maze.length-1][i] = 'x';
        }


        LinkedList<int[]> q = new LinkedList<>();
        q.offerLast(entrance);
        vis[entrance[0]][entrance[1]] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            for (int[] d : dir) {
                int ny = cur[0] + d[0];
                int nx = cur[1] + d[1];

                if (ny < 0 || ny >= maze.length || nx < 0 || nx >= maze[0].length) continue;
                if (vis[ny][nx] != -1 || maze[ny][nx] == '+') continue;
                if (maze[ny][nx] == 'x') return vis[cur[0]][cur[1]] + 1; 
                vis[ny][nx] = vis[cur[0]][cur[1]] + 1;
                q.offerLast(new int[] {ny, nx});
            }
        }
        return -1;
    }
}