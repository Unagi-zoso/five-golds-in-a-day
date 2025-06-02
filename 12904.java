import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        String t = br.readLine();

        while (s.length() != t.length()) {
            char added = t.charAt(t.length()-1);
            t = t.substring(0, t.length()-1);
            if (added == 'B') {
                StringBuilder sb = new StringBuilder(t);
                t = sb.reverse().toString();
            }
        }
        bw.write(String.valueOf(s.equals(t) ? 1 : 0));
        bw.flush();
    }
}