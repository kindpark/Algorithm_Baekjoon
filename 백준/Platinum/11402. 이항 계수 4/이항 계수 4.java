
import java.io.*;
import java.util.StringTokenizer;
//페르마 소정리
//이항 계수 4
public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long n, r;
	static int p;
	static long factorial[];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(in.readLine());
		n = Long.parseLong(st.nextToken());
		r = Long.parseLong(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		System.out.println(combination(n, r, p));
	}
	private static long combination(long n, long r, int p) {
		if (r == 0 || n == r)
			return 1L;
		else if (r == 1 || r == n - 1)
			return n % p;
		factorial = new long[p];
		//길이를 지정해주고, 길이만큼 분자 팩토리얼 생성.
		makeFactorial();
		if (n < p) { // n이 p보다 작다면 페르마의 소정리 적용
			long re = 1L;
			re *= factorial[(int) n];
			re %= p;
			re *= power(factorial[(int) n - (int) r], p - 2);
			re %= p;
			re *= power(factorial[(int) r], p - 2);
			re %= p;
			return re;
		} else {
			long re = 1L;
			while (n > 0 || r > 0) {
				long a = n % p;
				long b = r % p;
				if (a < b) {
					re = 0;
					break;
				}
				//a >= b -> 페르마 소정리 적용
				re *= factorial[(int) a];
				re %= p;
				re *= power(factorial[(int) a - (int) b], p - 2);
				re %= p;
				re *= power(factorial[(int) b], p - 2);
				re %= p;
				n = n / p;
				r = r / p;
			}
			return re;
		}
	}
	private static void makeFactorial() {
		factorial[0] = 1;
		for (int i = 1; i < p; i++) {
			factorial[i] = (factorial[i - 1] * i) % p;
		}
	}
    //외부 참고 : https://kyungsubbb.tistory.com/91
	private static long power(long a, long b) {
		if (b == 0)
			return 1;
		else if (b == 1)
			return a;

		if (b % 2 == 0) {
			long tmp = power(a, b / 2);
			return ((tmp * tmp) % p);
		}
		long tmp = power(a, b - 1) % p;
		return (tmp * a) % p;
	}

}