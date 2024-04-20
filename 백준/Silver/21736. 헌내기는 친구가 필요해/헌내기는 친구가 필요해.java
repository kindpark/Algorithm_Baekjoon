import java.util.*;
import java.io.*;
public class Main {
	static int n, m;
	static char[][] campus;
	static boolean[][] check;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		campus = new char[n][m];
		check = new boolean[n][m];
		int sx = 0, sy = 0;
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				campus[i][j] = s.charAt(j);
				if(campus[i][j] == 'I') {
					sx = i;
					sy = j;
				}
			}
		}
		System.out.println(bfs(sx, sy));
		bw.flush();
		br.close();
		bw.close();
	}
	public static String bfs(int x, int y) {
		int p = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		check[x][y] = true;
		while(!q.isEmpty()) {
			Node nd = q.poll();
			if(campus[nd.x][nd.y] == 'P') {
				p++;
			}
			for(int i = 0; i < 4; i++) {
				int nx = nd.x + dx[i];
				int ny = nd.y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m || campus[nx][ny] == 'X' || check[nx][ny]) {
					continue;
				}
				q.add(new Node(nx, ny));
				check[nx][ny] = true;
			}
		}
		if(p != 0) return String.valueOf(p);
		else return "TT";
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
