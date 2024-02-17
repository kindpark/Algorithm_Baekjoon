import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] dp = new int[1001][1001];
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i = 2; i < 1001; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		for(int i = 2; i < 1001; i++) {
			for(int j = 1; j < i; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}
		System.out.println(dp[n][m]);
	}
}