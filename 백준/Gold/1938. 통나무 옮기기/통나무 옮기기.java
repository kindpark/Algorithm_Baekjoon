import java.io.*;
import java.util.*;

public class Main {
	static char[][] ground;
	static boolean[][][] check;
	static int n, res;
	static int[] dx = {0, 0, -1, 1, 0};
	static int[] dy = {-1, 1, 0, 0, 0};
	//static int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
	//static int[] dy = {1, -1, 0, 1, -1, 0, -1, 1};
	static char[] mv = {'u', 'd', 'l', 'r', 't'};
	static Node start, finish;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		String s;
		ground = new char[n][n];
		check = new boolean[n][n][2];
		start = new Node(-1,-1,-1,0);
		finish = new Node(-1,-1,-1,0);
		int scnt = 1;
		int ecnt = 1;
		for(int i = 0; i < n; i++) {
			s = br.readLine();
			for(int j = 0; j < n; j++) {
				ground[i][j] = s.charAt(j);
				if(ground[i][j] == 'B') {
					if(scnt==1) {
						start.x = j;
						start.y = i;
						scnt++;
					}
					else if(scnt == 2) {
						if(start.x == j) start.dir = 0;
						else start.dir = 1;
						start.x = j;
						start.y = i;
						scnt++;
					}
				}
				if(ground[i][j] == 'E') {
					if(ecnt==1) {
						finish.x = j;
						finish.y = i;
						ecnt++;
					}
					else if(ecnt == 2) {
						if(finish.x == j) finish.dir = 0;
						else finish.dir = 1;
						finish.x = j;
						finish.y = i;
						ecnt++;
					}
				}
			}
		}
		bfs();
		br.close();
		bw.close();
	}
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start.x, start.y, start.dir, 0));
		check[start.y][start.x][start.dir] = true;
		while(!q.isEmpty()) {
			Node nd = q.poll();
			int cnt = nd.count;
			if(nd.x == finish.x && nd.y == finish.y && nd.dir == finish.dir) {
				System.out.println(cnt);
				return;
			}
			for(int i = 0; i < 5; i++) {
				int nx = dx[i] + nd.x;
				int ny = dy[i] + nd.y;
				if(nx < n && ny < n && nx >= 0 && ny >= 0) {
					if(i == 0){
						if((nd.dir == 0 && ny > 0 && ground[ny-1][nx] != '1') ||
						(nd.dir == 1 && ground[ny][nx-1] != '1' &&
						ground[ny][nx] != '1' && ground[ny][nx+1] != '1')) {
						
							if(!check[ny][nx][nd.dir]) {
								check[ny][nx][nd.dir] = true;
								q.add(new Node(nx, ny, nd.dir, cnt+1));
							}
						}
					}
					//d
					if(i == 1) {
						if((nd.dir == 0 && ny < n-1 && ground[ny+1][nx] != '1') ||
								(nd.dir == 1 && ground[ny][nx-1] != '1' && ground[ny][nx] != '1' && ground[ny][nx+1] != '1')) {
							if(!check[ny][nx][nd.dir]) {
								check[ny][nx][nd.dir] = true;
								q.add(new Node(nx, ny, nd.dir, cnt+1));
							}
						}

					}
					//l
					if(i == 2) {
						if((nd.dir == 0 && ground[ny-1][nx] != '1' && ground[ny][nx] != '1' && ground[ny+1][nx] != '1') ||
								(nd.dir == 1 && nx - 1 >= 0 && ground[ny][nx-1] != '1')) {
								
							if(!check[ny][nx][nd.dir]) {
								check[ny][nx][nd.dir] = true;
								q.add(new Node(nx, ny, nd.dir, cnt+1));
							}
						}
					}
					//r
					if(i == 3) {
						if((nd.dir == 0 && ground[ny-1][nx] != '1' && ground[ny][nx] != '1' && ground[ny+1][nx] != '1') ||
								(nd.dir == 1 && nx + 1 < n && ground[ny][nx+1] != '1')) {
								
							if(!check[ny][nx][nd.dir]) {
								check[ny][nx][nd.dir] = true;
								q.add(new Node(nx, ny, nd.dir, cnt+1));
							}
						}
					}
					//t
					if(i == 4) {
						if (nd.x != 0 && nd.x != n - 1 && nd.y != 0 && nd.y != n - 1) {
							if (nd.dir == 0) { // 수직
								if (nd.dir == 0 && ground[nd.y][nd.x - 1] != '1' && ground[nd.y - 1][nd.x - 1] != '1' && ground[nd.y + 1][nd.x - 1] != '1'
										&& ground[nd.y][nd.x + 1] != '1' && ground[nd.y - 1][nd.x + 1]  != '1'
										&& ground[nd.y + 1][nd.x + 1] != '1') {
									nd.dir = 1;
									if(!check[ny][nx][nd.dir]) {
										check[ny][nx][nd.dir] = true;
										q.add(new Node(nx, ny, nd.dir, cnt+1));
									}
								} else {
									break;
								}
							} else { // 수평
								if (ground[nd.y - 1][nd.x - 1] != '1' && ground[nd.y - 1][nd.x] != '1' && ground[nd.y - 1][nd.x + 1] != '1'
										&& ground[nd.y + 1][nd.x - 1] != '1' && ground[nd.y + 1][nd.x] != '1'
										&& ground[nd.y + 1][nd.x + 1] != '1') {
									nd.dir = 0;
									if(!check[ny][nx][nd.dir]) {
										check[ny][nx][nd.dir] = true;
										q.add(new Node(nx, ny, nd.dir, cnt+1));
									}
								} else {
									break;
								}
							}
						}
						break;
					}
				}
				
			}
		}
		System.out.println(0);
		return;
	}
	static class Node{
		int x;
		int y;
		int dir;
		int count;
		Node(int x, int y, int dir, int count){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
	}
}
