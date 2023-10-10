import java.io.*;
import java.util.*;

public class Main {

	static List<Integer>[] list;
	static int[] memo;
	static boolean[] check;
	static int answer;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		memo = new int[n+1];
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				answer= Integer.MAX_VALUE; 
				check = new boolean[n+1];
				if(i!=j) {
					dfs(i,j,0);
					memo[i] += answer;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int idx =0;
		for(int i=1; i<n+1; i++) {
			if(min > memo[i]) {
				min = memo[i];
				idx =i;
			}
		}
		System.out.println(idx);
		
		
	}
	
	
	static void dfs(int start, int end, int cnt) {
		if(start == end) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		check[start] = true;
		for(int i=0; i<list[start].size(); i++) {
			int next = list[start].get(i);
			if(!check[next]) {
				dfs(next,end, cnt+1);
			}
		}
		check[start]=false;
	}
}