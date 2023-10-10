import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		String star[] = new String[n];
		star[0] = "  *  ";
		star[1] = " * * ";
		star[2] = "*****";
		for (int i = 1; 3 * (int)Math.pow(2, i) <= n; i++) {
			print(i, star);
		}
		
		for (int i = 0; i < n; ++i) {
			System.out.println(star[i]);
		}
	}
	
	public static void print(int k, String star[]) {
		int b = 3 * (int)Math.pow(2, k);
		int m = b / 2;
		for (int i = m; i < b; ++i) {
			star[i] = star[i - m] + " " + star[i -m];
		}
		String space = "";
		while (space.length() < m) {
			space += " ";
		}
		for (int i = 0; i < m; ++i) {
			star[i] = space + star[i] + space;
		}
	}
}