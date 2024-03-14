import java.util.*;
import java.io.*;
public class Main {
	static final long mod = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long top = factorial(n);
		//dan^(mod-2) 페르마의 소정리, k!(n-k)!
		long bot = factorial(n-k) * factorial(k) % mod;
		long result = (top * binomial(bot, mod-2)) % mod;
		System.out.println(result);
	}
	public static long factorial(int p) {
		long n = 1L;
		while(p > 1) {
			n = (n*p) % mod;
			p--;
		}
		return n;
	}
	public static long binomial(long b, long p) {
		if(p == 1) {
			return b%mod;
		}
		long tmp = binomial(b, p/2) % mod;
		if(p % 2 == 1) {
			return (((tmp * tmp) % mod) * b)%mod;
		}
		else {
			return tmp*tmp % mod;
		}
	}

}