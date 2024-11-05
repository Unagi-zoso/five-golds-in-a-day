import java.util.*;
import java.io.BufferedReader;
import java.io.*;

public class Boj3197 {
    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        char[][] board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String tS = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = tS.charAt(j);
            }
        }

        int birdsCount = 0;
        int[][] birds = new int[2][2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'L') {
                    birds[birdsCount][0] = i;
                    birds[birdsCount][1] = j;
                    birdsCount++;
                }
            }
        }
        
        int answer = 0;
        while (true) {
            boolean flag = bfs(r, c, board, birds[0], birds[1]);
            if (flag) {
                System.out.println(answer);
                return;
            }
            
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    for (int d = 0; d < 4; d++) {
                        int edgeY = i + dir[d][0], edgeX = j + dir[d][1];
                        if (edgeY < 0 || edgeY >= r || edgeX < 0 || edgeX >= c) continue;
                        if (board[i][j] == 'X' && board[edgeY][edgeX] == '.') {
                            queue.add(new int[] { i, j });
                            break;
                        }
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.pollFirst();
                int y = cur[0], x = cur[1];
                board[y][x] = '.';
            }
            answer++;
        }
    }

    public static boolean bfs(int r, int c, char[][] board, int[] st, int[] ds) {
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited[i][j] = false;
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(st);
        visited[st[0]][st[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int y = cur[0], x = cur[1];

            for (int d = 0; d < 4; d++) {
                int nY = y + dir[d][0], nX = x + dir[d][1];
                if (nY < 0 || nY >= r || nX < 0 || nX >= c) continue;
                
                if (visited[nY][nX] || board[nY][nX] == 'X') continue;
                if (nY == ds[0] && nX == ds[1]) {
                    
                    return true;
                }
                visited[nY][nX] = true;
                queue.add(new int[] { nY, nX });
            }
        }
        
        return false;
    }
}
