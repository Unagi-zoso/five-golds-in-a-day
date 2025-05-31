import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[n+5][m+5];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0;j < m; j++) {
                if (input.charAt(j) == '0') board[i][j] = false;
                else board[i][j] = true;
            }
        }

        int[][] distFromNorthWest = new int[n+5][m+5];
        int[][] distFromSouthEast = new int[n+5][m+5];

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        distFromNorthWest[0][0] = 1;
        q.offer(new int[] {0, 0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int ny = cur[0] + d[0];
                int nx = cur[1] + d[1];
                int nd = cur[2] + 1;
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (board[ny][nx]) continue;
                if (distFromNorthWest[ny][nx] != 0) continue;
                distFromNorthWest[ny][nx] = nd;
                q.offer(new int[] {ny, nx, nd});
            }
        }

        q = new LinkedList<>();
        distFromSouthEast[n-1][m-1] = 1;
        q.offer(new int[] {n-1, m-1, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int ny = cur[0] + d[0];
                int nx = cur[1] + d[1];
                int nd = cur[2] + 1;
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (board[ny][nx]) continue;
                if (distFromSouthEast[ny][nx] != 0) continue;
                distFromSouthEast[ny][nx] = nd;
                q.offer(new int[] {ny, nx, nd});
            }
        }

        int ans = distFromNorthWest[n-1][m-1];
        
        int[][][] connDir = {{{-1, 0}, {0, 1}}, {{0, -1}, {-1, 0}}, {{0, -1}, {1, 0}}, {{1, 0}, {0, 1}}, {{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}};
        if (ans == 0) ans = 99999999;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!board[i][j]) continue;
                for (int[][] cd : connDir) {
                    int[] ny = {i, i};
                    int[] nx = {j, j};
                    for (int p = 0; p < 2; p++) {
                        ny[p] += cd[p][0];
                        nx[p] += cd[p][1];
                    }
                    if (ny[0] < 0 || ny[0] >= n || nx[0] < 0 || nx[0] >= m) continue;
                    if (ny[1] < 0 || ny[1] >= n || nx[1] < 0 || nx[1] >= m) continue;
                    if (board[ny[0]][nx[0]] || board[ny[1]][nx[1]]) continue;
                    if (distFromNorthWest[ny[0]][nx[0]] != 0 && distFromSouthEast[ny[1]][nx[1]] != 0) {
                        ans = Math.min(ans, distFromNorthWest[ny[0]][nx[0]] + distFromSouthEast[ny[1]][nx[1]] + 1);
                    }
                    if (distFromNorthWest[ny[1]][nx[1]] != 0 && distFromSouthEast[ny[0]][nx[0]] != 0) {
                        ans = Math.min(ans, distFromNorthWest[ny[1]][nx[1]] + distFromSouthEast[ny[0]][nx[0]] + 1);
                    }
                }
            }
        }
        if (ans == 99999999) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(ans));
        }
        bw.flush();
    }
}