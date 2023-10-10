import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] relation;
	static boolean[] check;
	//아무것도 해당 안될떄 그냥 -1이 출력되게
	static int ans = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int m = Integer.parseInt(br.readLine());
		relation = new ArrayList[n+1];
		check = new boolean[n+1];
		for(int i = 1; i < n+1; i++) {
			relation[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			s = br.readLine().split(" ");
			int father = Integer.parseInt(s[0]);
			int son = Integer.parseInt(s[1]);
			relation[father].add(son);
			relation[son].add(father);
		}
		
		dfs(a, b, 0);
		System.out.println(ans);
	}
	public static void dfs(int start, int end, int count) {
		if(start == end) {
			ans = count;
			return;
		}
		check[start] = true;
		for(int i = 0; i < relation[start].size(); i++) {
			int browser = relation[start].get(i);
			//방문했는지 확인
			if(!check[browser]) {
				dfs(browser, end, count+1);
			}
		}
	}
}