import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		BigInteger n1 = BigInteger.ONE;
		BigInteger m1 = BigInteger.ONE;
		for(int i = 0; i < M; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(N-i)));
			m1 = m1.multiply(new BigInteger(String.valueOf(i+1)));
		}
		System.out.println(n1.divide(m1));
	}
}
