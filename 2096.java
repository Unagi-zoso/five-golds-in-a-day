import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        int[][] mxdp = new int[n][3];
        mxdp[0][0] = arr[0][0];
        mxdp[0][1] = arr[0][1];
        mxdp[0][2] = arr[0][2];

        int[][] mndp = new int[n][3];
        mndp[0][0] = arr[0][0];
        mndp[0][1] = arr[0][1];
        mndp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            mxdp[i][0] = Math.max(mxdp[i-1][0], mxdp[i-1][1]) + arr[i][0];
            mxdp[i][1] = Arrays.stream(mxdp[i-1]).max().orElse(0) + arr[i][1];
            mxdp[i][2] = Math.max(mxdp[i-1][1], mxdp[i-1][2]) + arr[i][2];

            mndp[i][0] = Math.min(mndp[i-1][0], mndp[i-1][1]) + arr[i][0];
            mndp[i][1] = Arrays.stream(mndp[i-1]).min().orElse(0) + arr[i][1];
            mndp[i][2] = Math.min(mndp[i-1][1], mndp[i-1][2]) + arr[i][2];
        }

        int mxAns = Arrays.stream(mxdp[n-1]).max().orElse(0);
        int mnAns = Arrays.stream(mndp[n-1]).min().orElse(0);
        bw.write(String.valueOf(mxAns) + " " + String.valueOf(mnAns));
        bw.flush();
    }
}