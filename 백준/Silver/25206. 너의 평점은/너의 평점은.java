import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input, n;
		StringTokenizer st;
		double sum = 0.0, num = 0.0, s = 0.0; 
		for(int i = 0; i < 20; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			st.nextToken();
			num = Double.parseDouble(st.nextToken());
			n = st.nextToken();
			if(!n.equals("P")) {
				if(n.equals("A+")) {
					sum += (4.5 * num);
				}
				if(n.equals("A0")) {
					sum += (4.0 * num);
				}
				if(n.equals("B+")) {
					sum += (3.5 * num);
				}
				if(n.equals("B0")) {
					sum += (3.0 * num);
				}
				if(n.equals("C+")) {
					sum += (2.5 * num);
				}
				if(n.equals("C0")) {
					sum += (2.0 * num);
				}
				if(n.equals("D+")) {
					sum += (1.5 * num);
				}
				if(n.equals("D0")) {
					sum += (1.0 * num);
				}
				if(n.equals("F")) {
					sum += (0.0 * num);
				}
				s += num;
			}
		}
		System.out.println(sum / s);
	}
}