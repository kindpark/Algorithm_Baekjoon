import java.util.*;
public class Main {
	static ArrayList<Node>[] list;
	static int[] dist, route;
	static int n, m;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		list = new ArrayList[n+1];
		dist = new int[n+1];
		route = new int[n+1];
		check = new boolean[n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			list[a].add(new Node(b, cost));
			
		}
		int arrivex = sc.nextInt();
		int arrivey = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(arrivex, 0));
		
		dist[arrivex] = 0;
		route[arrivex] = 0;
		//탐사
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(!check[n.b]) {
				check[n.b] = true;
			}
			else {
				continue;
			}
			//처음부터 끝까지 있는수만 돌기
			for(int i = 0; i < list[n.b].size(); i++) {
				Node post = list[n.b].get(i);
				if(dist[post.b] > dist[n.b] + post.cost) {
					dist[post.b] = dist[n.b] + post.cost;
					q.offer(new Node(post.b, dist[post.b]));
					route[post.b] = n.b;
				}
			}
		}
		System.out.println(dist[arrivey]);
		ArrayList<Integer> r = new ArrayList<>();
		int cur = arrivey;
		while(cur != 0) {
			r.add(cur);
			cur = route[cur];
		}
		System.out.println(r.size());
		for(int i = r.size() - 1; i>=0; i--) {
			System.out.print(r.get(i) + " ");
		}
 	}
	public static class Node implements Comparable<Node>{
		int b;
		int cost;
		public Node(int b, int cost) {
			this.b = b;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return cost - o.cost;
		}
		
	}
}
