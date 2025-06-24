import java.io.*;
import java.util.*;

class Main {
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] start = {-1, -1};
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
                if ((i == 0 || i == n-1) && start[0] == -1 && board[i][j] == 0) {start[0] = i; start[1] = j;}  
                if ((j == 0 || j == m-1) && start[0] == -1 && board[i][j] == 0) {start[0] = i; start[1] = j;}  
            }
        }

        board[start[0]][start[1]] = 2;
        
        if (start[0] == -1) { // don't care?
            bw.write(0);
            bw.flush();
            return;
        }

        int curTurn = 0;
        
        List<int[]> curQ = findAllOutline(board, start);
        List<int[]> erasedQ = new ArrayList<>();
        while (!curQ.isEmpty()) {
            curTurn++;
            for (int[] q : curQ) {
                int airContactCnt = 0;
                for (int[] d : dir) {
                    int nY = q[0] + d[0];
                    int nX = q[1] + d[1];
                    if (nY < 0 || nY >= n || nX < 0 || nX >= m) continue;
                    if (board[nY][nX] == 2) airContactCnt++;
                }
                if (airContactCnt >= 2) erasedQ.add(q);
            }
            for (int[] q : erasedQ) {
                board[q[0]][q[1]] = 0;
            }
            erasedQ.clear();
            curQ = findAllOutline(board, start);
        }

        bw.write(String.valueOf(curTurn));
        bw.flush();
        bw.close();
        br.close();
    }

    static List<int[]> findAllOutline(int[][] board, int[] start) {
        
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        List<int[]> ret = new ArrayList<>();
        LinkedList<int[]> q = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int[] d : dir) {
                int nY = y + d[0];
                int nX = x + d[1];
                if (nY < 0 || nY >= n || nX < 0 || nX >= m) continue;
                if (visited[nY][nX]) continue;
                visited[nY][nX] = true;
                if (board[nY][nX] == 1) ret.add(new int[] {nY, nX});
                else {
                    board[nY][nX] = 2;
                    q.offer(new int[] {nY, nX});
                }
            }
        }
        return ret;
    }
}

/**
 * When an object's state must be maintained during a turn, collect all changes 
 * in a separate container, then apply them all at once when the current turn ends.
 * The erasedQ serves this purpose. Additionally, outside air and inside air 
 * must be strictly distinguished and managed as separate states.
 */