import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int big = 0;
		int small = 1000000;
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		big = arr[0];
		for(int i = 0; i < N; i++) {
			if(big < arr[i]) {
				big = arr[i];
			}
		}
		for(int i = 0; i < N; i++) {
			if(small > arr[i]) {
				small = arr[i];
			}
		}
		System.out.println(big * small);
	}
}