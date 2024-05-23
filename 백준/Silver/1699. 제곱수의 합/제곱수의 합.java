import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			dp[i] = i;
		}
		for(int i = 2; i <= n; i++) {
			//제곱수까지 봐야함
			for(int j = 1; j * j<= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		System.out.println(dp[n]);
	}
}