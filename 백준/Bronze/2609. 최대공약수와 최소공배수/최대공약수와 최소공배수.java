import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int ans1 = 0;
		long ans2;
		for(int i = 1; i <= 10000; i++) {
			if(a % i == 0 && b % i == 0) {
				ans1 = i;
				if(a < i || b < i) {
					break;
				}
			}
		}
		ans2 = a * b / ans1;
		System.out.println(ans1);
		System.out.println(ans2);
	}
}
