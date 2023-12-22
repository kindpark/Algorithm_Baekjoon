import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int res = 0;
		LinkedList<Integer> pw = new LinkedList<>();
		//수학 문제?
		//a+b = x, b = x-a
		//a시그마 * x-a시그마, 시(kx-시)
		boolean[][][] dp = new boolean[81][81][16001];
		int[] w= new int[n+1];
		int[] v = new int[n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			pw.add(w[i]);
			dp[i][0][0] = true;
		}
		dp[0][1][pw.get(0)] = true;
		for(int i = 1; i < n; i++) {
			dp[i][1][pw.get(i)] = true;
			for(int j = 1; j <= i+1; j++) {
				for(int l = 0; l <= x * k; l++) {
					if(l - pw.get(i) >= 0 && j >0) {
						dp[i][j][l] |= dp[i-1][j-1][l-pw.get(i)];
					}
					dp[i][j][l] |= dp[i-1][j][l];
				}
			}
		}
		for(int i = 0; i <= x*k; i++) {
			if(dp[n-1][k][i]) {
				res = Math.max(res, i*(k*x-i));
			}
		}
		System.out.println(res);
	}
}
