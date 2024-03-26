import java.util.*;
import java.io.*;
public class Main {
	static long mod = 1000000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		long ans = 0;
		//두번째 배열 : 마지막 자릿수
		long[][] r = new long[n+1][11];
		
		for(int i = 1; i <= 9; i++) {
			r[1][i]++;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j<= 9; j++) {
				if(j == 0) {
					r[i][j] = r[i-1][j+1]%mod;
				}
				else if(j == 9) {
					r[i][j] = r[i-1][j-1] % mod;
				}
				else {
					r[i][j] = (r[i-1][j-1]+r[i-1][j+1]) % mod;
				}
			}
		}
		for(int i = 0; i <= 9; i++) {
			ans = (ans + r[n][i]) % mod;
		}
		System.out.println(ans);
	}
}