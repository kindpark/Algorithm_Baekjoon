import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int res = 0;
		int[] a = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = i; j<=n; j++) {
				sum += a[j];
				if(sum == m) {
					res++;
				}
				else if(sum > 10){
					continue;
				}
			}
		}
		System.out.println(res);
	}
}