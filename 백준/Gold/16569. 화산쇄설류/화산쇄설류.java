//다시 풀기
import java.util.*;
import java.io.*;
public class Main {
	static int m, n, v, peak, res, t;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] island;
	static int[][] explosion;
	static boolean[][] check;
	static Vol[][] vol;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		island = new int[n+1][m+1];
		explosion = new int[n+1][m+1];
		check = new boolean[n+1][m+1];
		vol = new Vol[n+1][m+1];
		for(int i = 1; i <= n; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				int height = Integer.parseInt(st.nextToken());
				vol[i][j] = new Vol(height, Integer.MAX_VALUE);
			}
		}
		for(int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int xi = Integer.parseInt(st.nextToken());
			int yi = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			for(int j = 1; j<= n; j++) {
				for(int k = 1; k <= m; k++) {
					if(xi == j && yi == k) {
						vol[j][k].time = 0;
					}
					else {
						int bomb = Math.abs(xi-j) + Math.abs(yi-k);
						vol[j][k].time = Math.min(vol[j][k].time, t+bomb);
					}
				}
			}
		}
		bfs(x, y, m, n, vol);
		System.out.println(peak + " " + res);		
	}
	//화산의 크기가 커야됨
	//폭발시간 >= abs(|위치-화산위치| + |좌동|)
	static class Node{
		int x;
		int y;

		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	//화산 길이 및 폭발 시간
	static class Vol{
		int height;
		int time;
		public Vol(int height, int time) {
			this.height = height;
			this.time = time;
		}
	}
	//화산 폭발
	public static void bfs(int x, int y, int m, int n, Vol[][] vol) {
		int time = 1;
        peak = vol[x][y].height;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		check[x][y] = true; 
		while(!q.isEmpty()) {
			Queue<Node> q2 = new LinkedList<>(q);
			q.clear();
			while(!q2.isEmpty()) {
				Node nd = q2.poll();
				for(int i = 0; i < 4; i++) {
					int nx = nd.x + dx[i];
					int ny = nd.y + dy[i];
					if(nx <= 0 || ny <= 0 || nx > m || ny > n) {
						continue;
					}
					if(check[nx][ny]) {
						continue;
					}
					if(vol[nx][ny].time > time) {
						if(peak < vol[nx][ny].height) {
							peak = vol[nx][ny].height;
							res = time;
						}
					
						q.add(new Node(nx, ny));
						check[nx][ny] = true;
					}
				}
			}
			time++;
		}
	}
}