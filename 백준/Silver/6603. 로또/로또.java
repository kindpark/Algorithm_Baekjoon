import java.util.*;
import java.io.*;
public class Main {
	static StringBuilder sb;
	static int[] arr, res;
	static boolean[] check;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = -1;
		StringTokenizer st;
		while(n != 0) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			res = new int[n];
			check = new boolean[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			dfs(0, 0);
			bw.write(sb.toString()+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static void dfs(int start, int c) {
		if(c == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(res[i] + " ");
			}
			sb.append('\n');
		}
		else {
			for(int i = start; i < n; i++) {
				if(!check[i]) {
					res[c] = arr[i];

					check[i] = true;
					dfs(i+1, c+1);
					check[i] = false;
				
				}
			}
		}
	}
}