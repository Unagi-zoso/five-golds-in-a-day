import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int ans = -1;
    public static Set<String> merged = new HashSet<>();
    public static String curTime = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        rec(n, board, 0);

        bw.write("" + ans);
        bw.flush();
    }

    public static void rec(int n, int[][] board, int cur) {
        if (cur >= 5) {
            int curMax = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    curMax = Math.max(curMax, board[i][j]);
                }
            }
            ans = Math.max(ans, curMax);
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int[][] newBoard = copyMatrix(board);
            curTime = genMergeKey(cur, i);
            moveCurDir(newBoard, i);
            rec(n, newBoard, cur + 1);
        }
    }

    public static int[][] copyMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void moveCurDir(int[][] board, int d) {
        merged.clear();

        if (d == 0) {
            for (int j = 0; j < board[0].length; j++) {
                for (int i = 0; i < board.length; i++) {
                    if (board[i][j] == 0) continue;
                    move(board, i, j, d);    
                }
            }
        } else if (d == 1) {
            for (int i = 0; i < board.length; i++) {
                for (int j = board[0].length - 1; j >= 0 ; j--) {
                    if (board[i][j] == 0) continue;
                    move(board, i, j, d);    
                }
            }
        } else if (d == 2) {
            for (int j = 0; j < board[0].length; j++) {
                for (int i = board.length - 1; i >= 0 ; i--) {
                    if (board[i][j] == 0) continue;
                    move(board, i, j, d);    
                }
            }
        } else if (d == 3) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 0) continue;
                    move(board, i, j, d);    
                }
            }
        }
    }

    public static void move(int[][] board, int y, int x, int d) {
        int curVal = board[y][x];
        board[y][x] = 0;

        int validY = y;
        int validX = x;
        int ny = y, nx = x;
        for (int i = 0; i < 20; i++) {
            ny += dir[d][0];
            nx += dir[d][1];

            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) break;
            if (board[ny][nx] == curVal && !merged.contains(genMergeKey(ny, nx))) {
                validY = ny;
                validX = nx;
                board[validY][validX] *= 2;
                merged.add(genMergeKey(ny, nx));
                return;
            }
            if (board[ny][nx] != 0) break;
            validY = ny;
            validX = nx;
        }
        board[validY][validX] = curVal;
    }

    public static String genMergeKey(int y, int x) {
        return "" + y + " " + x;
    }

    public static void show(int[][] board) {
        for (int k = 0; k < board.length; k++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("" + board[k][j] + " ");
            }
            System.out.println();
        }    
        System.out.println();
    }
}
/*
 * 
 * 최대 깊이 5 방향은 4개 .
 * move according direction
 * always matrix copy
 * 
 * bruteforth, loop, dfs feel, how change detection (hash set clear : key - pos)
 * 
 * 
 * 실수 - 0 패스하기
 * 인풋 j 로 안하고 i 로 하기
 * 정적 curTime 으로 다루기 좋았다. 관찰 굳
 * 
 * validY, X 로 다루기 좋았따.
 * 
 * cur 0에서부터 시작해 퍼져나가기 좋았따.
 * 
 */