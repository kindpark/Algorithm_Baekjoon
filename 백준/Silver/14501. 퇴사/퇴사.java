import java.util.*;
public class Main {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int date = 0;
		int[] work = new int[n+1];
		int[] earn = new int[n+1];
		dp = new int[n+1];
		boolean[] check = new boolean[n];
		for(int i = 0; i < n; i++) {
			work[i] = sc.nextInt();
			earn[i] = sc.nextInt();
		}
		for(int i = n-1; i >= 0; i--) {
			int date = i + work[i];
			if(date <= n) {
                //일 할때와 안할때의 대소 비교
				dp[i] = Math.max(earn[i] + dp[date], dp[i+1]);
			}
			else {
				dp[i] = dp[i+1];
			}
		}
		System.out.println(dp[0]);
	}
}
