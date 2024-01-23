import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 1) {
			System.out.println(1);
		}
		else {
			long[] f = new long[n+1];
			f[0] = 1;
			f[1] = 1;
			for(int i = 2; i <= n; i++) {
				f[i] = (f[i-1] + f[i-2]+ 1)%1000000007;
			}
			System.out.println(f[n]);
		}
	}
}