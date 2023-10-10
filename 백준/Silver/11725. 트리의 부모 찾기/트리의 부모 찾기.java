import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] section; 
	static boolean[] visit;
	static int n;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		String[] s;
		ans = new int[n+1];
		visit = new boolean[n+1];
		section = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			section[i] = new ArrayList<>();
		}
		for(int i = 1; i < n; i++) {
			s = br.readLine().split(" ");
			int parents = Integer.parseInt(s[0]);
			int son = Integer.parseInt(s[1]);
			
			section[parents].add(son);
			section[son].add(parents);
		}
		dfs(1);
		
		for(int i = 2; i < n+1; i++) {
			System.out.println(ans[i]);
		}
		
	}
	public static void dfs(int start) {
		visit[start] = true;
		//배열의 구역마다 숫자가 저장된 위치가 다르기 떄문에 향상된 for문을 사용.
		for(int i : section[start]) {
			if(!visit[i]) {
				ans[i] = start;
				//재귀로 다음 위치를 탐색
				dfs(i);
			}
		}
	}
}