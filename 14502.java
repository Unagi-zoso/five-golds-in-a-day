import java.io.*;
import java.util.*;

class Main {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        LinkedList<int[]> virusQ = new LinkedList<>();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
                if (board[i][j] == 2) virusQ.offer(new int[] {i, j});
            }
        }

        List<List<int[]>> combResult = new ArrayList<>();
        comb(0, 0, board, 0, new ArrayList<>(), combResult);

        int ans = 0;
        for (int i = 0; i < combResult.size(); i++) {
            List<int[]> newWalls = combResult.get(i);
            int[][] newBoard = copyBoard(board);
            for (int j = 0; j < newWalls.size(); j++) {
                int[] wall = newWalls.get(j);
                newBoard[wall[0]][wall[1]] = 1;
            }
            LinkedList<int[]> newVirusQ = new LinkedList<>(virusQ);
            spread(newBoard, newVirusQ);
            int sumVal = 0;
            for (int j = 0; j < newBoard.length; j++) {
                for (int k = 0; k < newBoard[0].length; k++) {
                    if (newBoard[j][k] == 0) sumVal++;
                }
            }
            ans = Math.max(ans, sumVal);
            for (int j = 0; j < newWalls.size(); j++) {
                int[] wall = newWalls.get(j);
                newBoard[wall[0]][wall[1]] = 0;
            }
        }

        bw.write("" + ans);
        bw.flush();
    }

    /*
     * temp : {{1, 1}, {2, 2}, {3, 3}}
     */
    public static void comb(int startY, int startX, int[][] board, int cur, List<int[]> temp, List<List<int[]>> result) {
        if (cur >= 3) {
            result.add(temp);
            return;
        }
        
        for (int i = startY; i < board.length; i++) {
            for (int j = (i == startY ? startX : 0); j < board[0].length; j++) {
                if (board[i][j] != 0) continue;
                List<int[]> newTemp = new ArrayList<>(temp);
                newTemp.add(new int[] {i, j});
                comb(i, j + 1, board, cur + 1, newTemp, result);
            }
        }
    }

    public static void spread(int[][] board, LinkedList<int[]> virusQ) {
        while (!virusQ.isEmpty()) {
            int[] cur = virusQ.poll();
            for (int i = 0; i < dir.length; i++) {
                int ny = cur[0] + dir[i][0];
                int nx = cur[1] + dir[i][1];

                if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) continue;
                if (board[ny][nx] != 0) continue;
                board[ny][nx] = 2;
                virusQ.offer(new int[] {ny, nx});
            }
        }
    }

    public static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }
}

/*
 * 2차원 배열의 comb 생성이 조금 번거롭다. 순서를 구분 안하는 조합? 문제라서 ..
 * 위에서부터 하나하나 처리를 해야한다. 근데 애초에 평탄화 시켜서 진행하는게 나을듯
 * 중복 피하고 순서를 맞추기위해 startY, startX 를 써야하고 2차원 배열이라 startX 는 
 * 새로운 행일때만 0에서부터 시작시켜야한다.
 */