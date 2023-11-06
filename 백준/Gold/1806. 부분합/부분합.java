import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = 0;
		int p = n+1;
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = arr[0];
		while(start <= end && end < n) {
			if(sum < s) {
				sum += arr[++end];
			}
			else {
				p = Math.min(p, end - start+1);
				sum -= arr[start++];
			}
		}
		if(p == n+1) {
			System.out.println(0);
		}
		else {
			System.out.println(p);
		}
	}
}