import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] square = new int[n][m];
		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for(int j = 0; j < m; j++) {
				square[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		int select1 = 0;
		int res = 0;
		int a,b,c,d;
		int len,i,j,Max_len=Math.min(n, m);
		for (len = 1; len <= Max_len; len++) {
			for (i = 0; i <= n - len; i++) {
				for (j = 0; j <= m - len; j++) {
					a = square[i][j];
					b = square[i + len - 1][j];
					c = square[i][j + len - 1];
					d = square[i + len - 1][j + len - 1];
					if (a == b && b == c && c == d)
						res = len;
				}
			}
		}
		System.out.println(res*res);
	}
}