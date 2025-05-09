import java.io.*;

class Main {
    static class Dice {
        private int[] nums = new int[6];
        public void updateBottom(int n) {
            nums[5] = n;
        }
        public int getTop() {
            return nums[0];
        }
        public int getBottom() {
            return nums[5];
        }
        public void rotate(int dir) {
            if (dir == 0) { // east
                int temp = nums[0];
                nums[0] = nums[3];
                nums[3] = nums[5];
                nums[5] = nums[2];
                nums[2] = temp;
            } else if (dir == 1) { // west
                int temp = nums[0];
                nums[0] = nums[2];
                nums[2] = nums[5];
                nums[5] = nums[3];
                nums[3] = temp;
            } else if (dir == 2) { // north
                int temp = nums[0];
                nums[0] = nums[4];
                nums[4] = nums[5];
                nums[5] = nums[1];
                nums[1] = temp;
            } else if (dir == 3) { // south
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = nums[5];
                nums[5] = nums[4];
                nums[4] = temp;
            }
        }
    }

    public static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Dice dice = new Dice();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int y = Integer.parseInt(inputs[2]);
        int x = Integer.parseInt(inputs[3]);
        int k = Integer.parseInt(inputs[3]);
        
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int validY = y;
        int validX = x;
        inputs = br.readLine().split(" ");
        for (int i = 0; i < inputs.length; i++) {
            int oper = Integer.parseInt(inputs[i]) - 1;

            int nY = validY + dir[oper][0];
            int nX = validX + dir[oper][1];

            if (nY < 0 || nY >= n || nX < 0 || nX >= m) continue;
            validY = nY;
            validX = nX;

            dice.rotate(oper);
            int rst = dice.getTop();
            bw.write("" + rst + "\n");

            if (board[validY][validX] == 0) {
                board[validY][validX] = dice.getBottom();
            } else {
                dice.updateBottom(board[validY][validX]);
                board[validY][validX] = 0;
            }
        }
        bw.flush();
    }
}