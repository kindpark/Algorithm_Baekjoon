import java.io.*;
import java.util.*;

public class Main {
	static int MOD = 1000000007;

	public static long res(long a, long b) {
		//x는 수 y는 몇 번 제곱
		if (b == 1) { 
			return a;
		}
		long temp = res(a, b / 2);
		if (b % 2 == 0) {
			return temp % MOD * temp % MOD;
		}
		return temp % MOD * temp % MOD * a % MOD;
	}
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long ans = res(a%MOD, b);
		
		System.out.println(ans);
		
	}
}