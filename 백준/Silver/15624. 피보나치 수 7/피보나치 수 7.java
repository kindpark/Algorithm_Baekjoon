import java.util.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long[] p = new long[1000002];
		p[0] = 0;
		p[1] = 1;
		p[2] = 1;
		int u = in.nextInt();
		if(u > 2) {
			for(int i = 2; i <= u; i++) {
				p[i] = (p[i-1] + p[i-2]) % 1000000007;
			}
		}
		System.out.println(p[u]);
	}
}