import java.util.*;
import java.io.*;
public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int n, m;
	static int[][] rabirinth;
	static int[][] result;
	static boolean[][] check;
	static Queue<Point> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] b = br.readLine().split(" ");
		n = Integer.parseInt(b[0]);
		m = Integer.parseInt(b[1]);
		//yx
		rabirinth = new int[n+1][m+1];
		result = new int[n+1][m+1];
		check = new boolean[n+1][m+1];
		int sx = 0, sy = 0;
		for(int i = 1; i <= n; i++) {
			b = br.readLine().split(" ");
			for(int j = 1; j <= m; j++) {
				rabirinth[i][j] = Integer.parseInt(b[j-1]);
				if(rabirinth[i][j] == 2) {
					sx = j;
					sy = i;
				}
				else if(rabirinth[i][j] == 1) {
					result[i][j] = -1;
				}
				else{
					result[i][j] = 0;
				}
			}
		}
		bfs(sx, sy);
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void bfs(int x, int y) {
		q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		check[y][x] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int sx = p.x + dx[i];
				int sy = p.y + dy[i];
				int sv = p.c;
                //sx>n으로 적어서 계속 틀려옴;
				if(sx < 1 || sy < 1 || sx > m || sy > n) {
					continue;
				}
				if(rabirinth[sy][sx] == 0) {
					continue;
				}
				if(!check[sy][sx] && result[sy][sx] == -1) {
					check[sy][sx] = true;
					q.add(new Point(sx, sy, sv+1));
					result[sy][sx] = sv+1;
				}
			}
		}
	}
}
class Point{
	int x, y, c;
	Point(int x, int y, int c){
		this.x = x;
		this.y = y;
		this.c = c;
	}
}