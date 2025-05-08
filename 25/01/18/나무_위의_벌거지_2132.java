import java.util.*;
import java.io.*;

public class 나무_위의_벌거지_2132 {
    public static List<Integer> lllog = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tree = new int[n];
        String[] inputs = br.readLine().split(" ");
        List<ArrayList<Integer>> path = new ArrayList<>(); // 반공변 한 번 더 체크
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(inputs[i]);
            path.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            inputs = br.readLine().split(" ");
            int n1 = Integer.parseInt(inputs[0]) - 1;
            int n2 = Integer.parseInt(inputs[1]) - 1;
            path.get(n1).add(n2);
            path.get(n2).add(n1);
        }

        // 0 최대 합, 1 최대 노드
        int[] res = {-1, 10005};
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(res, tree, path, visited, 0, tree[0]);
        visited[0] = false;
        
        int start = res[1];
        res[0] = -1;
        res[1] = 10005;
        visited[start] = true;
        dfs(res, tree, path, visited, start, tree[start]);
        visited[start] = false;

        int last = res[1];
        int max = res[0];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("" + max + " " + (Math.min(start, last) + 1));
        bw.flush();
    }
    
    public static void dfs(int[] res, int[] tree, List<ArrayList<Integer>> path, boolean[] visited, int cur, int curSum) {
        if (res[0] < curSum || res[0] == curSum && cur < res[1]) {
            res[0] = curSum;
            res[1] = cur;
        }
        for (int next : path.get(cur)) {
            if (visited[next]) continue;
            visited[next] = true;
            dfs(res, tree, path, visited, next, curSum + tree[next]);
            visited[next] = false;
        }
    }
}

