import java.io.*;
import java.util.*;

class Main {
    public static int[][][] dir = {
        {{0, 0}, {0, 1}, {0, 1}, {0, 1}},
        {{0, 0}, {1, 0}, {1, 0}, {1, 0}},
        {{0, 0}, {1, 0}, {0, 1}, {-1, 0}},
        {{0, 0}, {1, 0}, {1, 0}, {0, 1}},
        {{0, 0}, {0, 1}, {0, 1}, {-1, 0}},
        {{0, 0}, {0, 1}, {1, 0}, {1, 0}},
        {{0, 0}, {1, 0}, {-1, 1}, {0, 1}},
        {{0, 0}, {1, 0}, {1, 0}, {0, -1}},
        {{0, 0}, {0, 1}, {0, 1}, {1, 0}},
        {{0, 0}, {0, 1}, {1, -1}, {1, 0}},
        {{0, 0}, {1, 0}, {0, 1}, {0, 1}},
        {{0, 0}, {1, 0}, {0, 1}, {1, 0}},
        {{0, 0}, {0, 1}, {-1, 0}, {0, 1}},
        {{0, 0}, {1, 0}, {0, -1}, {1, 0}},
        {{0, 0}, {0, 1}, {1, 0}, {0, 1}},
        {{0, 0}, {0, 1}, {0, 1}, {1, -1}},
        {{0, 0}, {1, 0}, {1, 0}, {-1, 1}},
        {{0, 0}, {0, 1}, {0, 1}, {-1, -1}},
        {{0, 0}, {1, 0}, {1, 0}, {-1, -1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(inputs[j]);
                board[i][j] = num;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, compose(board, n, m, i, j));
            }
        }

        bw.write("" + ans + "\n");
        bw.flush();
    }

    public static int compose(int[][] board, int n, int m, int y, int x) {
        int maxValue = 0;
        for (int i = 0; i < dir.length; i++) {
            int[][] curForm = dir[i];
            int sumValue = 0;
            int ny = y, nx = x;
            for (int j = 0; j < curForm.length; j++) {
                ny += curForm[j][0];
                nx += curForm[j][1];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) break;
                sumValue += board[ny][nx];
            }
            maxValue = Math.max(maxValue, sumValue);
        }
        return maxValue;
    }
}

/*
 * 회전, 대칭을 적용한 도형들은 전부 오리지널과는 관계없는 새로운 도형으로 판단해라.
 * 각 좌표마다 이 좌표껴서 일관성 있게 도형들을 적용할 수 있는지 판단. 가능하다면 그 합을 반환해서 결정
 */