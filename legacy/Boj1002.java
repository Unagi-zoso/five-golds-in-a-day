import java.lang.*;
import java.util.*;
import java.io.*;

public class Boj1002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        while (repeat-- != 0) {
    StringTokenizer st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 인터프리터 언어도 js 는 호이스팅으로 사전에 변수만들고 자바도 그런가? 미리 만들어두나?
            double dist = Math.sqrt(Math.pow((long) y1 - y2, 2) + Math.pow((long) x1 - x2, 2));
            if (y1 == y2 && x1 == x2 && r1 == r2) bw.write("-1\n");
            else if (dist > Math.abs(r1 + r2)) bw.write("0\n");
            else if (dist == Math.abs(r1 + r2)) bw.write("1\n");
            else if (dist > Math.abs(r1 - r2)) bw.write("2\n");
            else if (dist == Math.abs(r1 - r2)) bw.write("1\n");
            else if (dist < Math.abs(r1 - r2)) bw.write("0\n");
        }
        bw.flush();
    }    
}

/*
 * 1 1 1 1 1 1
 * 1 1 1 1 1 2
 * -1 -1 1 -2 -2 5
 */