import java.io.*;
import java.util.*;

public class Soft6288 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wN = br.readLine().split(" ");
        int w = Integer.parseInt(wN[0]);
        int n = Integer.parseInt(wN[1]);

        int[] jL = new int[10001];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int m = Integer.parseInt(inputs[0]);
            int p = Integer.parseInt(inputs[1]);
            jL[p] += m;
        }

        int ans = 0;
        for (int i = 10000; i > 0; i--) {
            if (w <= 0) break;
            if (jL[i] == 0) continue;
            if (w >= jL[i]) {
                ans += i * jL[i];
                w -= jL[i];
            } else {
                ans += i * w;
                w = 0;
            }
        }

        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("" + ans);
        bw.flush();
    }
}

// ---

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String[] wN = br.readLine().split(" ");
//         int w = Integer.parseInt(wN[0]);
//         int n = Integer.parseInt(wN[1]);

//         int[][] jL = new int[n][2];
//         for (int i = 0; i < n; i++) {
//             String[] inputs = br.readLine().split(" ");
//             int m = Integer.parseInt(inputs[0]);
//             int p = Integer.parseInt(inputs[1]);
//             jL[i][0] = m;
//             jL[i][1] = p;
//         }

//         // Arrays.sort(jL, Comparator.comparingInt(i -> i[1]));
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//         for (int i = 0; i < n; i++) {
//             pq.offer(jL[i]);
//         }

//         int ans = 0;
//         int peek = n - 1;
//         while (w > 0 && peek >= 0) {
//             int[] current = pq.poll();
//             int m = current[0];
//             int p = current[1];

//             if (w >= m) {
//                 ans += m * p;
//                 w -= m;
//             } else {
//                 ans += w * p;
//                 w = 0;
//             }
//         }

//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         bw.write("" + ans);
//         bw.flush();
//     }
// }

// ---

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String[] wN = br.readLine().split(" ");
//         int w = Integer.parseInt(wN[0]);
//         int n = Integer.parseInt(wN[1]);

//         List<List<Integer>> jL = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             String[] inputs = br.readLine().split(" ");
//             int m = Integer.parseInt(inputs[0]);
//             int p = Integer.parseInt(inputs[1]);
//             jL.add(Arrays.asList(m, p));
//         }

//         jL.sort(Comparator.comparingInt(a -> a.get(1)));

//         int ans = 0;
//         while (w > 0 && !jL.isEmpty()) {
//             List<Integer> curList = jL.get(jL.size() - 1);
//             jL.remove(jL.size() - 1);            
//             int mount = curList.get(0);
//             int cost = curList.get(1);
//             if (w >= mount) {
//                 ans += mount * cost;
//                 w -= mount;
//             } else {
//                 ans += w * cost;
//                 w = 0;
//             }
//         }
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         bw.write("" + ans);
//         bw.flush();
//     }
// }