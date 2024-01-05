import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int mx = 0, idx = 0, mx2 = 0;
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		int[] res = new int[n+1];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = 1;
		if(n == 1) {
			System.out.println(1);
			System.out.println(arr[0]);
		}
		else {
			for(int i = 1; i < n; i++) {
				int max = 0;
				for(int j = i-1; j >= 0; j--) {
					if(arr[j] < arr[i] && dp[j] >= max) {
						max = Math.max(max,  dp[j]);
					}
				}
				//큰값을 더해서 값이 같은게 나오지 않게
				dp[i] = max+1;
				if(mx < max +1) {
					mx = dp[i];
					idx = i; 
				}
			}
			for(int i = idx; i >=0; i--) {
				if(mx == dp[i]) {
					res[mx2++] = arr[i];
					mx--;
				}
			}
			for(int i = mx2-1; i >= 0; i--) {
				sb.append(res[i] + " ");
			}
			System.out.println(mx2);
			System.out.println(sb.toString());
		}
		
	}
}