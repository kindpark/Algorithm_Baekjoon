import java.util.*;
import java.io.*;

public class Main {
	static int n, m, u;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] rabirinth;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		m = Integer.parseInt(a[1]);
		rabirinth = new int[n+1][m+1];
		visit = new boolean[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			String p = br.readLine();
			for(int j = 1; j <= m; j++) {
				//지나갈수 없는 것
				if(p.charAt(j-1) == '0') {
					rabirinth[i][j] = -1;
				}
				//반대
				else {
					rabirinth[i][j] = 0;
				}
			}
		}
		bfs(1, 1);
	}
	public static void bfs(int x, int y) {
		Queue<Pt> q = new LinkedList<>();
		q.add(new Pt(x, y));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			Pt p = q.poll();
			
			if(p.x == m && p.y == n) {
				System.out.println(rabirinth[p.y][p.x] + 1);
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				if(px < 1 || py < 1 || px > m || py > n) {
					continue;
				}
				if(visit[py][px] || rabirinth[py][px] == -1) {
					continue;
				}
				visit[py][px] = true;
				rabirinth[py][px] = rabirinth[p.y][p.x] + 1;
				q.add(new Pt(px, py));
			}
		}
	}
}
class Pt{
	int x;
	int y;
	Pt(int x, int y){
		this.x = x;
		this.y = y;
	}
}