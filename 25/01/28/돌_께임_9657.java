import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 돌_께임_9657 {
    public static void main(String[] args) throws Exception {
        boolean[] canWin = new boolean[1005];
        canWin[1] = true;
        canWin[2] = false;
        canWin[3] = true;
        canWin[4] = true;

        for(int i = 5; i < 1005; i++) {
            canWin[i] = !canWin[i - 1] || !canWin[i - 3] || !canWin[i - 4];
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (canWin[n]) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        bw.flush();
    }
}

// 1 승, 2 승, 3 승, 4 승, 5 패, 6 승, 7 패, 8승, 9승, 10 승 , 11 승 12 패 13 승 14 패 15 승 16 승
