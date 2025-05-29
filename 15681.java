import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MX = 100000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int cntQ = Integer.parseInt(st.nextToken());

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] dp = new int[MX + 5];
        boolean[] isVisited = new boolean[MX + 5];
        isVisited[root] = true;
        rec(dp, isVisited, tree, root);

        for (int i = 0; i < cntQ; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(dp[cur] + "\n"));
        }
        bw.flush();
    }

    public static int rec(int[] dp, boolean[] isVisited, List<List<Integer>> adjc, int cur) {
        if (dp[cur] != 0) return dp[cur];
        int sum = 1;
        for (Integer next : adjc.get(cur)) {
            if (isVisited[next]) continue;
            isVisited[next] = true;
            sum += rec(dp, isVisited, adjc, next);
        }
        dp[cur] = sum;
        return dp[cur];
    }
}
