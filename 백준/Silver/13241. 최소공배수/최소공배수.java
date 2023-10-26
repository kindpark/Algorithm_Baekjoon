import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long res = 0;
		if(a > b) {
			res = qcd(a, b);
		}
		else {
			res = qcd(b, a);
		}
		System.out.println(a * b / res);
	}
	public static long qcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		else {
			long r = a % b;
			return qcd(b, r);
		}
	}
}