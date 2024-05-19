import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int i = 1; i <= n; i++) {
			dp[i] = arr[i];
			for(int j = 1; j < i; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}
			}
			max = Math.max(max, dp[i]);
		}
		bw.write(String.valueOf(max));
		bw.flush();
		br.close();
		bw.close();
	}
}
