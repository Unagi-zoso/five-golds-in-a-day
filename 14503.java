import java.io.*;

class Main {
    public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        inputs = br.readLine().split(" ");
        int cy = Integer.parseInt(inputs[0]);
        int cx = Integer.parseInt(inputs[1]);
        int d = Integer.parseInt(inputs[2]);
        
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int ans = 0;

        while (true) {
            // 1
            if (board[cy][cx] == 0) {
                board[cy][cx] = 2;
                ans++;
            }

            // 2
            if (check4Dir(board, cy, cx)) {
                int ny = cy - dir[d][0];
                int nx = cx - dir[d][1];

                if (board[ny][nx] == 1) break;
                cy = ny;
                cx = nx;
                continue;
            } else { // 3
                d = (3 + d) % 4;
                int ny = cy + dir[d][0];
                int nx = cx + dir[d][1];

                // if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) continue;
                if (board[ny][nx] == 0) {
                    cy = ny;
                    cx = nx;
                }
            }
        }

        bw.write("" + ans);
        bw.flush();
    }

    // 청소 안된게 하나라도 있다면 false
    // 그외 전부 청소되었거나 벽으로 구성되어있을 경우 true
    public static boolean check4Dir(int[][] board, int cy, int cx) {
        for (int i = 0; i < dir.length; i++) {
            int ny = cy + dir[i][0];
            int nx = cx + dir[i][1];

            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) continue;
            if (board[ny][nx] == 0) return false;
        }

        return true;
    }
}

/*
 * 1. 현재 칸 청소 (시작 칸은 청소된 상태 언제 이동하냐. 이동하는게 먼저가 아니라 청소가 먼저 나오네)
 * 2. 스캔 4 방향 (전부 청소되어있다면) - 방향은 유지한채 한 칸 후진한다. 그리고 1번으로, 뒤가 벽이라면 종료!
 * 3. 스캔 4 방향 (정리안된데가 있다면) - 반시계방향으로 회전한다.(3 + d) % 4. 그 앞이 청소되지 않았따면 .. 전진 
 */