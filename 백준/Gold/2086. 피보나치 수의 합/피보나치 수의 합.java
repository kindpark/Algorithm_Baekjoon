import java.util.*;
import java.io.*;
public class Main {
	//합 = 자릿수에서 두번 더함
	//
	static long[][] fibo = {{0, 1}, {1, 1}};
	static long a = 0, b = 0;
	static final long mod = 1000000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		long[][] res1 = pow(fibo, a+1);
		long[][] res2 = pow(fibo, b+2);
		long resa = res2[1][0];
		long resb = res1[1][0];
		bw.write(String.valueOf((res2[1][0] - res1[1][0]+mod)%mod));
		bw.flush();
		br.close();
		bw.close();
	}
	public static long[][] pow(long[][] tmp, long exp){
		if(exp == 1) {
			return tmp;
		}
		else if(exp == 0){
			long[][] z = {{0,0},{0,0}};
			return z;
		}
		long[][] p = pow(tmp, exp/2);
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				p[i][j] %= mod;
			}
		}
		//단위행렬
		long[][] mul = new long[2][2];
		if(exp % 2 == 1) {
			mul = mul(mul(p,p), tmp);
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					mul[i][j] %= mod;
				}
			}
			return mul;
		}
		else {
			mul =  mul(p, p);
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					mul[i][j] %= mod;
				}
			}
			return mul;
		}
	}
	public static long[][] mul(long[][] tmp1, long[][] tmp2){
		long[][] res = new long[2][2];
		res[0][0] = ((tmp1[0][0] * tmp2[0][0])+(tmp1[0][1] * tmp2[1][0]))%mod;
		res[0][1] = ((tmp1[0][0] * tmp2[0][1]) + (tmp1[0][1] * tmp2[1][1]))%mod;
		res[1][0] = ((tmp1[1][0] * tmp2[0][0]) + (tmp1[1][1] * tmp2[1][0])) % mod;
		res[1][1] = ((tmp1[1][0] * tmp2[0][1]) + (tmp1[1][1] * tmp2[1][1])) % mod;
		return res;
	}
	
}