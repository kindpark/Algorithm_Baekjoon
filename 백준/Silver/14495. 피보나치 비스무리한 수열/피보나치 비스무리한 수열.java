import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[117];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		if(n <= 3) {
			System.out.println(arr[n]);
		}
		else {
			for(int i = 4; i <= n; i++) {
				arr[i] = arr[i-1] + arr[i-3];
			}
			System.out.println(arr[n]);
		}
	}
}
