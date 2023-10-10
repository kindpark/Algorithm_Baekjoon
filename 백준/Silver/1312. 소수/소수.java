import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int N = in.nextInt();
		int k;
		int supply = a % b;
		for(int i = 0; i < N; i ++) {
			supply *=10;
			if(i == N-1) {
				supply = supply / b;
				break;
			}
			supply = supply % b;
		}
		System.out.println(supply);
	}
}