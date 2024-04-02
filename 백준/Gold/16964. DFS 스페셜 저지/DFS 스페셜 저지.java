import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static boolean[] check;
	static ArrayList<ArrayList<Integer>> list;
	static int[] expect, parent;
	static String s1, s2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		check = new boolean[n+1];
		expect =new int[n+1];
		parent = new int[n+1];
		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			expect[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, 0);
		System.out.println(1);
		br.close();
	}
	public static void dfs(int x, int index) {
		check[x] = true;
		//정렬 기준 정하기
		int cnt = 0;
		for(int i : list.get(x)) {
			if(!check[i]) {
				check[i]=true;
				parent[i] = x;
				cnt++;
			}
		}
		index++;
		for(int i = 0; i < cnt; i++) {
			int next = expect[index];
			if(parent[next] != x) {
				System.out.println(0);
				System.exit(0);
			}
			dfs(next, index);
		}
	}
}
