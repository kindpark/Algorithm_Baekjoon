import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static int res;
	static int[][] center;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		center = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				center[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);

		System.out.println(res);
	}
	public static void dfs(int depth) {
		if(depth == 3) {
			bfs();
			return;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(center[i][j] == 0) {
					center[i][j] = 1;
					dfs(depth+1);
					center[i][j] = 0;
				}
				
			}
		}
	}
	public static void bfs() {
		int a = 0;
		Queue<Point> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(center[i][j] == 2) {
					q.add(new Point(i, j));
				}
			}
		}
		map = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			map[i] = center[i].clone();
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				if(px < 1 || py < 1 || px > m || py > n) {
					continue;
				}
				if(map[py][px] == 0) {
					map[py][px] = 2;
					q.add(new Point(py, px));
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 0) {
					a++;
				}
			}
		}
		if(a > res) {
			res = a;
		}
	}
	
	public static class Point{
		int y;
		int x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}