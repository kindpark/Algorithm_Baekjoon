import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = 1;
		long plus = 0;
		int start = in.nextInt();
		int last = in.nextInt();
		int[] arr = new int[1000];
		for(int j =0; j < 1000; j++) {
			arr[j] = k;
			if(k*(k+1)/2 <= j+1) {
				k++;
			}
		}
		for(int i = start-1; i < last; i++) {
			plus += arr[i];
		}
		System.out.println(plus);
	}
}