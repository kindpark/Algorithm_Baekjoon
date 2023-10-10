import java.io.*;
import java.util.*;
public class Main {
	/*최소 스패닝 트리
	 * 싸이클이 되면 안됨
	 * 모든 점이 이어지면 종료
	*/
	static int[] connect;
	static int v, e;
	static LinkedList<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans = 0;
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new LinkedList<>();
		connect = new int[v+1];
		int a, b, c;
		for(int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c= Integer.parseInt(st.nextToken());
			
			list.add(new Node(a, b, c));
		}
		Collections.sort(list);
		for(int i = 1; i <= v; i++) {
			connect[i] = i;
		}
		for(Node n : list) {
			int A = n.a;
			int B = n.b;
			int C = n.c;
			if(select(A) == select(B)) {
				continue;
			}
			//connect(A,B);
			ans += C;
			int d = select(A);
			int e = select(B);
			
			if(A != B) {
				connect[e] = d;
			}
		}
		System.out.println(ans);
		
	}
	public static int select(int a) {
		if(connect[a] == a) {
			return a;
		}
		else {
			return select(connect[a]);
		}
	}
}
class Node implements Comparable<Node>{
	int a, b, c;
	Node(int a, int b, int val){
		this.a = a;
		this.b = b;
		this.c = val;
	}
	@Override
	public int compareTo(Node n) {
		return this.c - n.c;
	}
}