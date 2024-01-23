import java.util.*;
public class Main {
	static long n, a;
	static long q, r, s, t;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		a = sc.nextLong();
		
		long pi = n - a;
		long mi = 0;
		if(gcd(a, n) != 1) {
			mi= -1;
		}
		else {
			mi = multiple_Inverse(a, n);
			while(mi < 0) {
				mi += n;
			}
		}
		
		System.out.println(pi + " " + mi);
	}
	static long gcd(long n, long a) {
		if(a == 0) {
			return n;
		}
		return gcd(a, n%a);
	}
    //https://ssungkang.tistory.com/entry/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EA%B3%BC-%ED%99%95%EC%9E%A5%EB%90%9C-%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
	static long multiple_Inverse(long n, long a) {
		long r1 = n;
		long r2 = a;
		long s1 = 1;
		long s2 = 0;
		long t1 = 0;
		long t2 = 1;
		while(true) {
			q = r1/r2;
			r = r1 - (q* r2);
			s = s1 - (q*s2);
			t = t1 - (q*t2);
			
			if(r == 0) {
				return s2;
			}
			r1 = r2;
			r2 = r;
			s1 = s2;
			s2 = s;
			t1 = t2;
			t2 = t;
		}
	}
}