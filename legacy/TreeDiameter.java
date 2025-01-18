import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<ArrayList<Integer>> graph = new ArrayList<>(); // 모든 노드에 간선이 존재하니 2차원 배열의 형태로 구성해도 좋다.
                                                            // 간선이 없는 경우도 있다면 해시맵을 통해서 구성하면 조흘 수 있다.
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n - 1; i++) {
			String[] inputs = br.readLine().split(" ");
			int node1 = Integer.parseInt(inputs[0]);
			int node2 = Integer.parseInt(inputs[1]);
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		int[] start = bfs(graph, 1);
		int ans = bfs(graph, start[0])[1];
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}
	
	// ret format : [idx, val]
	public static int[] bfs(List<ArrayList<Integer>> graph, int st) { // 비공변, 컬렉션 타입은 상속 객체가 아닌 구체적 객체를 명시
		int[] dist = new int[10005];
		
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(st);	
		dist[st] = 1;
		
		int[] ret = { st, dist[st]};
		while (!q.isEmpty()) {
			int cur = q.poll();
			List<Integer> nexts = graph.get(cur);
			for (int next : nexts) {
				if (dist[next] != 0) continue;
				dist[next] = dist[cur] + 1;
				if (dist[next] > ret[1]) {
					ret[0] = next;
					ret[1] = dist[next];
				}
				q.offer(next);
			}
		}
		return ret;
	} 
}
