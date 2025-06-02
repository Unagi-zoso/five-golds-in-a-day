import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            graph.get(from).add(new int[] {to, cost});
            
        }

        int mx = Integer.MAX_VALUE;
        int[] dijkstra = new int[n+1]; // 비용
        Arrays.fill(dijkstra, mx);
        int[] parent = new int[n+1];

        String[] inputs = br.readLine().split(" ");
        int from = Integer.parseInt(inputs[0]);
        int to = Integer.parseInt(inputs[1]);
        dijkstra[from] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        pq.offer(new int[] {0, from});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int curPos = cur[1];
            if (curPos == to) break;
            for (int[] next : graph.get(curPos)) {
                int nextPos = next[0];
                int nextCost = curCost + next[1];
                if (dijkstra[nextPos] <= nextCost) continue;
                dijkstra[nextPos] = nextCost;
                parent[nextPos] = curPos;
                pq.offer(new int[] {nextCost, nextPos});
            }
        }
        bw.write(String.valueOf(dijkstra[to]) + "\n");
        List<String> logList = new ArrayList<>();
        int logStartPoint = to;
        while (logStartPoint != 0) {
            logList.add(Integer.toString(logStartPoint));
            logStartPoint = parent[logStartPoint];
            
        }
        Collections.reverse(logList);
        String log = String.join(" ", logList);
        bw.write(String.valueOf(logList.size()) + "\n");
        bw.write(String.valueOf(log) + " ");
        bw.flush();
    }
}