import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		long[] pibo = new long[41];
		long[] pibo2 = new long[41];
		pibo[0] = 0;
		pibo[1] = 1;
		pibo2[0] = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i = 2; i <=40; i++) {
			pibo[i] = pibo[i-1] + pibo[i-2];
			pibo2[i] = pibo2[i-1] + pibo2[i-2];
		}
		int a;
		for(int i = 0; i < n; i++) {
			a = Integer.parseInt(br.readLine());
			bw.write(pibo2[a] + " " + pibo[a]+"\n");
		}
		bw.flush();
	}
}
