import java.io.*;
import java.util.*;

class BOGGLE {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            char[][] board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                board[i] = br.readLine().toCharArray();
            }

            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                String target = br.readLine();
                boolean result = solve(board, target);
                bw.write(target + " " + (result ? "YES" : "NO") + "\n");
            }
        }
        bw.flush();
    }

    public static boolean solve(char[][] board, String target) {
        Map<String, Boolean> dp = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target.charAt(0)) {
                    if (rec(board, dp, target, i, j)) return true;
                }
            }
        }
        return false;
    }

    public static boolean rec(char[][] board, Map<String, Boolean> dp, String target, int y, int x) {
        if (target.charAt(0) != board[y][x]) return false;
        String dpKey = y + " " + x + " " + target;
        if (target.length() == 1) {
            dp.put(dpKey, true);
            return true;
        }
        if (dp.containsKey(dpKey)) return dp.get(dpKey);
        dp.put(dpKey, false);
        for (int[] nd : dir) {
            int ny = y + nd[0], nx = x + nd[1];
            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) continue;
            if (board[ny][nx] == target.charAt(1) && rec(board, dp, target.substring(1), ny, nx)) {
                dp.put(dpKey, true);
                return true;
            }
        }
        return false;
    }
}