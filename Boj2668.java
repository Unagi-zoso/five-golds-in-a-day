import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Boj2668 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] path = new int[105];
        boolean[] visited = new boolean[105];
        Set<Integer> ans = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            int to = Integer.parseInt(br.readLine());
            path[i] = to;
        }

        List<TreeSet<Integer>> histories = new ArrayList<>();
        for (int i = 0; i < 105; i++) {
            histories.add(new TreeSet<>());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 105; j++) {
                visited[j] = false;
            }
            if (dfs(n, path, histories, visited, i, i)) {
                ans.addAll(histories.get(i));
            }
        }

        System.out.println(ans.size());
        // toList 는 java16 문법
        // System.out.println(String.join("\n", ans.stream().map(i -> i.toString()).toList()));
        System.out.println(String.join("\n", ans.stream().map(i -> i.toString()).collect(Collectors.toList())));
    }

    public static boolean dfs(int n, int[] path, List<TreeSet<Integer>> histories, boolean[] visited, int cur, int origin) {
        if (visited[cur]) {
            if (cur == origin) {
                return true;
            } else {
                return false;
            }
        } 

        histories.get(origin).add(cur);
        visited[cur] = true;
        int next = path[cur];
        return dfs(n, path, histories, visited, next, origin);
    }
}
