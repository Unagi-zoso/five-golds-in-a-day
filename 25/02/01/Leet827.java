import java.util.*;

class Solution {
    int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    int Y = 0, X = 1;

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        boolean isAllOne = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) isAllOne = false;
            }
            if (!isAllOne) break;
        }
        if (isAllOne) return n * n;

        int answer = 0;
        Map<Integer, Integer> islands = new HashMap<>();
        bfs(grid, n,islands);

        boolean[][] isVisited = new boolean[505][505];

        Set<Integer> uniqFilter = new HashSet<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                for (int d = 0; d < 4; d++) {
                    int curMax = 0;
                    int nY = y + dir[d][Y];
                    int nX = x + dir[d][X];

                    if (nY < 0 || nY >= n || nX < 0 || nX >= n) continue;
                    if (grid[nY][nX] != 0) continue;
                    if (isVisited[nY][nX]) continue;
                    isVisited[nY][nX] = true;

                    for (int i = 0; i < 4; i++) {
                        int nnY = nY + dir[i][Y];
                        int nnX = nX + dir[i][X];
                        if (nnY < 0 || nnY >= n || nnX < 0 || nnX >= n) continue;
                        if (grid[nnY][nnX] == 0 || grid[nnY][nnX] == 1) continue;
                        if (uniqFilter.contains(grid[nnY][nnX])) continue;
                        uniqFilter.add(grid[nnY][nnX]);
                        curMax += islands.get(grid[nnY][nnX]);
                    }
                    uniqFilter.clear();
                    answer = Math.max(answer, curMax);
                }
            }
        }

        return answer + 1;
    }

    public void bfs(int[][] grid, int n, Map<Integer, Integer> islands) {
        int id = 2;
        boolean[][] isVisited = new boolean[505][505];
        LinkedList<int[]> q = new LinkedList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (isVisited[y][x] || grid[y][x] != 1) continue;
                int curMax = 0;
                q.offer(new int[] {y, x});
                isVisited[y][x] = true;
                grid[y][x] = id;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    curMax++;
                    for (int i = 0; i < 4; i++) {
                        int nY = cur[Y] + dir[i][Y];
                        int nX = cur[X] + dir[i][X];

                        if (nY < 0 || nY >= n || nX < 0 || nX >= n) continue;
                        if (isVisited[nY][nX] || grid[nY][nX] != 1) continue;
                        isVisited[nY][nX] = true;
                        grid[nY][nX] = id;
                        q.offer(new int[] {nY, nX});
                    }
                }
                islands.put(id, curMax);
                id++;
            }
        }
    }
}
