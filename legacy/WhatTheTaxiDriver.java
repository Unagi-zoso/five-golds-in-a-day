import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int defaultCost = Integer.parseInt(st.nextToken()); // 5까지는 이 요금을 받음
		int extraCost = Integer.parseInt(st.nextToken()); // 5를 넘으면 추가거리 x 이 요금을 받음
		int trafficFee = Integer.parseInt(st.nextToken()); // 움직일때마다 통행료를 기사가 낸다
		
		int[][] board = new int[105][105];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] customers = new int[105][4];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			customers[i][1] = Integer.parseInt(st.nextToken()) - 1;
			customers[i][0] = Integer.parseInt(st.nextToken()) - 1;
			customers[i][3] = Integer.parseInt(st.nextToken()) - 1;
			customers[i][2] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		int[][] dir = {{ 0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		
		int earnedMoney = 0;
		int trafficCost = 0;
		for (int i = 0; i < m; i++) {
			int[] customerSt = { customers[i][0], customers[i][1] };
			int[] customerDst = { customers[i][2], customers[i][3] };
			
			int[][] visited = new int[105][105];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					visited[j][k] = -1;
				}
			}
		
			LinkedList<List<Integer>> q = new LinkedList<>();
			if (i == 0) {
				q.add(List.of(customerSt[0], customerSt[1]));	
				visited[customerSt[0]][customerSt[1]] = 0;
			} else {
				q.add(List.of(customers[i - 1][2], customers[i - 1][3]));	
				visited[customers[i - 1][2]][customers[i - 1][3]] = 0;
			}
			
			boolean arrived = false;
			while (!q.isEmpty()) {
				if (i == 0) break;
				List<Integer> cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nY = cur.get(0) + dir[d][0];
					int nX = cur.get(1) + dir[d][1];
					if (nY < 0 || nY >= n || nX < 0 || nX >= n) continue;
					if (visited[nY][nX] != -1 || board[nY][nX] == 1) continue;
					if (nY == customerSt[0] && nX == customerSt[1]) {
						arrived = true;
						int dist = visited[cur.get(0)][cur.get(1)] + 1;
						trafficCost += trafficFee * dist;
						break;
					}
					q.add(List.of(nY, nX));
					visited[nY][nX] = visited[cur.get(0)][cur.get(1)] + 1;
				}
				if (arrived) break;
			}
			
			visited = new int[105][105];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					visited[j][k] = -1;
				}
			}
			
			q = new LinkedList<>();
			q.add(List.of(customerSt[0], customerSt[1]));	
			visited[customerSt[0]][customerSt[1]] = 0;
			
			arrived = false;
			while (!q.isEmpty()) {
				List<Integer> cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nY = cur.get(0) + dir[d][0];
					int nX = cur.get(1) + dir[d][1];
					if (nY < 0 || nY >= n || nX < 0 || nX >= n) continue;
					if (visited[nY][nX] != -1 || board[nY][nX] == 1) continue;
					if (nY == customerDst[0] && nX == customerDst[1]) {
						arrived = true;
						int dist = visited[cur.get(0)][cur.get(1)] + 1;
						earnedMoney +=  defaultCost;
						if (dist > 5) {
							earnedMoney += (dist - 5) * extraCost;
						}
						trafficCost += trafficFee * dist;			
						break;
					}
					q.add(List.of(nY, nX));
					visited[nY][nX] = visited[cur.get(0)][cur.get(1)] + 1;
				}
				if (arrived) break;
			}
		}	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("" + (earnedMoney - trafficCost));
		bw.flush();
	}
}
