import java.util.*;
import java.io.*;

public class Boj21610 {
    public static int[][] dir8Side = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    public static int[][] dir4Side = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void move(int n, int[] d, int am) {
            this.y = (n * 60 + this.y + (d[0] * am)) % n; // 순환 몇번 할줄 모르니 정수배
            this.x = (n * 60 + this.x + (d[1] * am)) % n;
        }

        public void updateBySide(int n, int[][] field) {
            for (int[] curD : dir4Side) {
                int nY = this.y + curD[0];
                int nX = this.x + curD[1];
                if (nY >= 0 && nY < n && nX >= 0 && nX < n && field[nY][nX] > 0) {
                    field[this.y][this.x]++;
                }
            }
        }

        @Override
        public String toString() {
            return "" + this.y + " "  + this.x;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][] field = new int[n][n];

        for (int i = 0; i < n; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        List<Point> curC = new ArrayList<>(Arrays.asList(
            new Point(n - 2, 0),
            new Point(n - 2, 1),
            new Point(n - 1, 0),
            new Point(n - 1, 1)
        ));

        while (m-- > 0) {
            inputs = br.readLine().split(" ");
            int d = Integer.parseInt(inputs[0]) - 1;
            int lv = Integer.parseInt(inputs[1]);

            Set<Point> visited = new HashSet<>();

            for (Point p : curC) {
                p.move(n, dir8Side[d], lv);
                field[p.y][p.x]++;
                visited.add(p);
            }

            // System.out.println(visited.toString());

            for (Point p : curC) {
                p.updateBySide(n, field);
            }

            curC = getCurClouds(n, field, visited);

            // for (int i = 0; i < n; i++) {
            //     System.out.println(Arrays.toString(field[i]));
            // }
            // System.out.println();
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalWater += field[i][j];
            }
        }

        bw.write(String.valueOf(totalWater));
        bw.flush();
    }

    public static List<Point> getCurClouds(int n, int[][] field, Set<Point> prev) {
        List<Point> newClouds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] >= 2 && !prev.contains(new Point(i, j))) {
                    field[i][j] -= 2;
                    newClouds.add(new Point(i, j));
                }
            }
        }

        return newClouds;
    }
}


