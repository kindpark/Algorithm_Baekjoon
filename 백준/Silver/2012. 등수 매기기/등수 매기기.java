import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		long res = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i = 1; i <= n; i++) {
			res += Math.abs(i-arr[i-1]);
		}
		System.out.println(res);
	}
}