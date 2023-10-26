import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long u = 0;

		if(a > b) {
			u = qcd(a, b);
		}
		else {
			u = qcd(b, a);
		}
		for(long i = 0; i < u; i++) {
			bw.write("1");
		}
		bw.flush();
	}
	public static long qcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		else {
			long ret = a % b;
			return qcd(b, ret);
		}
	}
}