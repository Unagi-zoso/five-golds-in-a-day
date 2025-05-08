import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Boj2660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println("1 1\n1"); // 아마 없을듯.
        }

        boolean[][] graph = new boolean[55][55];
        
        while (true) {
            String[] input = br.readLine().split(" ");
            int lhs = Integer.parseInt(input[0]);
            int rhs = Integer.parseInt(input[1]);
            if (lhs == -1) break;
            graph[lhs][rhs] = true;
            graph[rhs][lhs] = true;
        }
        
        int[] eachMaxV = new int[n + 1];
        eachMaxV[0] = 100;

        int[] dist = new int[55];
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 55; j++) {
                dist[j] = -1;
            }

            q.add(i);
            dist[i] = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int k = 1; k <= n; k++) {
                    if (!graph[cur][k]) continue;
                    if (dist[k] != -1) continue;
                    dist[k] = dist[cur] + 1;
                    q.add(k);
                }
            }

            eachMaxV[i] = Arrays.stream(dist).max().orElseThrow();
        }

        int ansMinV = Arrays.stream(eachMaxV).min().orElseThrow();

        List<String> ansElem = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (eachMaxV[i] == ansMinV) ansElem.add("" + i);
        }

        System.out.println("" + ansMinV + " " + ansElem.size());
        System.out.println(String.join(" ", ansElem));
    }
}

/*
 * 각 노드별 가장 멀리 떨어진 정점 길이 구하기
 */