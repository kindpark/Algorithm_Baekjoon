//gcd 구한뒤 피보나치 수 구하는걸 요구하고 있는것
import java.util.*;
import java.io.*;
public class Main {
	static final long mod = 1000000007;
	public static long[][] fibo = {{1, 1}, {1, 0}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long[][] res;
		long gcd = 0;
		if(n < m) {
			gcd =gcd(m,n);
		}
		else {
			gcd = gcd(n,m);
		}
		res = matPow(fibo, gcd);
		System.out.println(res[1][0]);
	}

	public static long gcd(long a, long b){
		long n;
		while(b != 0) {
			n = a%b;
			a = b;
			b = n;
		}
		return a;
	}
    public static long[][] matPow(long[][] tmp, long exp) {
        if(exp == 1) {
            return tmp;
        } else if(exp == 0) {
            long[][] zero = {{0, 0},{0, 0}};
            return zero;
        }

        long[][] res = matPow(tmp, exp / 2);
        long[][] f = {{1, 0}, {0,1}};
        if(exp % 2 == 1) {
            return matMul(matMul(res, res), tmp);
        } else {
            return matMul(res, res);
        }
    }
    public static long[][] matMul(long[][] tmp1, long[][] tmp2) {
        long[][] res = new long[2][2];

        res[0][0] = ( (tmp1[0][0] * tmp2[0][0]) + (tmp1[0][1] * tmp2[1][0])) %mod;
        res[0][1] = ( (tmp1[0][0] * tmp2[0][1]) + (tmp1[0][1] * tmp2[1][1])) %mod;
        res[1][0] = ( (tmp1[1][0] * tmp2[0][0]) + (tmp1[1][1] * tmp2[1][0])) %mod;
        res[1][1] = ( (tmp1[1][0] * tmp2[0][1]) + (tmp1[1][1] * tmp2[1][1])) %mod;

        return res;
    }

}