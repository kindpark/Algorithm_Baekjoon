import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		arr[1] = 1;
		arr[0] = 1;
		for(int i = 2; i <=n; i++) {
			//1가지 경우가 늘었으니까
			arr[i] = (arr[i-1] + arr[i-2]*2) % 10007;
		}
		System.out.println(arr[n]);
	}
}