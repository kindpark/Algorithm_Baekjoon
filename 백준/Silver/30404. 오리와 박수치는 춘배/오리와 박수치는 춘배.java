import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[n];
		int[] duck = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i <n; i++) {
			duck[i] = Integer.parseInt(st.nextToken());
			dp[i] = -1;
		}
		dp[0] = duck[0] + k;
		int clap = 1;
		for(int i = 1; i < n; i++) {
			if(duck[i] > dp[i-1]) {
				dp[i] = duck[i] + k;
				clap++;
			}
			else {
				dp[i] = dp[i-1];
			}
		}
		System.out.println(clap);
	}
}