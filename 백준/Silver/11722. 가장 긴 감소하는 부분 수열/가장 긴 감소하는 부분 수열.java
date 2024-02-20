import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int[] arr = new int[a+1];
		int[] dp = new int[a+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= a; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= a; i++) {
			dp[i] = 1;
			for(int j = 1; j < i; j++) {
				if(arr[j] > arr[i] && dp[j] >= dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int mx = 0;
		for(int i = 1; i <= a; i++) {
			if(mx < dp[i]) {
				mx=dp[i];
			}
		}
		System.out.println(mx);
	}
}
