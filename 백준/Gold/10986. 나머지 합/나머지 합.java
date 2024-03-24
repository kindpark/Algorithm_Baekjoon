import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] arr = new long[n+1];
		long[] sum = new long[n+1];
		long[] c = new long[m];
		long res = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = arr[i] + sum[i-1];
			sum[i]%=m;
			if(sum[i] == 0) {
				res++;
			}
			c[(int)sum[i]%m]++;
		}
		// c[0] = 3
		//c[1] = 2
		//c[2] = 0
		for(int i = 0; i < m; i++) {
			res += c[i]*(c[i]-1)/2;
		}
		System.out.println(res);
	}
}