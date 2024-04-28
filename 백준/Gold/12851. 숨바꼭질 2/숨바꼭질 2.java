import java.util.*;
import java.io.*;
public class Main {
	static boolean[] visit;
	static int n, k; 
	static StringBuilder sb = new StringBuilder();
	static long sec;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		visit = new boolean[2000001];
		bfs(n);
		System.out.println(sec);
		//System.out.println(sb.toString());
		Arrays.fill(visit, false);
		System.out.println(bfs2(n));
	}
	public static void bfs(int n) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n, 0));
		while(!q.isEmpty()) {
			Node nd = q.poll();
			visit[nd.n] = true;
			if(nd.n == k) {
				sec = nd.sec;
				break;
			}
			if(nd.n*2 >= 0)
			if(nd.n * 2 <= 100000 && !visit[nd.n*2]) {
				q.add(new Node(nd.n * 2, nd.sec+1));
			}
			if(nd.n+1 >= 0)
			if(nd.n + 1 <= 100000 && !visit[nd.n+1]) {
				q.add(new Node(nd.n + 1, nd.sec+1));
			}
			if(nd.n-1 >= 0)
			if(nd.n - 1 <= 100000 && !visit[nd.n-1]) {
				q.add(new Node(nd.n-1, nd.sec+1));
			}
		}
	}
	public static int bfs2(int n) {
		int cnt = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n, 0));
		while(!q.isEmpty()) {
			Node nd = q.poll();
			visit[nd.n] = true;
			if(nd.n == k && nd.sec == sec) {
				cnt++;
			}
			if(nd.n*2 >= 0)
			if(nd.n * 2 <= 100000 && !visit[nd.n*2]) {
				q.add(new Node(nd.n * 2, nd.sec+1));
			}
			if(nd.n+1 >= 0)
			if(nd.n + 1 <= 100000 && !visit[nd.n+1]) {
				q.add(new Node(nd.n + 1, nd.sec+1));
			}
			if(nd.n-1 >= 0)
			if(nd.n - 1 <= 100000 && !visit[nd.n-1]) {
				q.add(new Node(nd.n-1, nd.sec+1));
			}
		}
		return cnt;
	}
	static class Node {
		int n;
		int sec;
		Node(int n, int sec){
			this.n = n;
			this.sec = sec;
		}
	}
}
