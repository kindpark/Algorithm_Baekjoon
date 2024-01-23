import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Node>[] list;
	static int n, m;
	static int[] dist;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		dist = new int[n+1];
		check = new boolean[n+1];
		for(int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new Node(e, c));
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(!check[n.end]) {
				check[n.end] = true;
			}
			else {
				continue;
			}
			for(int i = 0; i < list[n.end].size(); i++) {
				Node post = list[n.end].get(i);
				if(dist[post.end] > dist[n.end] + post.cost) {
					dist[post.end] = dist[n.end] + post.cost;
					pq.add(new Node(post.end, dist[post.end]));
				}
			}
		}
		System.out.println(dist[e]);
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