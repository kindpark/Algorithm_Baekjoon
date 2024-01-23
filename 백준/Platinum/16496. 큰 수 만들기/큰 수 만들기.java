import java.util.*;
import java.io.*;
public class Main {
	static String[] number;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		number = new String[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			number[i] = st.nextToken();
		}
		Arrays.sort(number, (o1, o2)->{
			String c1 = o1 + o2;
			String c2 = o2 + o1;
			return c1.compareTo(c2);
			}
		);
		//입력된게 0밖에 없을 경우
		if(number[n-1].equals("0")) {
			System.out.println(0);
		}
		else {
			for(int i = n-1; i >= 0; i--) {
				System.out.print(number[i]);
			}
		}
	}
}