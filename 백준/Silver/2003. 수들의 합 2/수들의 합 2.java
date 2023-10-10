import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		int r = 0;
		for(int i = 0; i < N; i++) {
			int res = 0;
			for(int j = i; j < N; j++) {
				res+=arr[j];
				if(res== M) {
					r++;
				}
				else if(res > 10) {
					continue;
				}
			}
		}
		System.out.println(r);
	}
}