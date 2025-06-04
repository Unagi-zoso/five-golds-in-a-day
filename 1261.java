import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        boolean[][] board = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) == '1' ? true : false;
            }
        }

        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        LinkedList<int[]> q = new LinkedList<>();
        dist[0][0] = 0;
        q.offer(new int[] {0, 0, 0}); // y, x, cost
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            int cc = cur[2];
            for (int i = 0; i < dir.length; i++) {
                int ny = cy + dir[i][0];
                int nx = cx + dir[i][1];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                int nc = cc;
                if (board[ny][nx]) { // wall
                    nc++;
                }
                if (dist[ny][nx] <= nc) continue;
                dist[ny][nx] = nc;
                if (ny == n-1 && nx == m-1) break;
                q.offer(new int[] {ny, nx, nc});
            }
        }

        bw.write(String.valueOf(dist[n-1][m-1]));
        bw.flush();
    }
}