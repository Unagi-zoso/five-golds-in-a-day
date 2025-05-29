import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MX = 100000;
        int[] dp = new int[MX + 5];
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int root = Integer.parseInt(inputs[1]);
        int cntQ = Integer.parseInt(inputs[2]);

        List<Set<Integer>> adjc = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjc.add(new HashSet<>());
        }

        for (int i = 0; i < n - 1; i++) {
            inputs = br.readLine().split(" ");
            int one = Integer.parseInt(inputs[0]);
            int two = Integer.parseInt(inputs[1]);
            adjc.get(one).add(two);
            adjc.get(two).add(one);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : adjc.get(cur)) {
                adjc.get(next).remove(cur);
                q.add(next);
            }
        }
        
        rec(dp, adjc, root);

        for (int i = 0; i < cntQ; i++) {
            int cur = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[cur] + "\n"));
        }
        bw.flush();
    }

    public static int rec(int[] dp, List<Set<Integer>> adjc, int cur) {
        if (adjc.get(cur).size() == 0) {
            dp[cur] = 1;
            return dp[cur];
        }
        if (dp[cur] != 0) return dp[cur];
        int sum = 1;
        for (Integer next : adjc.get(cur)) {
            sum += rec(dp, adjc, next);
        }
        dp[cur] = sum;
        return dp[cur];
    }
}

/*
 * 가중치도 방향성도 없는 트리가 있다한다. 임의 루트가 있다는데 내가 정하란건가.
 * 
 */