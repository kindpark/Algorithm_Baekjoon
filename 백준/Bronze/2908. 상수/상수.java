import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int a = flip(A);
		int b = flip(B);
		if(a < b) {
			System.out.println(b);
		}else {
			System.out.println(a);
		}
	}
	public static int flip(int num) {
		int result = 0;
		
		for(int i = 0; i < 3; i++) {
			result = result * 10 + num%10;
			num /= 10;
		}
		return result;
	}
}
