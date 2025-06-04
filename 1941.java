import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int ans = comb(board, 0, 0, 0, new ArrayList<>());
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    public static int comb(char[][] board, int stIdx, int cur, int sCnt, List<Integer> temp) {
        if (7 - cur + sCnt < 4) return 0;
        if (cur >= 7) {
            if (sCnt >= 4) {
                return isNear(board, temp) ? 1 : 0;
            }
            return 0;
        }
        int ret = 0;
        for (int i = stIdx; i < 25; i++) {
            int curY = i / 5;
            int curX = i % 5;
            int newSCnt = sCnt + (board[curY][curX] == 'S' ? 1 : 0);
            temp.add(i);
            ret += comb(board, i + 1, cur + 1, newSCnt, temp);
            temp.remove(temp.size()-1);
        }
        return ret;
    }

    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean isNear(char[][] board, List<Integer> nodes) {
        LinkedList<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        int cnt = 1;
        int cY = nodes.get(0) / 5;
        int cX = nodes.get(0) % 5;
        visited[cY][cX] = true;
        q.add(nodes.get(0));
        while (!q.isEmpty()) {
            int cur = q.poll();
            cY = cur / 5;
            cX = cur % 5;
            for (int i = 0; i < 4; i++) {
                int nY = cY + dir[i][0];
                int nX = cX + dir[i][1];
                if (nY < 0 || nY >= 5 || nX < 0 || nX >= 5) continue;
                boolean flag = false;
                for (int node : nodes) {
                    if (node == nY * 5 + nX) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) continue;
                if (visited[nY][nX]) continue;
                visited[nY][nX] = true;
                cnt++;
                q.offer(nY * 5 + nX);
            }
        }
        return cnt == 7;
    }
}

