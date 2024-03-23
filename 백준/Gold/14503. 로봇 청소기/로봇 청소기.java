import java.util.*;
import java.io.*;
public class Main {
	static int n1, m, res=0;
	static int[][] ground;
	static boolean[][] check;
	//0123
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n1 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ground = new int[n1][m];
		check = new boolean[n1][m];
		st = new StringTokenizer(br.readLine());
		int xp = Integer.parseInt(st.nextToken());
		int yp = Integer.parseInt(st.nextToken());
		int direct = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(xp, yp, direct);
		System.out.println(res);
	}
	static int direct(int dir) {
		if(dir == 0) {
			return 3;
		}
		else {
			dir--;
			return dir;
		}
	}
	static class Node{
		int x;
		int y;
		int direct;
		Node(int x, int y, int direct){
			this.x = x;
			this.y = y;
			this.direct = direct;
		}
	}
	public static void bfs(int x, int y, int direct) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, direct));
		
		while(!q.isEmpty()) {
			//네방향 탐색 유무 판별
			boolean spin = false;
			Node n = q.poll();
			if(!check[n.x][n.y]) {
				check[n.x][n.y] = true;
				res++;
			}
			int nd = n.direct;
			for(int i = 0; i < 4; i++) {
				nd = direct(nd);
				int nx = dx[nd] + n.x;
				int ny = dy[nd] + n.y;
				if(nx < 0 || ny < 0 || nx >= n1 || ny >= m) {
					continue;
				}
				if(check[nx][ny]) {
					continue;
				}
				if(ground[nx][ny] == 1) {
					continue;
				}
				q.add(new Node(nx, ny, nd));
				spin = true;
				break;
			}
			if(!spin) {
				int nnd = (n.direct+2) % 4;
				int nx = n.x + dx[nnd];
				int ny = n.y + dy[nnd];
				if(nx < 0 || ny < 0 || nx >= n1 || ny >= m) {
					continue;
				}
				if(ground[nx][ny] != 1) {
					q.add(new Node(nx, ny, n.direct));
					continue;
				}
				else {
					break;
				}
			}
		}
	}
}
