import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int arr[][] = new int[501][501];
		for(int i = 1; i <= T; i++) {
			for(int j = 1; j <= i; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		int dp[][] = new int[501][501];
		dp[1][1] = arr[1][1];
		
		for(int i = 2; i <=T; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		int max = 0;
		for(int i = 1; i <= T; i++) {
			max = Math.max(dp[T][i], max);
		}
		System.out.println(max);
	}
}
