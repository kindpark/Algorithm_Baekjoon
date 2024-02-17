import java.util.*;
import java.io.*;
public class Main {
	static String[] number;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		number = new String[n];
		int max = 0;
		for(int i = 0; i < n; i++) {
			number[i] = br.readLine();
			max = Math.max(Integer.parseInt(number[i]), max);
		}
		Arrays.sort(number, (o1, o2)->{
			String c1 = o1 + o2;
			String c2 = o2 + o1;
			return c2.compareTo(c1);
			}
		);
		StringBuilder sb = new StringBuilder();
		boolean judge = true;
		for(String s : number) {
			sb.append(s);
			if(Integer.parseInt(s) == max && judge) {
				for(int j = 0; j < m - n; j++) {
					sb.append(s);
				}
				judge = false;
			}
		}
		System.out.println(sb.toString());
	}
}