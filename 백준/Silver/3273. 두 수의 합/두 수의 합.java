import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		int start = 0;
		int end = n-1;
		int cnt = 0;
		Arrays.sort(arr);
		while(true) {
			if(start >= end) {
				break;
			}
			int sum = arr[start] + arr[end];
			if(sum == x) {
				cnt++;
				start++;
				end--;
			}
			else if(sum < x) {
				start++;
			}
			else {
				end--;
			}
		}
		System.out.println(cnt);
	}
}
