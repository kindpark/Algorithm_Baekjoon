import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr, res;
	static boolean[] check;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		res = new int[n+1];
		promise(0);
		System.out.println(sb.toString());
	}
	public static void promise(int c) {
		if(c == m) {
			for(int i = 0; i < m; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= n; i++) {
			res[c] = i;
			//check[i] = true;
			promise(c+1);
				
		}
	}
}