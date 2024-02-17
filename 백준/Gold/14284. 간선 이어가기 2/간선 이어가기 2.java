import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int start, end;
	static ArrayList<Node> graph[];
	static int[] dist;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		dist = new int[n+1];
		check = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		for(int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		djikstra();
		System.out.println(dist[end]);
	}
	static void djikstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(!check[n.b]) {
				check[n.b] = true;
			}
			else {
				continue;
			}
			for(int i = 0; i < graph[n.b].size(); i++) {
				Node post = graph[n.b].get(i);
				if(dist[post.b] > dist[n.b] + post.e) {
					dist[post.b] = dist[n.b] + post.e;
					pq.add(new Node(post.b, dist[post.b]));
				}
			}
		}
	}
	static class Node implements Comparable<Node>{
		int b;
		int e;
		public Node(int b, int e) {
			this.b = b;
			this.e = e;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return e - o.e;
		}
	}
}
