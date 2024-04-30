import java.util.*;
import java.io.*;
public class Main {
	static int n, m, ccnt;
	static int[][] place;
	static boolean[][] check;
	static ArrayList<Node> cheese;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int res = 0;
		place = new int[n][m];
		cheese = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
				if(place[i][j] == 1) {
					//나중에 치즈만 방문하는 bfs 제조
					cheese.add(new Node(i,j));
					ccnt++;
				}
			}
		}
		while(ccnt!= 0) {
			res++;
			check = new boolean[n][m];
			bfs();
			melt();
		}
		System.out.println(res);
		br.close();
	}
	public static void melt() {
		for(int i = 0; i < cheese.size(); i++) {
			int cnt = 0;
			int x = cheese.get(i).x;
			int y = cheese.get(i).y;
		
			for(int j = 0; j < 4; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				if(place[cx][cy] == 2) {
					cnt++;
				}
 			}
			if(cnt >= 2) {
				place[x][y] = 0;
				ccnt--;
				cheese.remove(i);
				i--;
			}
		}
	}
	public static void bfs() {
		check[0][0] = true;
		place[0][0] = 2;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		while(!q.isEmpty()) {
			Node nd = q.poll();
			for(int i = 0; i < 4; i++) {
				int fx = dx[i] + nd.x;
				int fy = dy[i] + nd.y;
				if(fx >= n || fy >= m || fx < 0 || fy < 0) continue;
				if(check[fx][fy] || place[fx][fy] == 1) continue;
				//외부
				place[fx][fy] = 2;
				q.add(new Node(fx, fy));
				check[fx][fy] = true;
			}
		}
	}
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
