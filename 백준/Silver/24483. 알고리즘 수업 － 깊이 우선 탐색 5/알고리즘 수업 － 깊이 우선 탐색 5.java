
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder("");
    static BufferedReader br;
    static StringTokenizer st;
	static List<Integer> [] list;
	static boolean[] visited;
	static int n, m, r, cnt;
	static long[] order;
    static long[] dep;
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[n+1];
		for(int i=1;i<=n;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1;i<=n;i++) Collections.sort(list[i]);
		
		boolean []visited=new boolean[n+1];
		visited[r]=true;
		
		order=new long[n+1];
		cnt=1;
		order[r]=cnt;
		dep=new long[n+1];
		for(int i=1;i<=n;i++) 
			dep[i]=-1;
		dep[r]=0;
		dfs(r, visited, 1);
		
		long sum=0;
		for(int i=1;i<=n;i++) {
			sum+=order[i]*dep[i];
		}
		System.out.println(sum);
	}

	private static void dfs(int x, boolean []visited, int depth) {
		if(list[x].size()==0) return;
		
		for(int i:list[x]) {
			if(!visited[i]) {
				visited[i]=true;
				cnt++;
				order[i]=cnt;
				dep[i]=depth;
				dfs(i, visited, depth+1);
			}
		}
	}
}