import java.util.*;
import java.io.*;

public class Boj3197 {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int r, c;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        boolean[][] melted = new boolean[r][c];
        ArrayDeque<int[]> edgeGlacierQ = new ArrayDeque<>();

        int swanCount = 0;
        int[][] swans = new int[2][2];

        for (int i = 0; i < r; i++) {
            String tS = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = tS.charAt(j);
                if (board[i][j] == 'L') {
                    swans[swanCount][0] = i;
                    swans[swanCount][1] = j;
                    swanCount++;
                }
                if (board[i][j] == '.' || board[i][j] == 'L') {
                    edgeGlacierQ.add(new int[]{i, j});
                    melted[i][j] = true;
                }
            }
        }

        boolean[][] swanVisited = new boolean[r][c];
        ArrayDeque<int[]> swanQueue = new ArrayDeque<>();
        swanQueue.add(swans[0]);
        
        int answer = 0;
        while (true) {
            if (swanProcess(board, swanQueue, swanVisited, swans[1])) {
                System.out.println(answer);
                return;
            }

            int size = edgeGlacierQ.size(); // 사이즈를 통해 이전 시간의 원소 다루기 가능. 원래 같음 while (!q.isEmpty()) 로 처리했을 것.
            for (int i = 0; i < size; i++) {
                int[] cur = edgeGlacierQ.poll();
                int y = cur[0], x = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nY = y + dir[d][0], nX = x + dir[d][1];
                    if (nY < 0 || nY >= r || nX < 0 || nX >= c) continue;
                    if (!melted[nY][nX] && board[nY][nX] == 'X') {
                        board[nY][nX] = '.';
                        melted[nY][nX] = true;
                        edgeGlacierQ.add(new int[]{nY, nX});
                    }
                }
            }
            answer++;
        }
    }

    public static boolean swanProcess(char[][] board, ArrayDeque<int[]> queue, boolean[][] visited, int[] ds) {
        ArrayDeque<int[]> nextQueue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];

            for (int d = 0; d < 4; d++) {
                int nY = y + dir[d][0], nX = x + dir[d][1];
                if (nY < 0 || nY >= r || nX < 0 || nX >= c) continue;

                if (!visited[nY][nX] && board[nY][nX] != 'X') {
                    if (nY == ds[0] && nX == ds[1]) {
                        return true;
                    }
                    visited[nY][nX] = true;
                    queue.add(new int[]{nY, nX});
                } else if (!visited[nY][nX] && board[nY][nX] == 'X') {
                    visited[nY][nX] = true;
                    nextQueue.add(new int[]{nY, nX});
                }
            }
        }
        queue.addAll(nextQueue);

        return false;
    }
}
