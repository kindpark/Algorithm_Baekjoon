import java.util.*;

public class Main {
	static int max = 200000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[(int) max];
		for(int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			arr[a] += a;
		}
		for(int i = 1; i <max; i++) {
			arr[i] += arr[i-1];
		}
		for(int i = 1; i < max; i++) {
			int l = arr[i];
			int r = arr[max-1] - arr[i-1];
			if(l == r) {
				System.out.println(i);
				break;
			}
		}
	}
}