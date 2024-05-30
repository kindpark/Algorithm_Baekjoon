import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 0;
	static int[] connect;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		connect = new int[m+1];
		check = new boolean[m+1];
 		while(n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(connect[b]==0) {
				connect[b] = a;
			}
		}
 		dfs(p);
 		bw.write(String.valueOf(cnt));
 		bw.flush();
 		bw.close();
 		br.close();
	}
	public static void dfs(int v) {
		if(check[v]) {
			cnt=-1;
		}
		else if(connect[v] != 0) {
			check[v] = true;
			cnt++;
			dfs(connect[v]);
		}
	}
}