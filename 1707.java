import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int cntV = Integer.parseInt(input[0]);
            int cntE = Integer.parseInt(input[1]);

            List<List<Integer>> map = new ArrayList<>();
            for (int i = 0; i <= cntV; i++) {
                map.add(new ArrayList<>());
            }
            for (int i = 0; i < cntE; i++) {
                input = br.readLine().split(" ");
                int v1 = Integer.parseInt(input[0]);
                int v2 = Integer.parseInt(input[1]);

                map.get(v1).add(v2);
                map.get(v2).add(v1);
            }

            List<Set<Integer>> sets = new ArrayList<>();
            sets.add(new HashSet<>());
            sets.add(new HashSet<>());
            
            boolean result = true;
            for (int i = 1; i <= cntV; i++) {
                if (sets.get(0).contains(i) || sets.get(1).contains(i)) continue;
                result &= rec(map, sets, 0, i);
            }
            bw.write((result ? "YES" : "NO") + "\n");
        }
        bw.flush();
    }

    public static boolean rec(List<List<Integer>> map, List<Set<Integer>> sets, int cur, int v) {
        if (sets.get(cur).contains(v)) return true;
        if (sets.get((cur + 1) % 2).contains(v)) return false;
        sets.get(cur).add(v);
        boolean result = true;
        for (int nv : map.get(v)) {
            result &= rec(map, sets, (cur + 1) % 2, nv);
        }
        return result;
    }
}