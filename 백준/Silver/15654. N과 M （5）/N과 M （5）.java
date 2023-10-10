import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static int[] sort;
	static boolean[] visited;
	static Vector<Integer> arr;
	public static void main(String[] args) throws IOException{
		StringTokenizer st;
		String str = br.readLine();
		st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		str = br.readLine();
		st = new StringTokenizer(str);
		sort = new int[n];
		visited = new boolean[n];
		arr = new Vector<Integer>(n);
		//정렬에 사용될 숫자를 저장하는 배열
		for(int i = 0; i < n; i++) {
			int p = Integer.parseInt(st.nextToken());
			sort[i] = p;
			arr.add(p);
		}
		//
		Collections.sort(arr);
		Arrays.sort(sort);
		dfs(0);
	}	
	public static void dfs(int depth) {
		if(depth == m) {
			int p = 0;
			int i = 0;
			while(p < m) {
				System.out.print(sort[p] + " ");
				p++;
			}
			System.out.println();
			return;
		}
		for(int i = 0; i <n; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			sort[depth] = arr.get(i);
			dfs(depth+1);
			visited[i] = false;
		}
	}
}