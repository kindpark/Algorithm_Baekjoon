import java.util.*;
import java.io.*;
public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		dp = new int[n+1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());		
		}
		int maxint = 0;
		for(int i = 1; i <= n; i++) {
			int num = a[i];
			if(dp[maxint] < num) {
                maxint++;
				dp[maxint] = num;
			}
			else {
				int b = binarySearch(0, maxint, a[i]);
				dp[b] = a[i];
			}
		}
		bw.write(String.valueOf(maxint));
		bw.flush();
		br.close();
		bw.close();
	}
	public static int binarySearch(int low, int high, int target) {
		while(low < high) {
			int mid = (low+high)/2;
			if(dp[mid] >= target) {
				high = mid;
			}
			else {
				low = mid+1;
			}
		}
		return high;
	}
}
