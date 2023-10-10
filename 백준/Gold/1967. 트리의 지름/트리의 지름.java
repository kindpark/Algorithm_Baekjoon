import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static List<Node>[] input;
	private static int end;
	private static int max;
	private static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		
		input = new List[N+1];
		for(int i=1; i<=N; i++) {
			input[i] = new ArrayList<Node>();
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			input[a].add(new Node(b, c));
			input[b].add(new Node(a, c));
		}
		
		visit = new boolean[N+1];
		max = Integer.MIN_VALUE;
		dfs(1, 0);
		
		visit = new boolean[N+1];
		max = Integer.MIN_VALUE;
		dfs(end, 0);
		
		bw.append(String.valueOf(max));
		bw.close();
	}
	
	private static void dfs(int cur, int dist) {
		if(max < dist) {
			end = cur;
			max = dist;
		}
		
		visit[cur] = true;
		
		for(Node next : input[cur]) {
			if(visit[next.node]) {
				continue;
			}
			dfs(next.node, dist + next.dist);
		}
	}

	public static class Node {
		public int node;
		public int dist;
		
		public Node(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}
}