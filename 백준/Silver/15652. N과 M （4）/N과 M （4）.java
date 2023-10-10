import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		String str = br.readLine();
		st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		dfs(1, 0);
	}
	public static void dfs(int start, int depth) {
		if(depth == m) {
			for(int i :arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i <= n; i++) {
			arr[depth] = i;
			dfs(i, depth+1);
		}
	}
}