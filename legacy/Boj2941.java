import java.lang.*;
import java.util.*;
import java.io.*;

public class Boj2941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();

        int ans = 0;
        int state = 0;
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (state == 0) {
                if (c == 'c') {
                    state = 1;
                } else if (c == 'd') {
                    state = 2;
                } else if (c == 'l') {
                    state = 3;
                } else if (c == 'n') {
                    state = 4;
                } else if (c == 's') {
                    state = 5;
                } else if (c == 'z') {
                    state = 6;
                } else {
                    if (c != '-' && c != '=') ans++;
                }
                i++;
            } else if (state == 1) {
                if (c == '=') {
                    ans++;
                    state = 0;
                } else if (c == '-') {
                    ans++;
                    state = 0;
                } else {
                    ans++;
                    state = 0;
                    continue;
                }
                i++;
            } else if (state == 2) {
                if (c == 'z') {
                    state = 7;
                } else if (c == '-') {
                    ans++;
                    state = 0;
                } else {
                    ans++;
                    state = 0;
                    continue;
                }
                i++;
            } else if (state == 3) {
                if (c == 'j') {
                    ans++;
                    state = 0;
                } else {
                    ans++;
                    state = 0;
                    continue;
                }
                i++;
            } else if (state == 4) {
                if (c == 'j') {
                    ans++;
                    state = 0;
                } else {
                    ans++;
                    state = 0;
                    continue;
                }
                i++;
            } else if (state == 5) {
                if (c == '=') {
                    ans++;
                    state = 0;
                } else {
                    ans++;
                    state = 0;
                    continue;
                }
                i++;
            } else if (state == 6) {
                if (c == '=') {
                    ans++;
                    state = 0;
                } else {
                    ans++;
                    state = 0;
                    continue;
                }
                i++;
            } else if (state == 7) {
                if (c == '=') {
                    ans++;
                    state = 0;
                } else {
                    ans += 2;
                    state = 0;
                    continue;
                }
                i++;
            }
        }

        if (state == 1) {
            ans++;
        } else if (state == 2) {
            ans++;
        } else if (state == 3) {
            ans++;
        } else if (state == 4) {
            ans++;
        } else if (state == 5) {
            ans++;
        } else if (state == 6) {
            ans++;
        } else if (state == 7) {
            ans += 2;
        }

        bw.write("" + ans);
        bw.flush();
    }
}
