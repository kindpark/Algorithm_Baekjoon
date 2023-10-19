import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static ArrayList<Integer>[] list;
	static int[] sol;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sol = new int[n+1];
		list = new ArrayList[n+1];
		for(int i = 1; i <=n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i< m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			sol[b]++;
		}
		bfs();
		System.out.println(sb.toString());
	}
	public static void bfs() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i <= n; i++) {
			if(sol[i] == 0) {
				pq.add(i);
			}
		}
		while(!pq.isEmpty()) {
			int p = pq.poll();
			unlock(p);
			sb.append(p + " ");
			for(int i : list[p]) {
				if(sol[i] == 0) {
					pq.add(i);
				}
			}
		}
	}
	//몰랐던 부분
	static void unlock(int num) {
		for(int unlock : list[num]) {
			sol[unlock]--;
		}
	}
}
