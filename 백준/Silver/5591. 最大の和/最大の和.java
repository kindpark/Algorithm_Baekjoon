import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int result = Integer.MIN_VALUE;
		for(int i = 0; i < n-k+1; i++) {
			int sum = 0;
			for(int j = i; j < i+k; j++) {
				sum += arr[j];
			}
			if(result < sum) {
				result = sum;
			}
		}
		System.out.println(result);
	}
}