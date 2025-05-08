import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Soft6283 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strInputs = br.readLine().split(" ");
        int[] inputs = Arrays.stream(strInputs).mapToInt(Integer::parseInt).toArray();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int state = 0;
        for (int i = 1; i < 8; i++) {
            if (inputs[i] < inputs[i - 1]) {
                if (state == 0) {
                    state = 1; // descending
                } else if (state == 2) {
                    state = 3; // mixed
                    break;
                }
            } else if (inputs[i] > inputs[i - 1]) {
                if (state == 0) {
                    state = 2; // ascending
                } else if (state == 1) {
                    state = 3; // mixed
                    break;
                }
            }
        }

        if (state == 1) {
            bw.write("descending");
        } else if (state == 2) {
            bw.write("ascending");
        } else if (state == 3) {
            bw.write("mixed");
        }
        bw.flush();
    }   
}
