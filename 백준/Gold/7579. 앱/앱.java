import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] me = new int[n+1];
		int[] c = new int[n+1];
		int[][] dp = new int[n+1][10001];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			me[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < 10001; j++) {
				//비용의 합이 클 경우 갱신
				if(j >= c[i]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-c[i]] + me[i]);
				//꼭 반례가 아님
				
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				
			}
		}


		for(int i = 0; i < 10001; i++) {
			if(dp[n][i] >= m) {
				System.out.println(i);
				break;
			}
		}
	}
}