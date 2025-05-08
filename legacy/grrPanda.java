import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Integer>> li = new ArrayList<>();
		boolean[][] board = new boolean[105][105];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			board[r][c] = true;
			li.add(new ArrayList<>(Arrays.asList(r, c)));
		}
		
		int ans = 2111111111;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j]) continue;
				int sum = 0;
				for (List<Integer> panda : li) {
					sum += calcDist(panda.get(0), panda.get(1), i, j);
				}
				ans = Math.min(ans, sum);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("" + ans);
		bw.flush();
	}
	
	public static int calcDist(int r1, int c1, int r2, int c2) {
		return (int) Math.pow(r2-r1, 2) + (int) Math.pow(c2-c1, 2);
	}
}
