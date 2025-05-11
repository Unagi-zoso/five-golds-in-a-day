import java.io.*;
import java.util.*;

class Main {
    public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int ans = 1000;
    public static Set<String> visited = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        char[][] board = new char[n][m];

        int[] red = new int[3];
        int[] blue = new int[3];
        int[] goal = new int[2];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'R') {
                    red = new int[] {i, j, 1};
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    blue = new int[] {i, j, 0};
                    board[i][j] = '.';
                } else if (board[i][j] == 'O') {
                    goal = new int[] {i, j};
                }
            }
        }

        visited.add(genCacheKey(0, red, blue));

        rec(board, 0, red, blue, goal);

        if (ans == 1000) bw.write("-1");
        else bw.write("" + (ans + 1));
        bw.flush();
    }

    public static void rec(char[][] board, int cur, int[] red, int[] blue, int[] goal) {
        if (cur >= 10) {
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int[] newRed = new int[3];
            int[] newBlue = new int[3];
            int[][] o = order(red, blue, i);
            
            int[] first = move(board, o[0], i, null);
            if (first[2] == 1) newRed = new int[] {first[0], first[1], first[2]};
            else if (first[2] == 0) newBlue = new int[] {first[0], first[1], first[2]};

            int[] second = move(board, o[1], i, first);
            if (second[2] == 1) newRed = new int[] {second[0], second[1], second[2]};
            else if (second[2] == 0) newBlue = new int[] {second[0], second[1], second[2]};

            String cacheKey = genCacheKey(cur, newRed, newBlue);
            if (visited.contains(cacheKey)) continue;
            visited.add(cacheKey);

            int result = check(board, newRed, newBlue, goal);
            if (result == 1) continue;
            else if (result == 2) {
                ans = Math.min(ans, cur);
                return;
            }
            rec(board, cur + 1, newRed, newBlue, goal);
        }
    }

    public static int[][] order(int[] red, int[] blue, int d) {
        if (d == 0) {
            if (red[0] < blue[0]) {
                return new int[][] {red, blue};
            } else {
                return new int[][] {blue, red};
            }
        } else if (d == 1) {
            if (red[1] > blue[1]) {
                return new int[][] {red, blue};
            } else {
                return new int[][] {blue, red};
            }
        } else if (d == 2) {
            if (red[0] > blue[0]) {
                return new int[][] {red, blue};
            } else {
                return new int[][] {blue, red};
            }
        } else if (d == 3) {
            if (red[1] < blue[1]) {
                return new int[][] {red, blue};
            } else {
                return new int[][] {blue, red};
            }
        }
        return new int[][] {red, blue};
    }

    public static int check(char[][] board, int[] red, int[] blue, int[] goal) {
        if (blue[0] == goal[0] && blue[1] == goal[1]) return 1; // 실패
        else if (red[0] == goal[0] && red[1] == goal[1]) return 2; // 성공
        return 3; // continue;
    }

    public static int[] move(char[][] board, int[] bid, int d, int[] blocked) {
        int validY = bid[0];
        int validX = bid[1];
        for (int i = 0; i < 10; i++) {
            int nY = validY + dir[d][0];
            int nX = validX + dir[d][1];

            if (nY < 0 || nY >= board.length || nX < 0 || nX >= board[0].length) {
                return new int[] {validY, validX, bid[2]};
            }
            if (board[nY][nX] == '#') {
                return new int[] {validY, validX, bid[2]};
            }
            if (board[nY][nX] == 'O') {
                return new int[] {nY, nX, bid[2]};
            }
            if (blocked != null && nY == blocked[0] && nX == blocked[1]) {
                return new int[] {validY, validX, bid[2]};
            }
            validY = nY;
            validX = nX;
        }
        return new int[] {validY, validX, bid[2]};
    }

    public static String genCacheKey(int turn, int[] red, int[] blue) {
        return ("" + turn + " " + blue[0] + " " + blue[1] + " " + red[0] + " " + red[1]);
    }
}

/*
 * 재귀, DFS 를 이용한 풀이
 * BFS 를 이용해 최단경로 구하는 문제.. 최소 몇 번 이란 키워드가 핵심인듯허다.
 * #, O, . , 구슬들 사이의 다양한 조건이 헷갈린다. 테스트 케이스가 많아서 맞춘 문제 (켁..)
 * DFS 는 최단비용을 고려하지 않았다. 그래서 캐시 조건에 비용도 반영을 했는데 마음에 들진 않는다.
 * 다음엔 꼭 BFS 로.. 값비싼 보드 복사없이 구슬만 복사하는건 정말 좋은 전략같다.
 */