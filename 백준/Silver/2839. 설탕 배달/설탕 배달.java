import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] dp = new int[5001];
		int n = in.nextInt();
		int ans = 0;
		while (n>=0) {
			if (n % 5 == 0) {	
				ans += (n / 5);	
				System.out.println(ans);
				return;
			}
			
				n -= 3;	//3kg을 빼고 
				ans++;
		
		}
		ans = -1;
		System.out.println(ans);
	}
}