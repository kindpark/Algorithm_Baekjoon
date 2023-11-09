import java.util.*;
import java.io.*;
public class Main {
	static int[] arr;
	static int[] copy;
	static boolean[] visit;
	static int n, m;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		copy = new int[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		promise(0);
		System.out.println(sb.toString());
	}
	public static void promise(int u) {
		if(m == u) {
			for(int i = 0; i < m; i++) {
				sb.append(copy[i] + " ");
			}
			sb.append("\n");
		}
		else {
			int p = 0;
			for(int i = 0; i < n; i++) {
				if(!visit[i] && arr[i] != p) {
					copy[u] = arr[i];
					p = copy[u];
					promise(u+1);

					//promise(u+1);
				}
			}
		}
	}

}