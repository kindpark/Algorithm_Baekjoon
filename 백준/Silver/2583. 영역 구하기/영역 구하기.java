import java.io.*;
import java.util.*;
public class Main {
	static int n, m, k, count;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] area;
	static boolean[][] check;
	static ArrayList<Integer> seperate;
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		area = new int[n][m];
		seperate = new ArrayList<>();
		check = new boolean[n][m];
		int x1, x2, y1, y2;
		for(int u = 0; u < k; u++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					area[j][i] = 1;	
				}
			}
		}
		int pp = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(area[i][j] == 0 && !check[i][j]) {
					count=0;
					bfs(i,j);
					seperate.add(count);
					pp++;
				}
			}
		}
		Collections.sort(seperate);
		bw.write(String.valueOf(seperate.size()) + "\n");
		for(int i : seperate) {
			bw.write(String.valueOf(i)+" ");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		count++;
		area[x][y] = 1;
		check[x][y] = true;
		while(!q.isEmpty()) {
			Node nd = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = nd.x + dx[i];
				int ny = nd.y + dy[i];
				if(nx >= n || ny >= m || nx < 0 || ny < 0 || area[nx][ny] == 1 || check[nx][ny]) continue;
				q.add(new Node(nx, ny));
				count++;
				check[nx][ny] = true;
			}
		}	
	}
}
