import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] R = new int[T];
		int q = 0;
		int count = 0;
		String[] S = new String[T];
		for(int i = 0; i < T; i++) {
			R[i] = in.nextInt();
			S[i] = in.next();
		}
		String[] u = new String[T];
		for(int i = 0; i < T; i++) {
			char[] g = new char[S[i].length()];
			char[] s = new char[S[i].length() * R[i]];
			for(int j = 0; j < S[i].length(); j++) {
				g[j] = S[i].charAt(j);
			}
			for(int j = 0; j < R[i]*S[i].length(); j++) {
				s[j] = g[q];
				count++;
				if(count == R[i]) {
					count = 0;
					q++;
				}
			}
			q=0;
			u[i] = String.valueOf(s);
		}
		for(int i = 0; i < T; i++) {
			System.out.println(u[i]);
		}
	}
}
