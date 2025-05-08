import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Vector {
    int y = 0;
    int x = 0;

    Vector(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public static int calcCCW(Vector v1, Vector v2, Vector v3) {
        long lhs = (long)v1.x * v2.y + (long)v2.x * v3.y + (long)v3.x * v1.y;
        long rhs = (long)v1.y * v2.x + (long)v2.y * v3.x + (long)v3.y * v1.x;
        long result = lhs - rhs;
        if (result > 0) { return 1; }
        else if (result < 0) { return -1; }
        else { return 0; }
    }

    public static int solve(Vector v1, Vector v2, Vector v3, Vector v4) {
        int ccw123 = calcCCW(v1, v2, v3);
        int ccw124 = calcCCW(v1, v2, v4);
        int ccw341 = calcCCW(v3, v4, v1);
        int ccw342 = calcCCW(v3, v4, v2);
        
        if (ccw123 * ccw124 == 0 && ccw341 * ccw342 == 0) {
            if (
                Math.min(v1.x, v2.x) <= Math.max(v3.x, v4.x) &&
                Math.max(v1.x, v2.x) >= Math.min(v3.x, v4.x) &&
                Math.min(v1.y, v2.y) <= Math.max(v3.y, v4.y) &&
                Math.max(v1.y, v2.y) >= Math.min(v3.y, v4.y)) {
                    return 1;
            }
            return 0;
        }
        System.out.println("" + ccw123 + " " + ccw124 + " " + ccw341 + " " + ccw342);
        if (ccw123 * ccw124 <= 0 && ccw341 * ccw342 <= 0) {
            return 1;
        }
        return 0;
    }
}


public class Boj17387 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        Vector v1, v2, v3, v4;

        int x1, y1, x2, y2, x3, y3, x4, y4;

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());
        x4 = Integer.parseInt(st.nextToken());
        y4 = Integer.parseInt(st.nextToken());

        v1 = new Vector(y1, x1);
        v2 = new Vector(y2, x2);
        v3 = new Vector(y3, x3);
        v4 = new Vector(y4, x4);

        int ans = Vector.solve(v1, v2, v3, v4);
        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}