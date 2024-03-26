import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long mod = 1000000000;
		int n = Integer.parseInt(br.readLine());
		long res = 0;
		long[][] r = new long[n+1][11];
		for(int i = 1; i <= 9; i++) {
			r[1][i] = 1;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					r[i][j] = r[i-1][j+1] % mod;
				}
				else if(j == 9) {
					r[i][j] = r[i-1][j-1] % mod;
				}
				else {
					r[i][j] = (r[i-1][j-1] + r[i-1][j+1]) % mod;
				}
			}
		}
		for(int i = 0; i <10; i++) {
			res = (res + r[n][i]) % mod;
		}
		bw.write(String.valueOf(res));
		bw.flush();
	}
}