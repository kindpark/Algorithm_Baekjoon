import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] city = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) city[i][j] = 0;
				else city[i][j] = Integer.MAX_VALUE;
			}
		}
		StringTokenizer st;
		int a = 0, b = 0, cost = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			city[a][b] = Math.min(cost, city[a][b]);
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j || city[j][i] == Integer.MAX_VALUE) continue;
				for(int k = 1; k <= n; k++) {
					if(k == j || k == i || city[i][k] == Integer.MAX_VALUE) continue; 
					city[j][k] = Math.min(city[j][k], city[j][i] + city[i][k]);
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(city[i][j] == Integer.MAX_VALUE) sb.append(0).append(' ');
				else sb.append(city[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}