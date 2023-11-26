import java.math.BigInteger;
import java.util.*;
public class Main {
	static StringBuilder sb;
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger b = new BigInteger("2");
		System.out.println(b.pow(n).subtract(new BigInteger("1")));
		if(n <= 20) {
			hanoi(n, 1, 2, 3);
		}
		System.out.println(sb.toString());
	}
	private static void hanoi(int num, int from, int by, int to) {
		if(num == 1) {
			sb.append(from + " " + to).append('\n');
		}
		else {
			hanoi(num-1, from, to, by);
			sb.append(from + " " + to).append('\n');
			hanoi(num-1, by, from, to);
		}
	}
}