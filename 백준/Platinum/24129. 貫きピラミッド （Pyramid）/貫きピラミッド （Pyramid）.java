import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static int w, h, n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		long res = 0;
		map = new int[h+1][w+1];
		//check = new boolean[h][w];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if(map[y][x] < z) {
				map[y][x] = z;
			}
		}
		for(int i = 0; i < h; i++){
            for (int j = 0; j < w; j++) {
                if(i >= 1) {
                    map[i][j] = Math.max(map[i-1][j]-1, map[i][j]);
                }
                if(j >= 1) {
                    map[i][j] = Math.max(map[i][j-1]-1, map[i][j]);
                }
                if(i >= 1 && j >= 1) {
                    map[i][j] = Math.max(map[i-1][j-1]-1, map[i][j]);
                }
            }
        }

        for(int i = h - 1; i >= 0; i--) {
            for(int j = 0; j < w; j++) {
                if(i+1< h) {
                    map[i][j] = Math.max(map[i+1][j]-1, map[i][j]);
                }
                if(j >= 1) {
                    map[i][j] = Math.max(map[i][j-1]-1, map[i][j]);
                }
                if(i+1 < h && j >= 1) {
                    map[i][j] = Math.max(map[i+1][j-1]-1, map[i][j]);
                }
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = w - 1; j >= 0; j--) {
                if(i >= 1) {
                    map[i][j] = Math.max(map[i-1][j]-1, map[i][j]);
                }
                if(j + 1 < w) {
                    map[i][j] = Math.max(map[i][j+1]-1, map[i][j]);
                }
                if(i >= 1 && j + 1 < w) {
                    map[i][j] = Math.max(map[i-1][j+1]-1, map[i][j]);
                }
            }
        }

        for(int i = h - 1; i >= 0; i--) {
            for(int j = w - 1; j >= 0; j--) {
                if(i + 1 < h) {
                    map[i][j] = Math.max(map[i+1][j]-1, map[i][j]);
                }
                if(j + 1 < w) {
                    map[i][j] = Math.max(map[i][j+1]-1, map[i][j]);
                }
                if(i + 1 < h && j + 1 < w) {
                    map[i][j] = Math.max(map[i+1][j+1]-1, map[i][j]);
                }
            }
        }


		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				res += map[i][j];
			}
		}
		System.out.println(res);
	}
	/*
	private static void bfs(int x, int y, int z) {
		map[y][x] = z;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, z));
		while(!q.isEmpty()) {
			Node nd = q.poll();
			int ndx = nd.x;
			int ndy = nd.y;
			for(int i = 0; i < 8; i++) {
				int nx = ndx + dx[i];
				int ny = ndy + dy[i];
				if(nx <= 0 || ny <= 0 || nx > w || ny > h) continue;
				if(check[ny][nx]) continue;
				map[ny][nx] = z;
				check[ny][nx] = true;
			}
		}
		
	}
	static class Node implements Comparable<Object>{
		int x;
		int y;
		int z;
		Node(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	*/
}