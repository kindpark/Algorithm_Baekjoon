import java.util.*;
public class Main{
	static int[] arr, brr;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int res = 0;
		arr = new int[n+1];
		brr = new int[n+1];
		for(int i = 0; i < n; i++) {
			brr[i] = sc.nextInt();
			arr[i] = brr[i];
		}
		Arrays.sort(arr, 0, n);
		for(int i = 0; i < n; i++) {
			if(arr[i] == brr[i]) {
				continue;
			}
			for(int j = i; j < n; j++) {
				if(arr[i] == brr[j] && arr[j]!= brr[j]) {
					int temp = brr[i];
					brr[i] = brr[j];
					brr[j] = temp;
					res++;
				}
			}
		}
		System.out.println(res);
	}
}