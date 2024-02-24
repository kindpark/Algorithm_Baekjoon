import java.io.*;
import java.util.*;
public class Main {
	static int n, e;
	static ArrayList<Node>[] list;
	static int[] dist;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		int ans1 = 0, ans2 = 0;
		int ans = 0;
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		dist = new int[n+1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		ans1 += djikstra(1, a);
		ans1 += djikstra(a, b);
		ans1 += djikstra(b, n);
		ans2 += djikstra(1, b);
		ans2 += djikstra(b, a);
		ans2 += djikstra(a, n);
		ans = Math.min(ans1, ans2);
		if(ans >= 20000000) {
			System.out.println(-1);
		}
		else
			System.out.println(ans);
	}
	static int djikstra(int a, int b) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(a, 0));
		boolean[] visited = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			dist[i] = 20000000;
		}
		dist[a] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(!visited[n.end]) {
				visited[n.end] = true;
				for(int i = 0; i < list[n.end].size(); i++) {
					Node next = list[n.end].get(i);
					if(!visited[next.end] && dist[next.end] > dist[n.end] + next.cost) {
						dist[next.end] = dist[n.end] + next.cost;
						pq.add(new Node(next.end, dist[next.end]));
					}
				}
			}
		}
		return dist[b];
	}
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		Node(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return cost - o.cost;
		}
		
	}
}