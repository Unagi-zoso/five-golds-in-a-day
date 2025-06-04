import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() >= t.length()) {
                int st = sb.length() - t.length();
                int ed = st + t.length();
                boolean boomFlag = true;
                for (int i = st; i < ed; i++) {
                    if (sb.charAt(i) != t.charAt(i - st)) {
                        boomFlag = false;
                        break;
                    }
                }
                if (boomFlag) {
                    sb.delete(st, ed);
                }
            }
        }
        bw.write(sb.length() == 0 ? "FRULA" : sb.toString());
        bw.flush();
    }
}