import java.util.*;
import java.io.*;
public class Main {
	static int[] verse;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		verse = new int[n+1];
        for(int i = 1; i <= n; i++) {
			verse[i] = i;
		}
		StringTokenizer st;
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int c = Integer.parseInt(st.nextToken());
				if(c == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		
		for(int i = 1; i < m; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(start != find(now)){
				System.out.println("NO");
				br.close();
				return;
			}
		}
		System.out.println("YES");
		br.close();
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x<y) verse[y] = x;
		else verse[x] = y;
	}
	public static int find(int x) {
		if(verse[x] == x) return x;
		else return verse[x] = find(verse[x]);
	}
	public static boolean isUnion(int x, int y) {
		return find(x)== find(y);
	}
}