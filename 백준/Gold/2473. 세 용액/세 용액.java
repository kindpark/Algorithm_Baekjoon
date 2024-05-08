import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		long[] arr = new long[n];
		long[] ans = new long[3];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		long res = 3000000001L;
		for(int i = 0; i < n - 2; i++) {
			int a = i + 1;
			int r = n - 1;
			while(a < r) {
				long val = arr[i] + arr[a] + arr[r];
				if(Math.abs(val) < res) {
					res = Math.abs(val);
					ans[0] = arr[i];
					ans[1] = arr[a];
					ans[2] = arr[r];
				}
				if(val < 0) a++;
				else r--;
			}
		}
		for(int i = 0; i < 3; i++) {
			sb.append(String.valueOf(ans[i]) + " ");
		}
		System.out.println(sb.toString());
	}
}
