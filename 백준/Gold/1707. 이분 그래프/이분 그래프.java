import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] vertex;
	static int[] check;
	static String ans;
	static int v;
	public static boolean dfs(int start) {
		for(int i : vertex[start]) {
			if(check[i] == 0) {
				check[i] = check[start] * -1;
				dfs(i);
			}
			else if(check[i] == check[start]) {
				ans = "NO";
				return false;
			}
		}
		if(ans.equals("NO")) {
			return false;
		}
		ans = "YES";
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			vertex = new ArrayList[v+1];
			check = new int[v+1];
			for(int l = 1; l < v+1; l++) {
				vertex[l] = new ArrayList<>();
			}
			int e = Integer.parseInt(st.nextToken());
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				vertex[x].add(y);
				vertex[y].add(x);
			}
			ans = "";
			for(int u = 1; u < v+1; u++) {
				if(check[u] == 0) {
					check[u] = 1;
					boolean ps = dfs(u);
					if(ps == false) {
						break;
					}
				}
			}
			System.out.println(ans);
			ans = "";
		}
	}
}