import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int H = Integer.parseInt(inputs[0]);
        int W = Integer.parseInt(inputs[1]);
        int N = Integer.parseInt(inputs[2]);
        int M = Integer.parseInt(inputs[3]);

        int ans = 1;
        ans *= (H / (N + 1)) + ((H % (N + 1) == 0) ? 0 : 1);
        ans *= (W / (M + 1)) + ((W % (M + 1) == 0) ? 0 : 1);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}