import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long sum = 0;
		long tmp = 0;
		if(b == a) {
			sum = 0;
		}
		else if(b < a) {
			tmp = a;
			a = b;
			b = tmp;
			sum = (b - a) - 1;
		}
		else {
			sum = (b - a) - 1;
		}
		
		System.out.println(sum);
		for(long i = a+1; i < b; i++) {
			sb.append(i + " ");
		}
		
		
		if(sb.length() >= 1) {
			bw.write(sb.toString());
			bw.flush();
		}
		
	}
}