import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		int[] sum = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + arr[i]; 
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int r = sum[b] - sum[a-1];
			System.out.println(r);
		}
	}
}