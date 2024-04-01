import java.util.*;
import java.io.*;
public class Main {
	static final int mod = 1000000007;
	static final long[][] fibo = {{0, 1},{1,1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long res;
 		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			res = memo(fibo,gcd(a, b));
			bw.write(String.valueOf(res)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int gcd(int a, int b) {
		int n = 0;
		while(b != 0) {
			n = a%b;
			a = b;
			b = n;
		}
		return a;
	}
	public static long memo(long[][] tmp, long exp) {
		if(exp <= 1) {
			return exp;
		}
		else {
			//단위행렬
			long[][] ans = {{1,0},{0,1}};
			while(exp > 0) {
				if(exp % 2 == 1) {
					ans = multiple(tmp, ans);
				}
				tmp = multiple(tmp, tmp);
				exp /= 2;
			}
			return ans[1][0];
		}
	}
	public static long[][] multiple(long[][] a, long[][] b){
		long[][] sum = new long[2][2];
		sum[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0]))%mod;
		sum[0][1] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1]))%mod;
		sum[1][0] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0]))%mod;
		sum[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1]))%mod;
		return sum;
	}
}
