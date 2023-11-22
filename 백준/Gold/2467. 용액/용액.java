import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int left = 0, right = n-1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int b = Math.abs(arr[left] + arr[right]);
		
		int x = arr[left], y = arr[right];
		Arrays.sort(arr);
		while(left < right) {
			int sort = arr[left] + arr[right];
			if (Math.abs(sort) < b) {
				b = Math.abs(sort);
				x = arr[left];
				y = arr[right];
			}

			if (sort < 0) {
				left++;
			}
			else {
				right--;
			}
		}
		System.out.println(x + " " + y);
	}
}
