import java.util.*;
import java.io.*;
public class Main {
	static int[][] connect;
	static int[] path;
	static int[] bacon;
	static boolean[] check;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		connect = new int[n+1][n+1];
		path = new int[n+1];
		bacon = new int[n+1];
		check = new boolean[n+1];
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			connect[a][b] = connect[b][a] = 1;
		}
		for(int i = 1; i <= n; i++) {
			bfs(i);
			for(int j = 1; j <= n; j++) {
				if(i!=j)
					bacon[i] += path[j];
				
			}
			for(int j = 1; j <= n; j++) {
				path[j] = 0;
				check[j] = false;
			}
		}
		int minbc = bacon[1];
		int ans = 1;
		for(int i = 2; i <= n; i++) {
			
			if(minbc > bacon[i]) {
				minbc = bacon[i];
				ans = i;
			}
		}
		System.out.println(ans);
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			for(int i = 1; i<=n; i++) {
				if(connect[a][i] == 1 && !check[i]) {
					check[i] = true;
					q.add(i);
					
					path[i] = path[a]+1;
				}
			}
		}
	}
}
