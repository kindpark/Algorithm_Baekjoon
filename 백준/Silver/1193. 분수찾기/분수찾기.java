import java.util.*;
//규칙은 찾았으나, while 부분을 몰랐음.
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = 1;
		while(a > b) {
			a -= b;
			b++;
		}
		if(b % 2 == 1) {
			System.out.println(b+1-a + "/" + a);
		}
		else {
			int c = b+1-a;
			System.out.println(a + "/" + c);
		}
	}
}
