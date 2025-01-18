import java.io.*;
class Main {
	public static int[][] dir = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}};
	public static final int MOD = 1000000000 + 7;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		
		boolean[][] canPass = new boolean[505][505];
		for (int i = 0; i < k; i++) {
			input = br.readLine().split(" ");
			int y = Integer.parseInt(input[0]) - 1;
			int x = Integer.parseInt(input[1]) - 1;
			canPass[y][x] = true;
		}
		
		int[][] dp = new int[505][505];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = -1;
			}
		}
		
		int ans = rec(n - 1, m - 1, n, m, canPass, dp);
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("" + ans);
		bw.flush();
	}
	
	public static int rec(int y, int x, int n, int m, boolean[][] canPass, int[][] dp) {
		if (dp[y][x] != -1) return dp[y][x];
		if (y == 0 && x == 0) {
			dp[y][x] = 1;
			return dp[y][x];
		}
		int ret = 0;
		for (int[] d : dir) {
			int nY = y - d[0];
			int nX = x - d[1];
			
			if (nY < 0 || nY >= n || nX < 0 || nX >= m) continue;
			if (canPass[nY][nX]) continue;
			ret = (ret + rec(nY, nX, n, m, canPass, dp)) % MOD;
		}
		dp[y][x] = ret;
		return dp[y][x];
	}
}
