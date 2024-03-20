//gcd 구한뒤 피보나치 수 구하는걸 요구하고 있는것
//행렬로 했더니 자꾸 틀려서 행렬 메모이제이션? 방법이 있다는 걸 알게 됨
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
		long res;
		long gcd = 0;
		if(n < m) {
			gcd =gcd(m,n);
		}
		else {
			gcd = gcd(n,m);
		}

		res = memo(fibo, gcd);
		System.out.println(res);
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
    public static long memo(long[][] tmp, long exp){
    	if(exp <= 1) {
    		return exp;
    	}
    	else {
    		//단위 행렬
    		long[][] ans = {{1,0},{0,1}};
    		while(exp > 0) {
    			if(exp % 2 == 1) {
    				ans = matMulti(ans, tmp);
    			}
    			tmp = matMulti(tmp, tmp);
    			exp /= 2;
    		}
    		return ans[1][0];
    	}
    }
    public static long[][] matMulti(long[][] tmp1, long[][] tmp2){
    	long[][] ans = new long[2][2];
    	for(int i = 0; i < 2; i++) {
    		for(int j = 0; j < 2; j++) {
    			for(int k = 0; k < 2; k++) {
    				ans[i][j] += tmp1[i][k] * tmp2[k][j];
    			}
    			ans[i][j] %= mod;
    		}
    	}
    	return ans;
    }
}