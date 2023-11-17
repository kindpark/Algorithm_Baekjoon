import java.util.*;
import java.io.*;
public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};//우하좌상
	static int n, m;
	static int x, y;
	static int[][] map;
	static boolean[][][][] check;
	static Queue<Game> q;
	static Game blue;
	static Game red;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		check = new boolean[n][m][n][m];
		for(int i = 0; i < n; i++) {
			String u = br.readLine();
			int rx = 0, ry = 0, bx = 0, by = 0;
			for(int j = 0; j < m; j++) {
				if(u.charAt(j) == '#') {
					map[i][j] = -1;
				}
				else if(u.charAt(j) == 'O') {
					map[i][j] = 5;
				}
				else if(u.charAt(j) == 'B') {
					map[i][j] = -2;
					bx = j;
					by = i;
					blue = new Game(bx, by, 0, 0, 0);
				}
				else if(u.charAt(j) == 'R') {
					map[i][j] = 1;
					rx = j;
					ry = i;
					red = new Game(0, 0, rx, ry, 0);
				}
				else {
					map[i][j] = 0;
				}
			}
		}
		System.out.println(bfs());
	}
	public static int bfs() {
		q = new LinkedList<>();
		q.add(new Game(blue.bx, blue.by, red.rx, red.ry, 1));
		check[red.ry][red.rx][blue.by][blue.bx] = true;
		while(!q.isEmpty()) {
			Game g = q.poll();
			if(g.score > 10) {
				return -1;
			}
			for(int i = 0; i < 4; i++) {
				int bpx = g.bx;
				int bpy = g.by;
				int rpx = g.rx;
				int rpy = g.ry;
				//System.out.println(bpx + " " + bpy + " " + rpx +" " + rpy);
				int rGoal = 1;
				int bGoal = 1;
				while(map[rpy + dy[i]][rpx + dx[i]] != -1) {
					rpy += dy[i];
					rpx += dx[i];
					if(map[rpy][rpx] == 5) {
						rGoal = 0;
						break;
					}
				}
				while(map[bpy + dy[i]][bpx + dx[i]] != -1) {
					bpy += dy[i];
					bpx += dx[i];
					if(map[bpy][bpx] == 5) {
						bGoal = 0;
						break;
					}
				}
				if(bGoal == 0) {
					continue;
				}
				if(bGoal == 1 && rGoal == 0) {
					return g.score;
				}
				if(bpx == rpx && bpy == rpy) {
					//우
					if(i == 0)
						if(g.rx < g.bx) rpx -= dx[i];
						else bpx -= dx[i];
					//하
					else if(i == 1)
						if(g.ry < g.by) rpy -= dy[i];
						else bpy -= dy[i];
					//좌
					else if(i == 2)
						if(g.rx > g.bx) rpx -= dx[i];
						else bpx -= dx[i];
					//상
					else if(i == 3)
						if(g.ry > g.by) rpy -= dy[i];	
						else bpy -= dy[i];
					
				}
				
				if(!check[rpy][rpx][bpy][bpx]) {
					check[rpy][rpx][bpy][bpx] = true;
					q.add(new Game(bpx, bpy, rpx, rpy, g.score+1));
				}
			}
		}
		return -1;
	}
}
class Game{
	int bx;
	int by;
	int rx;
	int ry;
	int score;
	Game(int bx, int by, int rx, int ry, int score){
		this.bx = bx;
		this.by = by;
		this.rx = rx;
		this.ry = ry;
		this.score = score;
	}
}
