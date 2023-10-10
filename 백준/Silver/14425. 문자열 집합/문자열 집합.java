import java.util.*;
public class Main{
	static String[] p;
	static String[] q;
	static int n, m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int ans = 0;
		p = new String[n+1];
		q = new String[m+1];
		for(int i = 1; i < n+1; i++) {
			p[i] = sc.next();
		}
		for(int i = 1; i < m+1; i++) {
			q[i] = sc.next();
		}
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(p[i].equals(q[j])) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}