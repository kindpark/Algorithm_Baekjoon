import java.util.*;
import java.io.*;
public class Main {
	static int[] dm;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		dm = new int[n+1];
		//행렬은 맞물려야 곱셈이 가능하니 i, i+1형태로 진행
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			dm[i] = l;
			dm[i+1] = r;
		}
		dp = new int[n][n];
		System.out.println(dimensionMin(n));
	}
	public static int dimensionMin(int n) {
		for(int i = 2; i < n+1; i++) {
			for(int j = 0; j < n-i+1; j++) {
				dp[j][j+i-1] = Integer.MAX_VALUE;
				for(int k = j; k < j+i-1; k++) {
					//최솟값을 더하면서, 곱셈 연산 최솟값 계산
					//맨 우측은 점화식 결론
					int res = dp[j][k] + dp[k+1][j+i-1] + (dm[j] * dm[k+1] * dm[j+i]);
					//값 대조
					dp[j][j+i-1] = Math.min(dp[j][j+i-1], res);
				}
			}
		}
		return dp[0][n-1];
	}
}