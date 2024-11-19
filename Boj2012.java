import java.util.*;
import java.io.*;

public class Boj2012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        for (int i = 0; i < n; i++) {
            numbers[i + 1] = Integer.parseInt(br.readLine());
        }

        List<Integer> duplicatedNumbers = new ArrayList<>();
        boolean[] visit = new boolean[500005];

        List<Long> ranking = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (visit[numbers[i]]) {
                visit[numbers[i]] = !visit[numbers[i]];
                continue;
            }
            ranking.add(0L + i);
            duplicatedNumbers.add(numbers[i]);
        }

        Collections.sort(duplicatedNumbers);

        Long ans = 0L;
        for (int i = 0; i < ranking.size(); i++) {
            ans += Math.abs(ranking.get(i) - duplicatedNumbers.get(i));
        }

        bw.write("" + ans);
        bw.flush();
    }
    
}
