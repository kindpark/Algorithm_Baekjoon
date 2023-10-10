import java.io.*;
import java.util.*;

public class Main {

	private static BufferedReader br;
	private static StringTokenizer st;
	
	private static int N, M, R;
	private static List<Integer> []list;
	
	public static void main(String[] args) throws IOException {
		br=new BufferedReader(new InputStreamReader(System.in));
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		list=new ArrayList[N+1];
		for(int i=1;i<=N;i++) list[i]=new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		for(int i=1;i<=N;i++) Collections.sort(list[i]);
		bfs(R);
	}

	private static void bfs(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		boolean []visited=new boolean[N+1];
		visited[x]=true;
		
		int cnt=0;
		int []order=new int[N+1];
		while(!queue.isEmpty()) {
			int q=queue.poll();
			cnt++;
			order[q]=cnt;
			
			for(int i:list[q]) {
				if(!visited[i]) {
					visited[i]=true;
					queue.add(i);
				}
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.println(order[i]);
		}
	}
}
//출처: https://sujin7837.tistory.com/453 리스트 배열 참고