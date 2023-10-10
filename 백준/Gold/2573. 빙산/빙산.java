import java.util.*;
import java.io.*;
public class Main {
	static int[][] ice;
	static int n, m;
	static Queue<Spot> q;
	static int[] dx = {0, 1, 0, -1}; //동 남 서 북
	static int[] dy = {1, 0, -1, 0};
	/* == {(0,1), (1,0}, (0,-1), (-1,0)};
	 * 좌표계에서 열에서 1 증가하면 동쪽으로 이동
	 * 행이 증가하면 남쪽 이동,
	 * 행이 감소하면 북으로 이동
	 * 열이 감소하면 서쪽으로 이동
	 * 본래 알고있던 2차원 좌표와 다르게 이해할것
	 * 순서는 어떻게 되든 상관없음. 
	*/ 
	static boolean[][] check;
	public static int bfs(int x, int y) {
		int cnt = 0;
		check[y][x] = true;
		q.add(new Spot(x, y));
		while(!q.isEmpty()) {
			Spot s = q.poll();
			cnt++;
			//4방향
			for(int i = 0; i < 4; i++) {
				int xpos = s.x + dx[i];
				int ypos = s.y + dy[i];
				if(xpos < 1 || ypos < 1 || xpos > m || ypos > n || check[ypos][xpos]) {
					continue;
				}
				if(ice[ypos][xpos] != 0) {
					
					check[ypos][xpos] = true;
					q.add(new Spot(xpos, ypos));
				}
				
			}
		}
		return cnt;
	}
	
	public static int meltIce() {
		int cnt = 0;
		boolean[][] c = new boolean[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(ice[i][j] != 0) {
					c[i][j] = true;
					for(int k = 0; k < 4; k++) {
						int xpos = j + dx[k];
						int ypos = i + dy[k];
				
						if(xpos < 1 || ypos < 1 || xpos > m || ypos > n | c[ypos][xpos]) {
							continue;
						}
						if(ice[ypos][xpos] == 0 && ice[i][j] > 0) {
							ice[i][j]--;
						}
					}
					if(ice[i][j] > 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	public static int moveAround() {
		int cnt = 0;
		check = new boolean[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(ice[i][j] != 0 && !check[i][j]) {
					bfs(j, i);
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ice = new int[n+1][m+1];
		check = new boolean[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q = new LinkedList<>();
		int ans = 0;
		int num = -1;
		int breakIsland = 0;
		while(true) {
			//녹은 경우
			if(num == 0) {
				System.out.println(0);
				break;
			}
			else {
				//녹지 않고 섬이 갈라진 경우
				breakIsland = moveAround();
				if(breakIsland >= 2) {
					System.out.println(ans);
					break;
				}
			}
			num = meltIce();
			ans++;
			breakIsland = 0;
		}
	}
}
class Spot{
	int x;
	int y;
	Spot(int x, int y){
		this.x = x;
		this.y = y;
	}
}