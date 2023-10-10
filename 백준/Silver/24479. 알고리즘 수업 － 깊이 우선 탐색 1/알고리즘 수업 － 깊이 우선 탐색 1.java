import java.util.*;
import java.io.*;
public class Main {
	static StringBuilder sb = new StringBuilder("");
	static List<Integer> [] list;
	static boolean[] visited;
	static int n, m, r, cnt;
	static int[] order;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for(int i = 1; i <=n; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i = 1; i <= n; i++) {
			Collections.sort(list[i]);
		}
		order=new int[n+1];
		order[r]=1;
		
		cnt=1;
		dfs(r);
		for(int i = 1; i <= n; i++) {
			System.out.println(order[i]);
		}
	}
	public static void dfs(int r) {
		if(list[r].size()==0) 
			return;
		visited[r]=true;
		for(int i:list[r]) {
			if(!visited[i]) {
				cnt++;
				order[i]=cnt;
				dfs(i);
			}
		}

	}
}