import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Node> cheese;
	static int n, m, ch=0, res;
	static int[][] place;
	static boolean[][] check;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		place = new int[n][m];
		cheese = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				place[i][j] = Integer.parseInt(st.nextToken());
				if(place[i][j] == 1) {
					cheese.add(new Node(i,j));
					ch++;
				}
			}
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		while(ch != 0) {
			hm.put(res, ch);
			res++;
			check = new boolean[n][m];
			bfs();
			melt();
		}
		
		bw.write(String.valueOf(res)+'\n');
		bw.write(String.valueOf(hm.get(res-1)));
		bw.flush();
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		place[0][0] = 2;
		q.add(new Node(0, 0));
		check[0][0] = true;
		while(!q.isEmpty()) {
			Node nd = q.poll();
			for(int i = 0; i < 4; i++) {
				int cx = nd.x + dx[i];
				int cy = nd.y + dy[i];
				if(cx >= n || cy >= m || cx < 0 || cy < 0) continue;
				if(check[cx][cy] || place[cx][cy] == 1) continue;
				place[cx][cy] = 2;
				q.add(new Node(cx, cy));
				check[cx][cy] = true;
			}
		}
	}
	public static void melt() {
		for(int i = 0; i < cheese.size(); i++) {
			int x = cheese.get(i).x;
			int y = cheese.get(i).y;
			int cnt = 0;
			for(int j = 0; j < 4; j++) {
				int cx = x + dx[j];
				int cy = y + dy[j];
				if(place[cx][cy] == 2) {
					cnt++;
				}
			
			}
			if(cnt>= 1) {
				ch--;
				place[x][y] = 0;
				cheese.remove(i);
				i--;
			}
		}
	}
	public static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}