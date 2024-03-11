import java.io.*;
import java.util.*;
public class Main {
	static int[][] li;
	static boolean[] check;
	static StringBuilder sb;
	static Queue<Integer> q;
	static int n, m, v;
	public static void bfs(int v) {
		q.add(v);
		check[v] = true;
		while(!q.isEmpty()) {
			v = q.poll();
			sb.append(v + " ");
			for(int i = 1; i <= n; i++) {
				if(!check[i] && li[v][i] == 1) {
					q.add(i);
					check[i] = true;		
				}
			}
		}
	}
	public static void dfs(int v) {
		check[v] = true;
		sb.append(v + " ");
		for(int i = 1; i <= n; i++) {
			if(!check[i] && li[v][i] == 1) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		li = new int[n+1][n+1];
		check = new boolean[n+1];
		q = new LinkedList<>();
		for(int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			
			li[x][y] = 1;
			li[y][x] = 1;
		}
		dfs(v);
		System.out.println(sb);
		sb = new StringBuilder();
		check = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
}