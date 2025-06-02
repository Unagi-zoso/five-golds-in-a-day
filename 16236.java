import java.io.*;
import java.util.*;

class Main {
    public static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int cntFish = 0;
        int[] shark = {0, 0, 9, 2, 0, 0}; // 좌표 y, x, shark, size, cntEat, time
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] != 0 && board[i][j] != 9) cntFish++;
                if (board[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    board[i][j] = 0;
                }
            }
        }

        while (cntFish > 0) {
            int[] info = findWithBFS(board, shark); // 물고기좌표 y, x, time 없을 시 -1,-1,-1
            if (info[0] == -1) break;
            board[info[0]][info[1]] = 0;
            cntFish--;
            shark[0] = info[0];
            shark[1] = info[1];
            shark[5] += info[2];
            if (++shark[4] == shark[3]) {
                shark[3]++;
                shark[4] = 0;
            }
        }

        bw.write(String.valueOf(shark[5]));
        bw.flush();
    }

    public static int[] findWithBFS(int[][] board, int[] shark) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() { // 좌표, 시간
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        });
        int findTime = Integer.MAX_VALUE;
        boolean[][] visit = new boolean[21][21];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {shark[0], shark[1], 0, shark[3]}); // 좌표, 시간, 크기
        visit[shark[0]][shark[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cY = cur[0];
            int cX = cur[1];
            int cT = cur[2];
            int cS = cur[3];
            for (int[] d : dir) {
                int nY = cY + d[0];
                int nX = cX + d[1];
                int nT = cT + 1;
                if (nY < 0 || nY >= board.length || nX  < 0 || nX >= board[0].length) continue;
                if (visit[nY][nX] || board[nY][nX] > cS) continue;
                visit[nY][nX] = true;
                if (0 < board[nY][nX] && board[nY][nX] < cS && nT <= findTime) {
                    pq.offer(new int[] {nY, nX, nT});
                    findTime = Math.min(findTime, nT);
                }
                if (nT <= findTime) q.offer(new int[] {nY, nX, nT, cS});
            }
        }
        if (pq.isEmpty()) return new int[] { -1, -1, -1, -1 };
        
        return pq.poll();
    }
}