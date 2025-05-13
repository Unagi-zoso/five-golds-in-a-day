import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int l = Integer.parseInt(inputs[1]);
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] curLine = new int[n];
            for (int j = 0; j < n; j++) {
                curLine[j] = board[i][j];
            }

            if (isValid(curLine, l)) {
                ans++;
            }
            for (int j = 0; j < n; j++) {
                curLine[j] = board[j][i];
            }
            
            if (isValid(curLine, l)) {
                ans++;
            }
        }
        
        bw.write("" + ans);
        bw.flush();
    }

    public static boolean isValid(int[] line, int threshold) {
        boolean isFirst = true;
        int prevHeight = line[0];
        int prevUnusedLength = 1;
        int curHeight = line[0];
        int curUnusedLength = 1;
        int status = 0; // 0 : 이전과 현재의 높이가 같음 , 1 : 상승, 2 : 하강

        for (int i = 1; i < line.length; i++) {
            curHeight = line[i];
            if (Math.abs(curHeight - prevHeight) > 1) return false;
            if (Math.abs(curHeight - prevHeight) == 1) {
                isFirst = false;
                curUnusedLength = 1;
                if (curHeight > prevHeight) status = 1;
                else if (curHeight < prevHeight) status = 2;
            } else {
                status = 0;
                curUnusedLength++;
            }

            if (!isFirst && status == 1) {
                if (prevUnusedLength < threshold) return false;
                prevUnusedLength -= threshold;
            } else if (!isFirst && status == 2) {
                for (int j = 0; j < threshold; j++) {
                    if (i + j >= line.length) return false;
                    if (line[i + j] != curHeight) return false;
                }
                i += threshold - 1;
                curUnusedLength = 0;
            }
            prevHeight = curHeight;
            prevUnusedLength = curUnusedLength;
        }
        
        return true;
    }
}
/*
 * 복잡하고 어렵다잉. 상황에 따라 다양한 패턴이 나올 수 있어 혼신을 다해야한다. 여기서 능지차이가 나는거 같다.
 */