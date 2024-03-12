import java.util.*;
import java.io.*;
//dfs
public class Main {
	static int n, m;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//표식 남기기
				dp[i][j] = 5;
			}
		}
		System.out.println(dfs(0, 0));
	}
	public static int dfs(int x, int y) {
		if(x == n-1 && y == m-1) {
			return 1;
		}
		if(dp[x][y] != 5) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		for(int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if(mx < 0 || mx >= n || my < 0 || my >= m) {
				continue;
			}
			if(map[x][y] > map[mx][my]) {
				//다음 칸으로
				dp[x][y] += dfs(mx, my); 
			}
		}
		return dp[x][y];
	}
}