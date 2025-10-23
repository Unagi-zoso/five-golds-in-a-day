import java.io.*;

class Main {

/*
x를 만날때마다 분기.
*/
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            String input = br.readLine();
            bw.write(rec(input) + '\n');
        }
        bw.flush();
    }

    public static String rec(String input) {
        if (input.charAt(0) != 'x') return "" + input.charAt(0);
        String lh = rec(input.substring(1));
        String rh = rec(input.substring(1 + lh.length()));
        String ll = rec(input.substring(1 + lh.length() + rh.length()));
        String rl = rec(input.substring(1 + lh.length() + rh.length() + ll.length()));
        return "x" + ll + rl + lh + rh;
    }
}