import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[k+1];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			for(int j = 1; j <= k; j++) {
				if(j >= arr[i]) dp[j] = dp[j] + dp[j-arr[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
