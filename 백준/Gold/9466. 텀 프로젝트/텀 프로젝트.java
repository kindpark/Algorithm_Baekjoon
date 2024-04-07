import java.util.*;
import java.io.*;
public class Main{
	static int res = 0, group = 0, visit = 0;
	static int[] select;
	static int[] tour;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			select = new int[n+1];
			check = new boolean[n+1];
			tour = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++) {
				select[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1; i <= n; i++) {
				if(!check[i]) {
					dfs(i);
				}
			}
			sb.append(n-group).append('\n');
			group = 0;
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	public static void dfs(int s) {
		tour[s] = visit++;
		if(tour[select[s]] == 0) {
			dfs(select[s]);
		}
		//사이클이면
		else if(!check[select[s]]){
			group += tour[s] - tour[select[s]] + 1;
		}
		check[s] = true;
	}
}
