import java.util.*;
import java.math.BigInteger;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String length;
		int zero = 0;
		BigInteger r = new BigInteger("1");
		BigInteger p = null;
		for(int i = 1; i <= n; i++) {
			p = new BigInteger(String.valueOf(i));
			r = r.multiply(p);
		}
		length = String.valueOf(r);
		for(int i = length.length() - 1; i >= 0; --i) {
			if(length.charAt(i) != '0') {
				break;
			}
			zero++;
		}
		System.out.println(zero);
	}
}